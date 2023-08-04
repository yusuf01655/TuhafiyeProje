package tr.com.yusuf.fe;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tr.com.yusuf.core.ObjectHelper;
import tr.com.yusuf.dal.HesaplarDAL;
import tr.com.yusuf.interfaces.FeInterfaces;

public class GirisEkraniFE implements FeInterfaces {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField textFieldEPosta;

	@FXML
	private TextField textFieldSifre;

	@FXML
	private Button buttonGirisYap;
	@FXML
	private Button md5button;
	@FXML
	private TextField md5field;

	@FXML
	void md5Button_OnAction(ActionEvent event) {

		md5field.setText(new ObjectHelper().MD5Encrypt(md5field.getText()));
		// System.out.println(getMd5("12345"));
	}

	public String getMd5(String input) {
		try {

			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public GirisEkraniFE() {

	}

	@FXML
	void buttonGirisYap_OnAction(ActionEvent event) {

		new HesaplarDAL().girisYap(textFieldEPosta.getText(), textFieldSifre.getText());
		pencereyiKapat();
	}

	@Override
	public void initPencere() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/tr/com/yusuf/fe/GirisEkraniFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pencereyiKapat() {
		Stage stage1 = (Stage) buttonGirisYap.getScene().getWindow();
		stage1.close();
	}

}
