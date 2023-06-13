package tr.com.yusuf.types;

public class MusteriContract {

	private int id;
	private String ad;
	private String soyad;
	private String telefon;
	private String adres;
	private int sehirId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return this.soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getSehirId() {
		return this.sehirId;
	}

	public void setSehirId(int sehirId) {
		this.sehirId = sehirId;
	}

	@Override
	public String toString() {
		return String.format("%d %s %s %s %s %d", id, ad, soyad, telefon, adres);
	}
}