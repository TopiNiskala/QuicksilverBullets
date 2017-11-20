package fi.hh.swd.projekti.kysely.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.hh.swd.projekti.kysely.bean.Kysely;
import fi.hh.swd.projekti.kysely.bean.Kysymys;

@Repository
public class KysymysDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

public void kysymysSave(final int kyselyId, Kysymys kysymys) {
		final String sql = "INSERT INTO kysymys (kysymys, kyselyId) values(?,?)";
		List<Kysymys>kysymykset= new ArrayList();
		kysymykset.add(kysymys);
		Kysely kysely =  new Kysely(kyselyId,kysymykset);
		final String kysymysName= kysely.getKysymykset().get(0).getKysymys();
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "kysymysId" });
				ps.setString(1, kysymysName);
				ps.setInt(2, kyselyId);
				return ps;
			}
		}, idHolder);
		kysymys.setKysymysId(idHolder.getKey().intValue());
	}

	//Tätä muokkaan (poistin id parametrin, muutin sql lausetta)
	public List<Kysely> kysymysGetAll(int kyselyId) {
		String sql = "SELECT kysymysId, kysymys, kyselyId FROM kysymys WHERE kyselyId = ?";
		Object [] parametrit = new Object [] {kyselyId};
		RowMapper<Kysely> mapper = new KysymysRowMapper();
		List<Kysely> kysymykset = jdbcTemplate.query(sql, parametrit, mapper);
		return kysymykset;
	}
	
	public Kysely kysymysGetOne( int kysymysId ) {
		String sql = "SELECT kysymysId, kysymys, kyselyId FROM kysymys WHERE kysymysId = ?";
		Object[] parametrit = new Object[] { kysymysId };
		RowMapper<Kysely> mapper = new KysymysRowMapper();
		Kysely kysymys = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return kysymys;
	}

}