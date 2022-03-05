package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class PanelController {

	
	@FXML
    ImageView imagen;

    @FXML
    Button loginButton;

	private Main main;

	public void openPanelMain(ActionEvent event) {
		main.showPanelMain();
	}
	public void setMain(Main main) {
		this.main = main; 
	}
}
