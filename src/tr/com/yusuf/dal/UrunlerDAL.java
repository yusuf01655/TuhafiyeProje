package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.UrunlerContract;

public class UrunlerDAL extends ObjectHelper implements DALInterfaces<UrunlerContract> {

	@Override
	public void ekle(UrunlerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO urunler(ad, kategori_id, tarih, fiyat)" + "VALUES ('" + entity.getAd()
					+ "' , " + entity.getKategoriId() + ",'" + entity.getTarih() + "' , " + entity.getFiyat() + ")");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	@Override
	public List<UrunlerContract> hepsiniAl() {
		List<UrunlerContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		UrunlerContract urunlerContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM urunler");
			while (resultSet.next()) {
				urunlerContract = new UrunlerContract();
				urunlerContract.setId(resultSet.getInt("urun_id"));
				urunlerContract.setAd(resultSet.getString("ad"));
				urunlerContract.setKategoriId(resultSet.getInt("kategori_id"));
				urunlerContract.setTarih(resultSet.getDate("tarih"));
				urunlerContract.setFiyat(resultSet.getFloat("fiyat"));
				veriContract.add(urunlerContract);

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;
	}

	@Override
	public UrunlerContract sil(UrunlerContract entity) {
		UrunlerContract urunlerContract = new UrunlerContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM urunler WHERE urun_id=" + entity.getId());
			statement.close();
			connection.close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return urunlerContract;
	}

	@Override
	public void guncelle(UrunlerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE urunler SET ad = '" + entity.getAd() + "' ," + "kategori_id = "
					+ entity.getKategoriId() + ", " + "tarih = '" + entity.getTarih() + "', " + "fiyat = "
					+ entity.getFiyat() + " " + "WHERE urun_id = " + entity.getId());
			statement.close();
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> idIleAl(int id) {
		List<UrunlerContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		UrunlerContract urunlerContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM urunler WHERE urun_id = " + id);
			while (resultSet.next()) {
				urunlerContract = new UrunlerContract();
				urunlerContract.setId(resultSet.getInt("urun_id"));
				urunlerContract.setAd(resultSet.getString("ad"));
				urunlerContract.setKategoriId(resultSet.getInt("kategori_id"));
				urunlerContract.setTarih(resultSet.getDate("tarih"));
				urunlerContract.setFiyat(resultSet.getFloat("fiyat"));
				veriContract.add(urunlerContract);

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;

	}

}
