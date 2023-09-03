package tr.com.yusuf.fe;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tr.com.yusuf.complex.types.SatisContractComplex;
import tr.com.yusuf.dal.MusteriDAL;
import tr.com.yusuf.dal.SatisDAL;
import tr.com.yusuf.dal.UrunlerDAL;
import tr.com.yusuf.interfaces.FeInterfaces;
import tr.com.yusuf.interfaces.IFetchableDataFromDatabaseToTable;
import tr.com.yusuf.types.HesaplarContract;
import tr.com.yusuf.types.MusteriContract;
import tr.com.yusuf.types.SatisContract;
import tr.com.yusuf.types.UrunlerContract;

public class AnaPencereFEController implements FeInterfaces, IFetchableDataFromDatabaseToTable {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	@FXML
	private Menu menuYetkiler;

	@FXML
	private MenuItem menuItemYetkiEkle;
	@FXML
	private MenuItem menuItemUrunEkle;

	@FXML
	private MenuItem menuItemUrunSil;

	@FXML
	private MenuItem menuItemUrunDuzenle;

	@FXML
	private MenuItem menuItemUrunGoster;

	@FXML
	private MenuItem menuItemIdIleUrunGoster;

	@FXML
	private MenuItem menuItemPersonelEkle;

	@FXML
	private MenuItem menuItemPersonelSil;

	@FXML
	private MenuItem menuItemPersonelDuzenle;

	@FXML
	private MenuItem menuItemPersonelGoster;

	@FXML
	private MenuItem menuItemIdIlePersonelGoster;

	@FXML
	private MenuItem menuItemBorcEkle;

	@FXML
	private MenuItem menuItemBorcSil;

	@FXML
	private MenuItem menuItemBorcDuzenle;

	@FXML
	private MenuItem menuItemBorcGoster;

	@FXML
	private MenuItem menuItemIdIleBorcGoster;

	@FXML
	private MenuItem menuItemMusteriEkle;

	@FXML
	private MenuItem menuItemMusteriSil;

	@FXML
	private MenuItem menuItemMusteriDuzenle;

	@FXML
	private MenuItem menuItemMusteriGoster;

	@FXML
	private MenuItem menuItemIdIleMusteriGoster;

	@FXML
	private MenuItem menuItemYetkiSil;

	@FXML
	private MenuItem menuItemYetkiDuzenle;

	@FXML
	private MenuItem menuItemYetkiGoster;

	@FXML
	private MenuItem menuItemIdIleYetkiGoster;

	@FXML
	private MenuItem menuItemKategoriEkle;
	@FXML
	private MenuItem menuItemKategoriDuzenle;
	@FXML
	private MenuItem menuItemKategoriGoster;
	@FXML
	private MenuItem menuItemIdIleKategoriGoster;
	@FXML
	private MenuItem menuItemKategoriSil;
	@FXML
	private Button buttonSatisYap;
	@FXML
	private TextField textFieldAdet;
	@FXML
	private ComboBox<UrunlerContract> comboBoxSatisUrunAdi;

	@FXML
	private ComboBox<MusteriContract> comboBoxSatisMusteriAdi;
	@FXML
	private DatePicker datePickerSatisTarihi;
	@FXML
	private TableView<SatisContractComplex> tableViewSatislar;

	@FXML
	private TableColumn<SatisContractComplex, Integer> tableColumnSatisId;

	@FXML
	private TableColumn<SatisContractComplex, String> tableColumnPersonelAdi;

	@FXML
	private TableColumn<SatisContractComplex, String> tableColumnUrunAdi;

	@FXML
	private TableColumn<SatisContractComplex, Integer> tableColumnAdeti;

	@FXML
	private TableColumn<SatisContractComplex, Date> tableColumnTarihi;

	@FXML
	private TableColumn<SatisContractComplex, String> tableColumnMusteriAdi;
	@FXML
	private TableColumn<SatisContractComplex, String> tableColumnHesapAdi;
	@FXML
	private TableColumn<SatisContractComplex, String> tableColumnHesapSoyadi;
	@FXML
	private TableColumn<SatisContractComplex, String> tableColumnMusteriSoyadi;
	@FXML
	private TableColumn<SatisContractComplex, String> tableColumnMusteriId;

	@FXML
	void menuYetkiler_OnAction(ActionEvent event) {
		new YetkilerFE().initPencere();
	}

	@FXML
	void buttonSatisYap_OnAction(ActionEvent event) {
		// HesaplarContract hesaplarContract =

		UrunlerContract urunlerContract = comboBoxSatisUrunAdi.getSelectionModel().getSelectedItem();
		MusteriContract musteriContract = comboBoxSatisMusteriAdi.getSelectionModel().getSelectedItem();
		SatisContract satisContract = new SatisContract();

		// datePickerSatisTarihi.
		LocalDate localDate = datePickerSatisTarihi.getValue();

		satisContract.setMusteriId(musteriContract.getId());
		satisContract.setHesapId(HesaplarContract.sessionId);
		satisContract.setUrunId(urunlerContract.getId());
		satisContract.setAdet(Integer.valueOf(textFieldAdet.getText()));
		satisContract.setTarih(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		new SatisDAL().ekle(satisContract);

		// tabloya da ekle
		fetchDataFromDatabaseToTable();
	}

	@FXML
	void menuItemBorcDuzenle_OnAction(ActionEvent event) {
		new BorcDuzenleFE().initPencere();
	}

	@FXML
	void menuItemBorcEkle_OnAction(ActionEvent event) {
		new BorcEkleFE().initPencere();
	}

	@FXML
	void menuItemMusteriDuzenle_OnAction(ActionEvent event) {
		new MusteriDuzenleFE().initPencere();
	}

	@FXML
	void menuItemPersonelDuzenle_OnAction(ActionEvent event) {
		new PersonelDuzenleFE().initPencere();
	}

	@FXML
	void menuItemPersonelEkle_OnAction(ActionEvent event) {
		new PersonelEkleFE().initPencere();
	}

	@FXML
	void menuItemUrunDuzenle_OnAction(ActionEvent event) {
		new UrunDuzenleFE().initPencere();
	}

	@FXML
	void menuItemUrunEkle_OnAction(ActionEvent event) {
		new UrunEkleFE().initPencere();
	}

	@FXML
	void menuItemYetkiDuzenle_OnAction(ActionEvent event) {
		new YetkiDuzenleFE().initPencere();
	}

	@FXML
	void menuItemYetkiEkle_OnAction(ActionEvent event) {
		new YetkiEkleFE().initPencere();

	}

	@FXML
	void menuItemKategoriEkle_OnAction(ActionEvent event) {
		new KategoriEkleFE().initPencere();
	}

	@FXML
	void menuItemKategoriDuzenle_OnAction(ActionEvent event) {
		new KategoriDuzenleFE().initPencere();

	}

	@FXML
	void initialize() {
		comboBoxSatisUrunAdi.getItems().addAll(new UrunlerDAL().hepsiniAl());
		comboBoxSatisMusteriAdi.getItems().addAll(new MusteriDAL().hepsiniAl());
		fetchDataFromDatabaseToTable();
	}

	@Override
	public void initPencere() {

		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/tr/com/yusuf/fe/AnaPencereFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void fetchDataFromDatabaseToTable() {

		tableColumnSatisId.setCellValueFactory(new PropertyValueFactory<>("satisId"));
		tableColumnHesapAdi.setCellValueFactory(new PropertyValueFactory<>("hesapAdi"));
		tableColumnHesapSoyadi.setCellValueFactory(new PropertyValueFactory<>("hesapSoyadi"));
		tableColumnUrunAdi.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
		tableColumnAdeti.setCellValueFactory(new PropertyValueFactory<>("satisAdet"));
		tableColumnUrunAdi.setCellValueFactory(new PropertyValueFactory<>("satisTarih"));
		tableColumnMusteriAdi.setCellValueFactory(new PropertyValueFactory<>("musteriAd"));
		tableColumnMusteriSoyadi.setCellValueFactory(new PropertyValueFactory<>("musteriSoyad"));
		tableColumnMusteriAdi.setCellValueFactory(new PropertyValueFactory<>("musteriId"));
		tableViewSatislar.setItems(new SatisDAL().satislarinHepsiniAl());

	}

}
