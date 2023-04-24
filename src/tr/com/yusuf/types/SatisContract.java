package tr.com.yusuf.types;

import java.sql.Date;

public class SatisContract {
	private int id;
	private int musteriId;
	private int personelId;
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

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

}
