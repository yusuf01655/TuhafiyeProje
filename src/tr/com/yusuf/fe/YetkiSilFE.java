package tr.com.yusuf.fe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tr.com.yusuf.interfaces.FeInterfaces;

public class YetkiSilFE implements FeInterfaces {

	public YetkiSilFE() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initPencere() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/tr/com/yusuf/fe/YetkiSilFE.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/tr/com/yusuf/test/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
