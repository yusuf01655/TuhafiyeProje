package tr.com.yusuf.fe;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class AnaPencereFEController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

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
	void menuItemBorcDuzenle_OnAction(ActionEvent event) {
		new BorcDuzenleFE().initPencere();
	}

	@FXML
	void menuItemBorcEkle_OnAction(ActionEvent event) {
		new BorcEkleFE().initPencere();
	}

	@FXML
	void menuItemBorcGoster_OnAction(ActionEvent event) {
		new BorcGosterFE().initPencere();
	}

	@FXML
	void menuItemBorcSil_OnAction(ActionEvent event) {
		new BorcSilFE().initPencere();
	}

	@FXML
	void menuItemIdIleBorcGoster_OnAction(ActionEvent event) {
		new IdIleBorcGosterFE().initPencere();
	}

	@FXML
	void menuItemIdIleMusteriGoster_OnAction(ActionEvent event) {
		new IdIleMusteriGosterFE().initPencere();
	}

	@FXML
	void menuItemIdIlePersonelGoster_OnAction(ActionEvent event) {
		new IdIlePersonelGoster().initPencere();
	}

	@FXML
	void menuItemIdIleUrunGoster_OnAction(ActionEvent event) {
		new IdIleUrunGosterFE().initPencere();
	}

	@FXML
	void menuItemIdIleYetkiGoster_OnAction(ActionEvent event) {
		new IdIleYetkiGosterFE().initPencere();
	}

	@FXML
	void menuItemMusteriDuzenle_OnAction(ActionEvent event) {
		new MusteriDuzenleFE().initPencere();
	}

	@FXML
	void menuItemMusteriGoster_OnAction(ActionEvent event) {
		new MusteriGosterFE().initPencere();
	}

	@FXML
	void menuItemMusteriSil_OnAction(ActionEvent event) {
		new MusteriSilFE().initPencere();
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
	void menuItemPersonelGoster_OnAction(ActionEvent event) {
		new PersonelGosterFE().initPencere();
	}

	@FXML
	void menuItemPersonelSil_OnAction(ActionEvent event) {
		new PersonelSilFE().initPencere();
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
	void menuItemUrunGoster_OnAction(ActionEvent event) {
		new UrunGosterFE().initPencere();
	}

	@FXML
	void menuItemUrunSil_OnAction(ActionEvent event) {
		new UrunSilFE().initPencere();
	}

	@FXML
	void menuItemYetkiDuzenle_OnAction(ActionEvent event) {
		new YetkiDuzenleFE().initPencere();
	}

	@FXML
	void menuItemYetkiGoster_OnAction(ActionEvent event) {
		new YetkiGosterFE().initPencere();
	}

	@FXML
	void menuItemYetkiSil_OnAction(ActionEvent event) {
		new YetkiSilFE().initPencere();
	}

	@FXML
	void menuItemYetkiEkle_OnAction(ActionEvent event) {
		new YetkiEkleFE().initPencere();

	}

	@FXML
	void initialize() {

	}

}
