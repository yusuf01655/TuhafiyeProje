package tr.com.yusuf.core;

public class CoreFields {

	private String kullaniciAdi;
	private String sifre;
	private String url = "jdbc:mysql://localhost:3306/tuhafiyeotomasyonu?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}