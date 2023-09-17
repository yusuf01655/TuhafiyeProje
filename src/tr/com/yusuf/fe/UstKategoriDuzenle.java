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
import tr.com.yusuf.business.UstKategoriManager;
import tr.com.yusuf.dal.UstKategoriDAL;
import tr.com.yusuf.interfaces.FeInterfaces;
import tr.com.yusuf.types.UstKategoriContract;

public class UstKategoriDuzenle implements FeInterfaces {

	UstKategoriContract ustKategoriContract;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField textFieldUstKategoriAdi;

	@FXML
	private Button btn_ekle;

	@FXML
	void buttonGuncelle_OnAction(ActionEvent event) {
		ustKategoriContract.setAdi(textFieldUstKategoriAdi.getText());
		new UstKategoriManager(new UstKategoriDAL()).guncelle(ustKategoriContract);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ekleme iþlemi");
		alert.setHeaderText(null);
		alert.setContentText("Yetki basariyla GUNCELLENDI.");
		alert.showAndWait();

	}

	@FXML
	void initialize() {
		assert textFieldUstKategoriAdi != null
				: "fx:id=\"textFieldUstKategoriAdi\" was not injected: check your FXML file 'UstKategoriGuncelleFE.fxml'.";
		assert btn_ekle != null
				: "fx:id=\"btn_ekle\" was not injected: check your FXML file 'UstKategoriGuncelleFE.fxml'.";

	}

	@Override
	public void initPencere() {

		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/tr/com/yusuf/fe/UstKategoriGuncelleFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setUstKategoriContract(UstKategoriContract ustKategoriContract) {
		this.ustKategoriContract = ustKategoriContract;

	}

}
