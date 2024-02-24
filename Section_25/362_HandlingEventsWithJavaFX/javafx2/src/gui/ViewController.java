package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {

	@FXML
	private Button btTest;
	
	@FXML
	public void btTesteAction() {
		System.out.println("Click");
	}
	
}
