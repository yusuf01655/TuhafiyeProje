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
import tr.com.yusuf.business.YetkiManager;
import tr.com.yusuf.dal.YetkilerDAL;
import tr.com.yusuf.interfaces.FeInterfaces;
import tr.com.yusuf.types.YetkilerContract;

public class YetkiDuzenleFE implements FeInterfaces {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField textFieldYetkiAdi;

	@FXML
	private Button buttonDuzenle;

	@FXML
	private Button buttonTemizle;

	private YetkilerContract yetkilerContract;

	public YetkilerContract getYetkilerContract() {
		return yetkilerContract;
	}

	public void setYetkilerContract(YetkilerContract yetkilerContract) {
		this.yetkilerContract = yetkilerContract;
	}

	@FXML
	void buttonDuzenle_OnAction(ActionEvent event) {

		yetkilerContract.setAd(textFieldYetkiAdi.getText());
		new YetkiManager(new YetkilerDAL()).guncelle(yetkilerContract);

		// bilgi mesaji
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ekleme iþlemi");
		alert.setHeaderText(null);
		alert.setContentText("Yetki basariyla GUNCELLENDI.");
		alert.showAndWait();
	}

	@FXML
	void buttonTemizle_OnAction(ActionEvent event) {

	}

	@Override
	public void initPencere() {

		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/tr/com/yusuf/fe/YetkiDuzenleFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void initialize() {

	}

}
