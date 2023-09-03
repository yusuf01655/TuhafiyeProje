package tr.com.yusuf.business;

import java.util.List;

import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.interfaces.IYetkiService;
import tr.com.yusuf.types.YetkilerContract;

public class YetkiManager implements IYetkiService {
	DALInterfaces<YetkilerContract> dalInterfaces;

	// dependency injection
	public YetkiManager(DALInterfaces<YetkilerContract> dalInterfaces) {
		this.dalInterfaces = dalInterfaces;
	}

	@Override
	public void ekle(YetkilerContract yetkilerContract) {

		if (yetkilerContract.getAd() == "") {
			throw new IllegalArgumentException("boþ deger girdiniz.");
		} else {
			dalInterfaces.ekle(yetkilerContract);
		}
	}

	@Override
	public List<YetkilerContract> hepsiniAl() {

		return this.dalInterfaces.hepsiniAl();
	}

	@Override
	public void guncelle(YetkilerContract yetkilerContract) {
		dalInterfaces.guncelle(yetkilerContract);

	}

	@Override
	public void sil(YetkilerContract yetkilerContract) {
		if (yetkilerContract.getId() < 0)
			throw new IllegalArgumentException("id sifirdan buyuk olmali.");
		else
			dalInterfaces.sil(yetkilerContract);
	}

	@Override
	public List<YetkilerContract> idIleAl(int id) {
		if (id > 0)
			return this.dalInterfaces.idIleAl(id);
		else
			throw new IllegalArgumentException("id pozitif olmali.");
	}

}
