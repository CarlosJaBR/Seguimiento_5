package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class PanelMainController {

	private Main main; 
	
	@FXML
    Button registerButton;

    @FXML
    Button viewTable;
    
    @FXML 
    ImageView image; 

    @FXML
    public void openRegister(ActionEvent event) {
    	
    	main.showRegister(); 
    	//System.out.println("Hola 1"); 
    }

    @FXML
    public void openTable(ActionEvent event) {
    	
    	main.showList(); 
    	//System.out.println("Hola 2"); 
    }


	
	public void setMain(Main main) {
		this.main = main; 
	}
	
	public void closePanel() {
		main.returnPanelMain();
	}
	
}
