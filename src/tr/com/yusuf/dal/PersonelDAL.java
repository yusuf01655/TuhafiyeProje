package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.PersonelContract;

public class PersonelDAL extends ObjectHelper implements DALInterfaces<PersonelContract> {

	@Override
	public void ekle(PersonelContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Urunler(ad, soyad, eposta)" + "VALUES ('" + entity.getAd() + "' , "
					+ entity.getSoyad() + ",'" + entity.getEposta() + ")");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	@Override
	public List<PersonelContract> hepsiniAl() {
		List<PersonelContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		PersonelContract personelContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM urunler");
			while (resultSet.next()) {
				personelContract = new PersonelContract();
				personelContract.setId(resultSet.getInt("personel_id"));
				personelContract.setAd(resultSet.getString("ad"));
				personelContract.setSoyad(resultSet.getString("soyad"));
				personelContract.setEposta(resultSet.getString("eposta"));
				veriContract.add(personelContract);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;
	}

	@Override
	public PersonelContract sil(PersonelContract entity) {
		PersonelContract personelContract = new PersonelContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM personeller WHERE personel_id=" + entity.getId());
			statement.close();
			connection.close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return personelContract;
	}

	@Override
	public void guncelle(PersonelContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE personeller SET ad = '" + entity.getAd() + "' ," + "soyad= " + entity.getSoyad() + ", "
							+ "eposta = '" + entity.getEposta() + " " + "WHERE personel_id = " + entity.getId());
			statement.close();
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	@Override
	public List<PersonelContract> idIleAl(int id) {
		List<PersonelContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		PersonelContract personelContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM urunler WHERE urun_id = " + id);
			while (resultSet.next()) {
				personelContract = new PersonelContract();
				personelContract.setId(resultSet.getInt("personel_id"));
				personelContract.setAd(resultSet.getString("ad"));
				personelContract.setSoyad(resultSet.getString("soyad"));
				personelContract.setEposta(resultSet.getString("eposta"));
				veriContract.add(personelContract);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;

	}

}
