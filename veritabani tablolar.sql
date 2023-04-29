	create table  musteri(
	musteri_id int auto_increment primary key not null,
	ad varchar(255),
	soyad varchar(255),
	telefon varchar(255),
	adres varchar(255),
	sehir_id int,
	foreign key (sehir_id) references sehir(sehir_id)
	);
	
	create table  hesap(
	hesap_id int auto_increment primary key not null,
	yetki_id int,
	sifre varchar(255),
	personel_id int,
	foreign key (yetki_id) references yetki(yetki_id),
	foreign key (hesap_id) references hesap(hesap_id),
	foreign key (personel_id) references personel(personel_id)
	);
	
	create table  kategori(
	kategori_id int auto_increment primary key not null,
	adi varchar(255),
	ust_kategori_id int, 
	foreign key (ust_kategori_id) references ust_kategori(ust_kategori_id)
	);
	
	create table  personel(
	personel_id int auto_increment primary key not null,
	ad varchar(255)
	soyad varchar(255),
	email varchar(255),
	foreign key(personel_id) references personel(personel_id)
	);
	
	create table  satis(
	satis_id int auto_increment primary key not null,
	musteri_id int,
	personel_id int,
	urun_id int,
	adet int,
	tarih date,
	foreign key (musteri_id) references musteri(musteri_id),
	foreign key(personel_id) references personel(personel_id),
	foreign key(urun_id) references urun(urun_id));
	
	create table  stok(
	stok_id int auto_increment primary key not null,
	personel_id int,
	urun_id int,
	tarih date,
	adet int,
	foreign key(personel_id) references personel(personel_id),
	foreign key(urun_id) references urun(urun_id)
	);
	
	create table  urun(
	urun_id int auto_increment primary key not null,
	ad varchar(255),
	kategori_id int,
	tarih date,
	fiyat decimal,
	foreign key(kategori_id) references kategori(kategori_id));
	
	create table  yetki(
	yetki_id int auto_increment primary key not null,
	adi varchar(255));
	
	create table sehir(
		sehir_id int auto_increment primary key not null,
		ad varchar(255);
	);
	create table ust_kategori(
		ust_kategori_id int,
		adi varchar(255)
	);