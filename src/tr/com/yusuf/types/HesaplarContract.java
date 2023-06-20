package tr.com.yusuf.types;

public class HesaplarContract {

	private int id;
	private int yetkiId;
	private int personelId;
	private String ad;
	private String soyad;
	private String ePosta;
	private String sifre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYetkiId() {
		return yetkiId;
	}

	public void setYetkiId(int yetkiId) {
		this.yetkiId = yetkiId;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getePosta() {
		return ePosta;
	}

	public void setEPosta(String ePosta) {
		this.ePosta = ePosta;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	@Override
	public String toString() {
		return String.format("%d %d %d %s %s %s %s", id, yetkiId, personelId, ad, soyad, ePosta, sifre);
	}
}
