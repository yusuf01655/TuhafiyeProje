module TuhafiyeProje {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens tr.com.yusuf.test to javafx.graphics, javafx.fxml;
}
