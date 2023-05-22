package tr.com.yusuf.fe;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tr.com.yusuf.dal.YetkilerDAL;
import tr.com.yusuf.interfaces.FeInterfaces;
import tr.com.yusuf.types.YetkilerContract;

public class YetkiEkleFE implements FeInterfaces {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btn_ekle;
	@FXML
	private TextField textFieldYetkiAdi;

	@FXML
	void btnEkle_OnAction(ActionEvent event) {
		YetkilerContract yetkilerContract = new YetkilerContract();
		yetkilerContract.setAd(textFieldYetkiAdi.getText());
		new YetkilerDAL().ekle(yetkilerContract);

		// bilgi mesaji
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ekleme iþlemi");
		alert.setHeaderText(null);
		alert.setContentText("Yetki basariyla eklendi.");
		alert.showAndWait();
	}

	@FXML
	void initialize() {

	}

	@Override
	public void initPencere() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/tr/com/yusuf/fe/YetkiEkleFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
