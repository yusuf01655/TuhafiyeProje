package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.YetkilerContract;

public class YetkilerDAL extends ObjectHelper implements DALInterfaces<YetkilerContract> {

	@Override
	public void ekle(YetkilerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO yetkiler(ad)" + "VALUES ('" + entity.getAd() + "')");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	@Override
	public List<YetkilerContract> hepsiniAl() {
		List<YetkilerContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		YetkilerContract yetkilerContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM yetkiler");
			while (resultSet.next()) {
				yetkilerContract = new YetkilerContract();
				yetkilerContract.setId(resultSet.getInt("yetki_id"));
				yetkilerContract.setAd(resultSet.getString("ad"));
				veriContract.add(yetkilerContract);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;
	}

	@Override
	public YetkilerContract sil(YetkilerContract entity) {
		YetkilerContract yetkilerContract = new YetkilerContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM yetkiler WHERE yetki_id=" + entity.getId());
			statement.close();
			connection.close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return yetkilerContract;
	}

	@Override
	public void guncelle(YetkilerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE yetkiler SET ad = '" + entity.getAd() + "' " + "WHERE yetki_id = " + entity.getId());
			statement.close();
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	@Override
	public List<YetkilerContract> idIleAl(int id) {
		List<YetkilerContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		YetkilerContract yetkilerContract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM yetkiler WHERE yetki_id = " + id);
			while (resultSet.next()) {
				yetkilerContract = new YetkilerContract();
				yetkilerContract.setId(resultSet.getInt("urun_id"));
				yetkilerContract.setAd(resultSet.getString("ad"));

				veriContract.add(yetkilerContract);

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return veriContract;

	}

}
