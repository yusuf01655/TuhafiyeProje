package tr.com.yusuf.interfaces;

import java.util.List;

public interface DALInterfaces<T> {
	void ekle(T entity);

	List<T> hepsiniAl();

	T sil(T entity);

	void guncelle(T entity);

	List<T> idIleAl(int id);

}
