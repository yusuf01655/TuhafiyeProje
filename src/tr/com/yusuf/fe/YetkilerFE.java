package tr.com.yusuf.fe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tr.com.yusuf.business.YetkiManager;
import tr.com.yusuf.dal.YetkilerDAL;
import tr.com.yusuf.interfaces.FeInterfaces;
import tr.com.yusuf.types.YetkilerContract;

public class YetkilerFE implements FeInterfaces {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<YetkilerContract> tableViewYetkiler;

	@FXML
	private Button buttonSil;

	@FXML
	private Button buttonGuncelle;

	@FXML
	private Button buttonEkle;
	@FXML
	private TableColumn<YetkilerContract, Integer> tableColumnYetkiId;

	@FXML
	private TableColumn<YetkilerContract, String> tableColumnAd;

	@FXML
	void initialize() {
		tableColumnYetkiId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnAd.setCellValueFactory(new PropertyValueFactory<>("ad"));
		// List<YetkilerContract> veriler = ;
		ObservableList<YetkilerContract> liste = FXCollections
				.observableArrayList(new YetkiManager(new YetkilerDAL()).hepsiniAl());
		tableViewYetkiler.setItems(liste);
	}

	@Override
	public void initPencere() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/tr/com/yusuf/fe/YetkilerFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void buttonEkle_OnAction(ActionEvent event) {
		new YetkiEkleFE().initPencere();
	}

	@FXML
	void buttonGuncelle_OnAction(ActionEvent event) throws IOException {
		// idyi diger controllera atamak icin controllerlar arasi iletisim gerek.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/tr/com/yusuf/fe/YetkiDuzenleFE.fxml"));
		Parent root = loader.load();

		YetkiDuzenleFE yetkiDuzenleFE = loader.getController();
		yetkiDuzenleFE.setYetkilerContract(
				tableViewYetkiler.getItems().get(tableViewYetkiler.getSelectionModel().getSelectedIndex()));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		// son hal

	}

	@FXML
	void buttonSil_OnAction(ActionEvent event) {
		YetkilerContract yetkilerContract = tableViewYetkiler.getItems()
				.get(tableViewYetkiler.getSelectionModel().getSelectedIndex());
		new YetkiManager(new YetkilerDAL()).sil(yetkilerContract);

		// bilgi mesaji
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ekleme iþlemi");
		alert.setHeaderText(null);
		alert.setContentText("Yetki basariyla SILINDI.");
		alert.showAndWait();
	}
}
