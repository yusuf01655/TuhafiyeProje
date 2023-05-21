package tr.com.yusuf.fe;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tr.com.yusuf.dal.YetkilerDAL;
import tr.com.yusuf.types.YetkilerContract;

public class YetkiEkleFE {

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
		alert.setTitle("Ekleme i�lemi");
		alert.setHeaderText(null);
		alert.setContentText("Yetki basariyla eklendi.");
		alert.showAndWait();
	}

	@FXML
	void initialize() {

	}
}
