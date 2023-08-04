package tr.com.yusuf.types;

import java.util.Date;

public class SatisContract {
	private int satisId;
	private int musteriId;
	private int hesapId;
	private int urunId;
	private int adet;
	private Date tarih;

	public SatisContract() {
		// TODO Auto-generated constructor stub
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date date) {
		this.tarih = date;
	}

	public int getSatisId() {
		return this.satisId;
	}

	public void setSatisId(int id) {
		this.satisId = id;
	}

	public int getMusteriId() {
		return this.musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}

	public int getUrunId() {
		return this.urunId;
	}

	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}

	public int getHesapId() {
		return hesapId;
	}

	public void setHesapId(int hesapId) {
		this.hesapId = hesapId;
	}

}
