package tr.com.yusuf.types;

public class PersonelContract {

	private int id;
	private String ad;
	private String soyad;
	private String eposta;

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

	public String getEposta() {
		return this.eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	@Override
	public String toString() {
		return String.format("%d %s %s %s", id, ad, soyad, eposta);
	}
}