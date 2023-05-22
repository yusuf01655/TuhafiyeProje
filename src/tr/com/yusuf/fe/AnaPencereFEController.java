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
	void menuItemYetkiEkle_OnAction(ActionEvent event) {
		new YetkiEkleFE().initPencere();

	}

	@FXML
	void initialize() {

	}

}
