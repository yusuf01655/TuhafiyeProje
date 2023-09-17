package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.UstKategoriContract;

public class UstKategoriDAL extends ObjectHelper implements DALInterfaces<UstKategoriContract> {

	@Override
	public void ekle(UstKategoriContract entity) {

		Connection connection = getConnection();
		String sorgu = "INSERT INTO ust_kategoriler(adi) VALUES(?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, entity.getAdi());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<UstKategoriContract> hepsiniAl() {
		List<UstKategoriContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		UstKategoriContract ustKategoriContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ust_kategoriler");
			while (resultSet.next()) {
				ustKategoriContract = new UstKategoriContract();
				ustKategoriContract.setUstKategoriId(resultSet.getInt("ust_kategori_id"));
				ustKategoriContract.setAdi(resultSet.getString("adi"));
				veriContract.add(ustKategoriContract);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;
	}

	@Override
	public UstKategoriContract sil(UstKategoriContract entity) {
		UstKategoriContract ustKategoriContract = new UstKategoriContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM ust_kategoriler WHERE ust_kategori_id=" + entity.getUstKategoriId());
			statement.close();
			connection.close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return ustKategoriContract;
	}

	@Override
	public void guncelle(UstKategoriContract entity) {

		/*
		 * private int musteriId; private int personelId; private int urunId; private
		 * int adet; private Date tarih;
		 */
		Connection connection = getConnection();
		String sorgu = "UPDATE ust_kategoriler SET adi=? WHERE ust_kategori_id = ?";
		try {
			/*
			 * private int musteriId; private int personelId; private int urunId; private
			 * int adet; private Date tarih;
			 */
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, entity.getAdi());
			preparedStatement.setInt(2, entity.getUstKategoriId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<UstKategoriContract> idIleAl(int id) {
		List<UstKategoriContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		UstKategoriContract yetkilerContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ust_kategoriler WHERE ust_kategori_id = " + id);
			while (resultSet.next()) {
				yetkilerContract = new UstKategoriContract();
				yetkilerContract.setUstKategoriId(resultSet.getInt("ust_kategori_id"));
				yetkilerContract.setAdi(resultSet.getString("adi"));

				veriContract.add(yetkilerContract);

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;

	}

}
