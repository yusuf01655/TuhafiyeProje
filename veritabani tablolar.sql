	CREATE TABLE musteriler(
	    musteri_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad         VARCHAR(255),
	    soyad      VARCHAR(255),
	    telefon    VARCHAR(255),
	    adres      VARCHAR(255),
	    sehir_id   INT,
	    FOREIGN_KEY(sehir_id) REFERENCES sehir(sehir_id)
	);
	
	CREATE TABLE hesaplar(
	    hesap_id    INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    yetki_id    INT,
	    sifre       VARCHAR(255),
	    personel_id INT,
	    FOREIGN KEY(yetki_id)    REFERENCES yetki(yetki_id),
	    FOREIGN KEY(hesap_id)    REFERENCES hesap(hesap_id),
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id)
	);
	
	CREATE TABLE kategoriler(
	    kategori_id     INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad              VARCHAR(255),
	    ust_kategori_id INT,
	    FOREIGN KEY(ust_kategori_id) REFERENCES ust_kategori(ust_kategori_id)
	);
	
	CREATE TABLE personeller(
	    personel_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad          VARCHAR(255)
  	    soyad       VARCHAR(255),
	    email       VARCHAR(255),
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id)
	);
	
	CREATE TABLE  satislar(
	    satis_id    INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    musteri_id  INT,
	    personel_id INT,
	    urun_id     INT,
	    adet        INT,
	    tarih       DATE,
	    FOREIGN KEY(musteri_id)  REFERENCES musteri(musteri_id),
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id),
	    FOREIGN KEY(urun_id)     REFERENCES urun(urun_id)
	);
	
	CREATE TABLE  stoklar(
	    stok_id     INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    personel_id INT,
	    urun_id     INT,
	    tarih       DATE,
	    adet        INT,
	    FOREIGN KEY(personel_id) REFERENCES personel(personel_id),
	    FOREIGN KEY(urun_id)     REFERENCES urun(urun_id)
	);
	
	CREATE TABLE  urunler(
	    urun_id     INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad          VARCHAR(255),
	    kategori_id INT,
	    tarih       DATE,
	    fiyat       DECIMAL,
	    FOREIGN KEY(kategori_id) REFERENCES kategori(kategori_id)
	);
	
	CREATE TABLE  yetkiler(
	    yetki_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad       VARCHAR(255)
	);
	
	CREATE TABLE sehirler(
	    sehir_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	    ad       VARCHAR(255);
	);
	CREATE TABLE ust_kategoriler(
	    ust_kategori_id INT,
	    adi             VARCHAR(255)
	);