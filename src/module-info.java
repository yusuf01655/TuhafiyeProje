module TuhafiyeProje {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;

	exports tr.com.yusuf.test;

	opens tr.com.yusuf.fe to javafx.graphics, javafx.fxml;
}
