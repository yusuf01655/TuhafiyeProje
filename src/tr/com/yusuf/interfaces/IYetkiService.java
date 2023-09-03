package tr.com.yusuf.interfaces;

import java.util.List;

import tr.com.yusuf.types.YetkilerContract;

public interface IYetkiService {
	public void ekle(YetkilerContract yetkilerContract);

	public List<YetkilerContract> hepsiniAl();

	public void guncelle(YetkilerContract yetkilerContract);

	public void sil(YetkilerContract yetkilerContract);

	public List<YetkilerContract> idIleAl(int id);
}
