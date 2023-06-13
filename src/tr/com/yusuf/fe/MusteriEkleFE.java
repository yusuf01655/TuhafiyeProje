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
import tr.com.yusuf.dal.MusteriDAL;
import tr.com.yusuf.interfaces.FeInterfaces;
import tr.com.yusuf.types.MusteriContract;

public class MusteriEkleFE implements FeInterfaces {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtAd;

	@FXML
	private TextField txtSoyad;

	@FXML
	private TextField txtTelefon;

	@FXML
	private TextField txtAdres;

	@FXML
	private TextField txtSehir;

	@FXML
	private Button buttonEkle;

	@FXML
	void initialize() {

	}

	@Override
	public void initPencere() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/tr/com/yusuf/fe/MusteriEkleFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void buttonEkle_OnAction(ActionEvent event) {
		MusteriContract musteriContract = new MusteriContract();
		musteriContract.setAd(txtAd.getText());
		musteriContract.setSoyad(txtSoyad.getText());
		musteriContract.setTelefon(txtTelefon.getText());
		musteriContract.setAdres(txtAdres.getText());
		musteriContract.setSehirId(Integer.valueOf(txtSehir.getText()));
		new MusteriDAL().ekle(musteriContract);
		// bilgi mesaji
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ekleme iþlemi");
		alert.setHeaderText(null);
		alert.setContentText("Müþteri basariyla eklendi.");
		alert.showAndWait();
	}
}
