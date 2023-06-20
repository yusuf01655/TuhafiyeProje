package tr.com.yusuf.fe;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
