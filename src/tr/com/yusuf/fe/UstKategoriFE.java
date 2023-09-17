package tr.com.yusuf.fe;

import java.io.IOException;

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
import tr.com.yusuf.business.UstKategoriManager;
import tr.com.yusuf.dal.UstKategoriDAL;
import tr.com.yusuf.interfaces.FeInterfaces;
import tr.com.yusuf.interfaces.IFetchableDataFromDatabaseToTable;
import tr.com.yusuf.types.UstKategoriContract;

public class UstKategoriFE implements FeInterfaces, IFetchableDataFromDatabaseToTable {

	@FXML
	TableView<UstKategoriContract> tableViewUstKategoriler;
	@FXML
	TableColumn<UstKategoriContract, Integer> tableColumnUstKategoriId;
	@FXML
	TableColumn<UstKategoriContract, String> tableColumnAdi;
	@FXML
	Button buttonSil;
	@FXML
	Button buttonGuncelle;
	@FXML
	Button buttonEkle;
	@FXML
	Button buttonYenile;

	@FXML
	public void buttonYenile_OnAction(ActionEvent event) {
		fetchDataFromDatabaseToTable("ustKategoriId", "adi");

	}

	@FXML
	public void buttonSil_OnAction(ActionEvent event) {
		UstKategoriContract ustKategoriContract = tableViewUstKategoriler.getItems()
				.get(tableViewUstKategoriler.getSelectionModel().getSelectedIndex());
		new UstKategoriManager(new UstKategoriDAL()).sil(ustKategoriContract);
		// bilgi mesaji
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ekleme iþlemi");
		alert.setHeaderText(null);
		alert.setContentText("Ust Kategori basariyla SILINDI.");
		alert.showAndWait();
		// fetchDataFromDatabaseToTable("ustKategoriId", "tableColumnAdi");

	}

	@FXML
	public void buttonEkle_OnAction(ActionEvent event) {
		new UstKategoriEkleFE().initPencere();
	}

	@FXML
	public void buttonGuncelle_OnAction(ActionEvent event) throws IOException {

		// idyi diger controllera atamak icin controllerlar arasi iletisim gerek.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/tr/com/yusuf/fe/UstKategoriGuncelleFE.fxml"));
		Parent root = loader.load();

		UstKategoriDuzenle ustKategoriDuzenle = loader.getController();
		ustKategoriDuzenle.setUstKategoriContract(
				tableViewUstKategoriler.getItems().get(tableViewUstKategoriler.getSelectionModel().getSelectedIndex()));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		// son hal

	}

	@Override
	public void initPencere() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/tr/com/yusuf/fe/UstKategoriFE.fxml"));
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
		fetchDataFromDatabaseToTable("ustKategoriId", "adi");
	}

	@Override
	public void fetchDataFromDatabaseToTable(String... sutunAdi) {
		tableColumnUstKategoriId.setCellValueFactory(new PropertyValueFactory<>(sutunAdi[0]));
		tableColumnAdi.setCellValueFactory(new PropertyValueFactory<>(sutunAdi[1]));
		ObservableList<UstKategoriContract> liste = FXCollections
				.observableArrayList(new UstKategoriManager(new UstKategoriDAL()).hepsiniAl());
		tableViewUstKategoriler.setItems(liste);

	}

}
