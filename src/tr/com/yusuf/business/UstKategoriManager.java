package tr.com.yusuf.business;

import java.util.List;

import tr.com.yusuf.fe.IUstKategoriService;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.UstKategoriContract;

public class UstKategoriManager implements IUstKategoriService {
	DALInterfaces<UstKategoriContract> dalInterfaces;

	// constructor injection
	public UstKategoriManager(DALInterfaces<UstKategoriContract> dalInterfaces) {
		this.dalInterfaces = dalInterfaces;
	}

	@Override
	public void ekle(UstKategoriContract ustKategoriContract) {
		this.dalInterfaces.ekle(ustKategoriContract);

	}

	@Override
	public List<UstKategoriContract> hepsiniAl() {
		return this.dalInterfaces.hepsiniAl();
	}

	@Override
	public void guncelle(UstKategoriContract ustKategoriContract) {
		this.dalInterfaces.guncelle(ustKategoriContract);

	}

	@Override
	public void sil(UstKategoriContract ustKategoriContract) {
		this.dalInterfaces.sil(ustKategoriContract);

	}

}
