package tr.com.yusuf.types;

public class UstKategoriContract {

	private int ustKategoriId;
	private String adi;

	public UstKategoriContract(int ustKategoriId, String adi) {

		this.ustKategoriId = ustKategoriId;
		this.adi = adi;
	}

	public UstKategoriContract() {
		// TODO Auto-generated constructor stubs
	}

	public int getUstKategoriId() {
		return ustKategoriId;
	}

	public void setUstKategoriId(int ustKategoriId) {
		this.ustKategoriId = ustKategoriId;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

}
