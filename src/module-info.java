module TuhafiyeProje {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;

	exports tr.com.yusuf.test;

	opens tr.com.yusuf.fe to javafx.graphics, javafx.fxml;
	opens tr.com.yusuf.types to javafx.base;
}
