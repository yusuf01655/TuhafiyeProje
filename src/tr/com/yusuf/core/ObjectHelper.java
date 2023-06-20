package tr.com.yusuf.core;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tr.com.yusuf.interfaces.CoreInterfaces;
import tr.com.yusuf.interfaces.IMd5Encryptable;

public class ObjectHelper extends CoreFields implements CoreInterfaces, IMd5Encryptable {
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

	@Override
	public String MD5Encrypt(String girdi) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(girdi.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
