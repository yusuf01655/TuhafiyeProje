package tr.com.yusuf.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tr.com.yusuf.interfaces.CoreInterfaces;

public class ObjectHelper extends CoreFields implements CoreInterfaces {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() {
		setKullaniciAdi("root");
		setUrl("jdbc:mysql://localhost:3306/tuhafiye_otomasyonu?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");
		setSifre("");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(getUrl(), getKullaniciAdi(), getSifre());
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return connection;
	}

}
