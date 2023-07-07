package tr.com.yusuf.complex.types;

import java.sql.Date;

public class SatisContractComplex {

	private int satisId;
	private String musteriId;
	private String hesapAdi;
	private String hesapSoyadi;
	private String musteriAd;
	private String musteriSoyad;
	private int satisAdet;
	private String urunAdi;
	private Date satisTarih;

	public SatisContractComplex() {
		// TODO Auto-generated constructor stub
	}

	public SatisContractComplex(int satisId, String musteriId, String hesapAdi, String hesapSoyadi, String musteriAd,
			String musteriSoyad, int satisAdet, String urunAdi, Date satisTarihi) {
		this.satisId = satisId;
		this.musteriId = musteriId;
		this.hesapAdi = hesapAdi;
		this.hesapSoyadi = hesapSoyadi;
		this.musteriAd = musteriAd;
		this.musteriSoyad = musteriSoyad;
		this.satisAdet = satisAdet;
		this.urunAdi = urunAdi;
		this.satisTarih = satisTarihi;
	}

	public int getSatisId() {
		return satisId;
	}

	public void setSatisId(int satisId) {
		this.satisId = satisId;
	}

	public String getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(String musteriId) {
		this.musteriId = musteriId;
	}

	public String getHesapAdi() {
		return hesapAdi;
	}

	public void setHesapAdi(String hesapAdi) {
		this.hesapAdi = hesapAdi;
	}

	public String getHesapSoyadi() {
		return hesapSoyadi;
	}

	public void setHesapSoyadi(String hesapSoyadi) {
		this.hesapSoyadi = hesapSoyadi;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	public String getMusteriSoyad() {
		return musteriSoyad;
	}

	public void setMusteriSoyad(String musteriSoyad) {
		this.musteriSoyad = musteriSoyad;
	}

	public int getSatisAdet() {
		return satisAdet;
	}

	public void setSatisAdet(int satisAdet) {
		this.satisAdet = satisAdet;
	}

	public Date getSatisTarih() {
		return this.satisTarih;
	}

	public void setSatisTarih(Date satisTarih) {
		this.satisTarih = satisTarih;
	}

}
