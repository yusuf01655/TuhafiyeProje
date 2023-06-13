package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.MusteriContract;

public class MusteriDAL extends ObjectHelper implements DALInterfaces<MusteriContract> {

	@Override
	public void ekle(MusteriContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO musteriler(ad, soyad, telefon, adres, sehir_id) VALUES('"
					+ entity.getAd() + "', '" + entity.getSoyad() + "', '" + entity.getTelefon() + "', '"
					+ entity.getAdres() + "', " + entity.getSehirId() + ")");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	@Override
	public List<MusteriContract> hepsiniAl() {
		List<MusteriContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		MusteriContract musteriContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM musteriler");
			while (resultSet.next()) {
				musteriContract = new MusteriContract();
				musteriContract.setId(resultSet.getInt("musteri_id"));
				musteriContract.setAd(resultSet.getString("ad"));
				musteriContract.setSoyad(resultSet.getString("soyad"));
				musteriContract.setTelefon(resultSet.getString("telefon"));
				musteriContract.setAdres(resultSet.getString("adres"));
				musteriContract.setSehirId(resultSet.getInt("sehir_id"));
				veriContract.add(musteriContract);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return veriContract;
	}

	@Override
	public MusteriContract sil(MusteriContract entity) {
		MusteriContract hesaplarContract = new MusteriContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM musteriler WHERE musteri_id=" + entity.getId());
			statement.close();
			connection.close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return hesaplarContract;
	}

	@Override
	public void guncelle(MusteriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE musteriler SET ad = '" + entity.getAd() + "', soyad = '" + entity.getSoyad()
					+ "', telefon = '" + entity.getTelefon() + "', adres = '" + entity.getAdres() + "', sehir_id = '"
					+ entity.getSehirId() + "' WHERE musteri_id = entity.getId()");
			statement.close();
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	@Override
	public List<MusteriContract> idIleAl(int id) {
		List<MusteriContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		MusteriContract musteriContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM musteriler where id = " + id);
			while (resultSet.next()) {
				musteriContract = new MusteriContract();
				musteriContract.setId(resultSet.getInt("musteri_id"));
				musteriContract.setAd(resultSet.getString("ad"));
				musteriContract.setSoyad(resultSet.getString("soyad"));
				musteriContract.setTelefon(resultSet.getString("telefon"));
				musteriContract.setAdres(resultSet.getString("adres"));
				musteriContract.setSehirId(resultSet.getInt("sehir_id"));
				veriContract.add(musteriContract);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return veriContract;
	}

}
