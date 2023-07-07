package tr.com.yusuf.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tr.com.yusuf.complex.types.SatisContractComplex;
import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.interfaces.DALInterfaces;
import tr.com.yusuf.types.SatisContract;

public class SatisDAL extends ObjectHelper implements DALInterfaces<SatisContract> {

	public SatisDAL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ekle(SatisContract entity) {
		Connection connection = getConnection();
		String sorgu = "INSERT INTO satis(urun_id, musteri_id, personel_id, adet, tarih) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, entity.getUrunId());
			preparedStatement.setInt(2, entity.getMusteriId());
			preparedStatement.setInt(3, entity.getHesapId());
			preparedStatement.setInt(4, entity.getAdet());
			preparedStatement.setDate(5, (Date) entity.getTarih());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close(); // yoksa ifadeyi deðiþtir.

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<SatisContract> hepsiniAl() {
		List<SatisContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		SatisContract satisContract;
		String sorgu = "SELECT satis.satis_id, hesaplar.ad, hesaplar.soyad ,musteri.ad, musteri.soyad, satis.adet, satis.tarih FROM satis LEFT JOIN musteri on satis.musteri_id = musteri.musteri_id LEFT JOIN urunler on satis.urun_id = urunler.urun_id LEFT JOIN hesaplar on satis.personel_id = hesaplar.personel_id ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				satisContract = new SatisContract();
				satisContract.setSatisId(resultSet.getInt("satis_id"));
				satisContract.setMusteriId(resultSet.getInt("musteri_id"));
				satisContract.setHesapId(resultSet.getInt("personel_id"));
				satisContract.setUrunId(resultSet.getInt("urun_id"));
				satisContract.setAdet(resultSet.getInt("adet"));
				satisContract.setTarih(resultSet.getDate("tarih"));
				veriContract.add(satisContract);
				// local date to date
				// date to local date

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return veriContract;
	}

	public ObservableList<SatisContractComplex> satislarinHepsiniAl() {
		ObservableList<SatisContractComplex> veriContract = FXCollections.observableArrayList();
		Connection connection = getConnection();
		SatisContractComplex satisContractComplex;
		String sorgu = "SELECT satis.satis_id, hesaplar.ad, hesaplar.soyad ,musteri.ad, musteri.soyad, satis.adet, satis.tarih FROM satis LEFT JOIN musteri on satis.musteri_id = musteri.musteri_id LEFT JOIN urunler on satis.urun_id = urunler.urun_id LEFT JOIN hesaplar on satis.personel_id = hesaplar.personel_id ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				satisContractComplex = new SatisContractComplex();
				satisContractComplex.setSatisId(resultSet.getInt("satis.satis_id"));
				satisContractComplex.setHesapAdi(resultSet.getString("hesaplar.ad"));
				satisContractComplex.setHesapSoyadi(resultSet.getString("hesaplar.soyad"));
				satisContractComplex.setMusteriAd(resultSet.getString("musteri.ad"));
				satisContractComplex.setMusteriSoyad(resultSet.getString("musteri.soyad"));
				satisContractComplex.setSatisAdet(resultSet.getInt("satis.adet"));
				satisContractComplex.setSatisTarih(resultSet.getDate("satis.tarih"));
				veriContract.add(satisContractComplex);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return veriContract;
	}

	@Override
	public SatisContract sil(SatisContract entity) {
		SatisContract satisContract = new SatisContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM satislar WHERE satis_id=" + entity.getSatisId());
			statement.close();
			connection.close();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return satisContract;
	}

	@Override
	public void guncelle(SatisContract entity) {

		/*
		 * private int musteriId; private int personelId; private int urunId; private
		 * int adet; private Date tarih;
		 */
		Connection connection = getConnection();
		String sorgu = "UPDATE satis SET musteri_id=?, personel_id = ?, urun_id = ?, adet = ?, tarih = ? WHERE satis_id = ?";
		try {
			/*
			 * private int musteriId; private int personelId; private int urunId; private
			 * int adet; private Date tarih;
			 */
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, entity.getMusteriId());
			preparedStatement.setInt(2, entity.getMusteriId());
			preparedStatement.setInt(3, entity.getUrunId());
			preparedStatement.setInt(4, entity.getAdet());
			preparedStatement.setDate(5, (Date) entity.getTarih());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<SatisContract> idIleAl(int id) {
		List<SatisContract> veriContract = new ArrayList<>();
		Connection connection = getConnection();
		SatisContract satisContract;
		String sorgu = "SELECT satis.satis_id, hesaplar.ad, hesaplar.soyad ,musteri.ad, musteri.soyad, satis.adet, satis.tarih FROM satis LEFT JOIN musteri on satis.musteri_id = musteri.musteri_id LEFT JOIN urunler on satis.urun_id = urunler.urun_id LEFT JOIN hesaplar on satis.personel_id = hesaplar.personel_id WHERE satis_id = "
				+ id;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				satisContract = new SatisContract();
				satisContract.setSatisId(resultSet.getInt("satis_id"));
				satisContract.setMusteriId(resultSet.getInt("musteri_id"));
				satisContract.setHesapId(resultSet.getInt("personel_id"));
				satisContract.setUrunId(resultSet.getInt("urun_id"));
				satisContract.setAdet(resultSet.getInt("adet"));
				satisContract.setTarih(resultSet.getDate("tarih"));
				veriContract.add(satisContract);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return veriContract;
	}

}
