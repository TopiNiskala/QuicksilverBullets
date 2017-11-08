package fi.hh.swd.projekti.kysely.bean;

public class Kysymys {
	private int kysymysId;
	private String kysymys;
	
	public Kysymys() {
		kysymysId = 0;
		kysymys = null;
	}
	
	public Kysymys(int kysymysId, String kysymys) {
		this.kysymysId = kysymysId;
		this.kysymys = kysymys;
	}

	public int getKysymysId() {
		return kysymysId;
	}

	public void setKysymysId(int kysymysId) {
		this.kysymysId = kysymysId;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + "]";
	}
	
}