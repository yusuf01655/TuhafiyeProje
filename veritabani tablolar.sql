	CREATE TABLE musteriler(
	    musteri_id INT          DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad         VARCHAR(255) DEFAULT 'ad',
	    soyad      VARCHAR(255) DEFAULT 'soyad',
	    telefon    VARCHAR(255) DEFAULT 'telefon',
	    adres      VARCHAR(255) DEFAULT 'adres',
	    sehir_id   INT          DEFAULT 1,
	    FOREIGN_KEY(sehir_id) REFERENCES sehir(sehir_id)
	);
	
	CREATE TABLE hesaplar(
	    hesap_id    INT          DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    yetki_id    INT          DEFAULT 1,
	    sifre       VARCHAR(255) DEFAULT 'sifre' ,
	    personel_id INT          DEFAULT 1,
	    FOREIGN KEY(yetki_id)    REFERENCES yetki(yetki_id),
	    FOREIGN KEY(hesap_id)    REFERENCES hesap(hesap_id),
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id)
	);
	
	CREATE TABLE kategoriler(
	    kategori_id     INT          DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad              VARCHAR(255) DEFAULT 'ad',
	    ust_kategori_id INT          DEFAULT 1,
	    FOREIGN KEY(ust_kategori_id) REFERENCES ust_kategori(ust_kategori_id)
	);
	
	CREATE TABLE personeller(
	    personel_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad          VARCHAR(255) DEFAULT 'ad',
  	    soyad       VARCHAR(255) DEFAULT 'soyad',
	    email       VARCHAR(255) DEFAULT 'ornek@ornek.com',
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id)
	);
	
	CREATE TABLE  satislar(
	    satis_id    INT  DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    musteri_id  INT  DEFAULT 1,
	    personel_id INT  DEFAULT 1,
	    urun_id     INT  DEFAULT 1,
	    adet        INT  DEFAULT 1,
	    tarih       DATE DEFAULT '1990-01-01 00:00:00.00000',
	    FOREIGN KEY(musteri_id)  REFERENCES musteri(musteri_id),
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id),
	    FOREIGN KEY(urun_id)     REFERENCES urun(urun_id)
	);
	
	CREATE TABLE  stoklar(
	    stok_id     INT DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    personel_id INT DEFAULT 1,
	    urun_id     INT DEFAULT 1,
	    tarih       DATE DEFAULT '1990-01-01 00:00:00.00000',
	    adet        INT DEFAULT 1,
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id),
	    FOREIGN KEY(urun_id)     REFERENCES urun(urun_id)
	);
	
	CREATE TABLE  urunler(
	    urun_id     INT DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad          VARCHAR(255) DEFAULT 'ad' ,
	    kategori_id INT DEFAULT 1,
	    tarih       DATE DEFAULT '1990-01-01 00:00:00.00000',
	    fiyat       DECIMAL DEFAULT 0,
	    FOREIGN KEY(kategori_id) REFERENCES kategori(kategori_id)
	);
	
	CREATE TABLE  yetkiler(
	    yetki_id INT DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad       VARCHAR(255) DEFAULT 'ad'
	);
	
	CREATE TABLE sehirler(
	    sehir_id INT DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad       VARCHAR(255) DEFAULT 'ad';
	);
	CREATE TABLE ust_kategoriler(
	    ust_kategori_id INT DEFAULT 1,
	    adi             VARCHAR(255) DEFAULT 'ad'
	);