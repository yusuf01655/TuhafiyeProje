	
	
	CREATE TABLE sehirler(
	    PRIMARY KEY(sehir_id),
	    sehir_id INT AUTO_INCREMENT NOT NULL,
	    ad       VARCHAR(255) DEFAULT 'ad'

	);
	    CREATE TABLE musteriler(
	    PRIMARY KEY(musteri_id),
	    musteri_id INT          AUTO_INCREMENT  NOT NULL,
	    ad         VARCHAR(255) DEFAULT 'ad',
	    soyad      VARCHAR(255) DEFAULT 'soyad',
	    telefon    VARCHAR(255) DEFAULT 'telefon',
	    adres      VARCHAR(255) DEFAULT 'adres',
	    sehir_id   INT          DEFAULT 1,
	    
	    FOREIGN KEY(sehir_id) REFERENCES sehirler(sehir_id)
	    
	);
	CREATE TABLE personeller(
	    PRIMARY KEY (personel_id),
	    personel_id INT AUTO_INCREMENT NOT NULL,
	    ad          VARCHAR(255) DEFAULT 'ad',
  	    soyad       VARCHAR(255) DEFAULT 'soyad',
	    email       VARCHAR(255) DEFAULT 'ornek@ornek.com'
	   
	);
	CREATE TABLE  yetkiler(
	    PRIMARY KEY (yetki_id),
	    yetki_id INT  AUTO_INCREMENT NOT NULL,
	    ad       VARCHAR(255) DEFAULT 'ad'
	);
	
	CREATE TABLE hesaplar(
            PRIMARY KEY(hesap_id),
	    hesap_id    INT          AUTO_INCREMENT NOT NULL,
	    yetki_id    INT          DEFAULT 1,
	    sifre       VARCHAR(255) DEFAULT 'sifre' ,
	    personel_id INT          DEFAULT 1,
	   
	    FOREIGN KEY(yetki_id)    REFERENCES yetkiler(yetki_id),
	    FOREIGN KEY(personel_id) REFERENCES personeller(personel_id)
	);
	
	CREATE TABLE ust_kategoriler(
	    PRIMARY KEY(ust_kategori_id),
	    ust_kategori_id INT NOT NULL,
	    adi             VARCHAR(255) DEFAULT 'ad'
  	    
	);
	
	CREATE TABLE kategoriler(
	    PRIMARY KEY (kategori_id),
	    kategori_id     INT          AUTO_INCREMENT NOT NULL,
	    ad              VARCHAR(255) DEFAULT 'ad',
	    ust_kategori_id INT          DEFAULT 1,
	    FOREIGN KEY(ust_kategori_id) REFERENCES ust_kategoriler(ust_kategori_id)
	);
	
	CREATE TABLE  urunler(
            PRIMARY KEY (urun_id),
	    urun_id     INT AUTO_INCREMENT NOT NULL,
	    ad          VARCHAR(255) DEFAULT 'ad' ,
	    kategori_id INT DEFAULT 1,
	    tarih       DATE DEFAULT '1990-01-01 00:00:00.00000',
	    fiyat       DECIMAL DEFAULT 0,
	    FOREIGN KEY(kategori_id) REFERENCES kategoriler(kategori_id)
	);
	
	CREATE TABLE  satislar(
	    PRIMARY KEY (satis_id),
	    satis_id    INT  AUTO_INCREMENT NOT NULL,
	    musteri_id  INT  DEFAULT 1,
	    personel_id INT  DEFAULT 1,
	    urun_id     INT  DEFAULT 1,
	    adet        INT  DEFAULT 1,
	    tarih       DATE DEFAULT '1990-01-01 00:00:00.00000',
	    FOREIGN KEY(musteri_id)  REFERENCES musteriler(musteri_id),
	    FOREIGN KEY(personel_id) REFERENCES personeller(personel_id),
	    FOREIGN KEY(urun_id)     REFERENCES urunler(urun_id)
	);
	
	CREATE TABLE  stoklar(
	    PRIMARY KEY(stok_id),
	    stok_id     INT AUTO_INCREMENT NOT NULL,
	    personel_id INT DEFAULT 1,
	    urun_id     INT DEFAULT 1,
	    tarih       DATE DEFAULT '1990-01-01 00:00:00.00000',
	    adet        INT DEFAULT 1,
	    FOREIGN KEY(personel_id) REFERENCES personeller(personel_id),
	    FOREIGN KEY(urun_id)     REFERENCES urunler(urun_id)
	);
	
	ALTER TABLE hesaplar
	ADD COLUMN ad VARCHAR(255) DEFAULT 'ad',
	ADD COLUMN soyad VARCHAR(255) DEFAULT 'soyad',
	ADD COLUMN eposta VARCHAR(255) DEFAULT 'ornek@eposta.com';
	
	
	

	