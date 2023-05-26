package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.HesaplarContract;

public class HesaplarDAL extends ObjectHelper implements DALInterfaces<HesaplarContract> {

	@Override
	public void ekle(HesaplarContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO hesaplar(yetki_id, sifre, personel_id) VALUES(" + entity.getYetkiId()
					+ ", " + entity.getSifre() + ", " + entity.getPersonelId() + ")");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	@Override
	public List<HesaplarContract> hepsiniAl() {
		List<HesaplarContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		HesaplarContract hesaplarContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM hesaplar");
			while (resultSet.next()) {
				hesaplarContract = new HesaplarContract();
				hesaplarContract.setId(resultSet.getInt("hesap_id"));
				hesaplarContract.setYetkiId(resultSet.getInt("yetki_id"));
				hesaplarContract.setSifre(resultSet.getString("sifre"));
				hesaplarContract.setPersonelId(resultSet.getInt("personel_id"));
				veriContract.add(hesaplarContract);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;
	}

	@Override
	public HesaplarContract sil(HesaplarContract entity) {
		HesaplarContract hesaplarContract = new HesaplarContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM hesaplar WHERE hesap_id=" + entity.getId());
			statement.close();
			connection.close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return hesaplarContract;
	}

	@Override
	public void guncelle(HesaplarContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE hesaplar SET yetki_id = " + entity.getYetkiId() + ", sifre = '"
					+ entity.getSifre() + "', personel_id = " + entity.getPersonelId() + " WHERE hesap_id = "
					+ entity.getId() + "");
			statement.close();
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	@Override
	public List<HesaplarContract> idIleAl(int id) {

		List<HesaplarContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		HesaplarContract hesaplarContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM hesaplar WHERE hesap_id = " + id);
			while (resultSet.next()) {
				hesaplarContract = new HesaplarContract();
				hesaplarContract.setId(resultSet.getInt("hesap_id"));
				hesaplarContract.setYetkiId(resultSet.getInt("yetki_id"));
				hesaplarContract.setSifre(resultSet.getString("sifre"));
				hesaplarContract.setPersonelId(resultSet.getInt("personel_id"));

				veriContract.add(hesaplarContract);

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;
	}

	public HesaplarContract getPersonelIdVeSifre(int personel_id, String sifre) {
		HesaplarContract contract = new HesaplarContract();

		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM hesaplar WHERE personel_id = " + personel_id
					+ " AND sifre = '" + sifre.trim() + "'");

			while (resultSet.next()) {
				contract.setId(resultSet.getInt("Id"));
				contract.setPersonelId(resultSet.getInt("PersonelId"));
				contract.setSifre((resultSet.getString("Sifre")));
				contract.setYetkiId(resultSet.getInt("YetkiId"));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
		}
		return contract;
	}

	public HesaplarContract GetYetkiId(int personel_id) {
		HesaplarContract contract = new HesaplarContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM hesaplar WHERE personel_id = " + personel_id + " ");

			while (resultSet.next()) {
				contract.setId(resultSet.getInt("hesap_id"));
				contract.setPersonelId(resultSet.getInt("personel_id"));
				contract.setYetkiId(resultSet.getInt("yetki_id"));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
		}
		return contract;
	}
}
