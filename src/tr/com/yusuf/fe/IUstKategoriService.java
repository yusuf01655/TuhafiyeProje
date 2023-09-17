package tr.com.yusuf.fe;

import java.util.List;

import tr.com.yusuf.types.UstKategoriContract;

public interface IUstKategoriService {
	public void ekle(UstKategoriContract ustKategoriContract);

	public List<UstKategoriContract> hepsiniAl();

	// burdayim.
	public void guncelle(UstKategoriContract ustKategoriContract);

	public void sil(UstKategoriContract ustKategoriContract);

}
