INSERT INTO kysely (kyselyId, kyselyName, kyselyDesc)
VALUES
(1,
'Kysely opiskelijoiden pys�k�intimahdollisuuksista',
'Haluamme selvitt�� ovatko opiskelijat tyytyv�isi�
Pasilan kampuksen tarjoamiin pys�k�intimahdollisuuksiin ja pit�isik� koulun tarjota paremmat pys�k�intipalvelut
opiskelijoille.');

INSERT INTO kysymys (kysymysId, kysymys, kysymysType, kyselyId)
VALUES
(1, 'Miten kuvailisit Haaga-Helian Pasilan kampuksen tarjoamia pys�k�inti mahdollisuuksia opiskelijoille?', 'text', 1);
(2, 'Miten parantaisit koulun tarjoamia pys�k�intipalveluita?', 'text', 1);
(3, 'Mik� on mielest�si haastavinta koululle/koulun l�helle pys�k�imisess�?', 'text', 1);
(4, 'Onko koululle/koulun l�helle pys�k�inti vaikeaa?', 'radio', 1);


INSERT INTO vastaus (vastausId, vastaus, kysymysId)
VALUES
(1, 'En tied�, en autoile', 1);
(2, 'En tied�, en autoile', 2);
(3, 'Parkkipaikkoja ei ole l�hell�, tai ne ovat kalliita', 3);
(4, 'Kyll�', 4);

INSERT INTO valinta (valintaId, valintaName, kysymysId)
VALUES
(1, 'Kyll�', 4);
(2, 'Ei', 4);

INSERT INTO kayttaja (kayttajaId, kayttajaName, kayttajaPassword, kayttajaRole)
VALUES
(1, 'Master', 'salasana', 'Admin');

INSERT INTO kayttajanKysely (kayttajankyselyId, kyselyId, kayttajaId)
VALUES
(1, 1, 1);