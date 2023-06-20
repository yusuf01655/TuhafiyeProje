package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.fe.AnaPencereFEController;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.HesaplarContract;

public class HesaplarDAL extends ObjectHelper implements DALInterfaces<HesaplarContract> {

	@Override
	public void ekle(HesaplarContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO hesaplar(yetki_id, sifre, personel_id, ad, soyad, eposta) VALUES("
					+ entity.getYetkiId() + ", " + new ObjectHelper().MD5Encrypt(entity.getSifre()) + ", "
					+ entity.getPersonelId() + ", " + entity.getAd() + ", " + entity.getSoyad() + ", "
					+ entity.getePosta() + ")");
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
				hesaplarContract.setAd(resultSet.getString("ad"));
				hesaplarContract.setSoyad(resultSet.getString("soyad"));
				hesaplarContract.setEPosta(resultSet.getString("eposta"));

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
					+ new ObjectHelper().MD5Encrypt(entity.getSifre()) + "', personel_id = " + entity.getPersonelId()
					+ "', ad =" + entity.getAd() + "', soyad = " + entity.getSoyad() + "', eposta = "
					+ entity.getePosta() + " WHERE hesap_id = " + entity.getId() + "");
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
				hesaplarContract.setAd(resultSet.getString("ad"));
				hesaplarContract.setSoyad(resultSet.getString("soyad"));
				hesaplarContract.setEPosta(resultSet.getString("eposta"));
				veriContract.add(hesaplarContract);

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;
	}

	public void girisYap(String ePosta, String sifre) {
		HesaplarContract hesaplarContract = new HesaplarContract();

		Connection connection = getConnection();

		try {
			String sorgu = "SELECT * FROM hesaplar WHERE eposta =? AND sifre = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);

			preparedStatement.setString(1, ePosta);
			preparedStatement.setString(2, new ObjectHelper().MD5Encrypt(sifre));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				hesaplarContract.setId(resultSet.getInt("hesap_id"));
				hesaplarContract.setPersonelId(resultSet.getInt("personel_id"));
				hesaplarContract.setSifre((resultSet.getString("sifre")));
				hesaplarContract.setYetkiId(resultSet.getInt("yetki_id"));
				hesaplarContract.setAd(resultSet.getString("ad"));
				hesaplarContract.setSoyad(resultSet.getString("soyad"));
				hesaplarContract.setEPosta(resultSet.getString("eposta"));

			}

			if (((hesaplarContract.getePosta().equals(ePosta)) && (hesaplarContract.getSifre().equals(sifre)))) {
				new AnaPencereFEController().initPencere();

			} else {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Giris iþlemi");
				alert.setHeaderText(null);
				alert.setContentText("Eriþim reddedildi.");
				alert.showAndWait();

				preparedStatement.close();
				connection.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public HesaplarContract GetYetkiId(int personel_id) {
		HesaplarContract hesaplarContract = new HesaplarContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM hesaplar WHERE personel_id = " + personel_id + " ");

			while (resultSet.next()) {
				hesaplarContract.setId(resultSet.getInt("hesap_id"));
				hesaplarContract.setPersonelId(resultSet.getInt("personel_id"));
				hesaplarContract.setYetkiId(resultSet.getInt("yetki_id"));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
		}
		return hesaplarContract;
	}
}
