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

public class UstKategoriEkleFE implements FeInterfaces {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="textFieldUstKategoriAdi"
	private TextField textFieldUstKategoriAdi; // Value injected by FXMLLoader

	@FXML // fx:id="btn_ekle"
	private Button btn_ekle; // Value injected by FXMLLoader

	@FXML
	void btnEkle_OnAction(ActionEvent event) {
		UstKategoriContract ustKategoriContract = new UstKategoriContract();
		ustKategoriContract.setAdi(textFieldUstKategoriAdi.getText());
		new UstKategoriManager(new UstKategoriDAL()).ekle(ustKategoriContract);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ekleme iþlemi");
		alert.setContentText("Ekleme iþlemi tamamdýr.");
		alert.setHeaderText(null);
		alert.showAndWait();

	}

	public UstKategoriEkleFE() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initPencere() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/tr/com/yusuf/fe/UstKategoriEkleFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

	}

}
