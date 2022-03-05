package controller;

import java.time.LocalDate;
import java.util.Optional;

import application.Main;
import exception.NegativeNumberException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RegisterController {
	
	
	@FXML
    TextField montoText;

    @FXML
    TextField descripcionText;

    @FXML
    Button addButton;

    @FXML
    Button cancelButton;

    @FXML
    ComboBox<String> comboNatu;
    
    @FXML
    DatePicker dateSelec;
    
    private Main main; 

    @FXML
    public void addRegister() throws NegativeNumberException{
    	
    	
    	//AGREGAR EXCEPCIONES 
    	String valueMoney = ""; 
    	String valueDescription = ""; 
    	String valueNatu = ""; 
    	Double modificateValue = 0.0; 
    	boolean flag = false; 
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Error Dialog");
    	try {
    		valueMoney = montoText.getText();
    		valueNatu = comboNatu.getSelectionModel().getSelectedItem().toString();
    		LocalDate valueDate = dateSelec.getValue(); 
    		if(valueDate == null) {
    			flag = true; 
    		}
    		valueDescription = descripcionText.getText(); 
    		modificateValue = Double.parseDouble(valueMoney);
    		
    		if(flag==true) {
    			alert.setHeaderText("Mira, tienes un error");
    	    	alert.setContentText("Revisa los datos ingresados!");
    	    	alert.showAndWait();
    		}else {
    			main.registerTransaction(modificateValue, valueNatu, valueNatu, valueDate);
    			main.returnPanelMain();
    		}
    	} catch(NumberFormatException e) {
    		String text = "Dato ingresado no corresponde a un número";
    	}
    }
    @FXML
    public void initialize() {
    	ObservableList<String> list = FXCollections.observableArrayList("Ingreso","Gasto"); 
    	comboNatu.setItems(list);
    }
    @FXML
    public void cancelRegister(ActionEvent event) {
    	
    	main.returnPanelMain();
    	
    }
    
    public void setMain(Main main) {
    	this.main = main; 
    }
	
}
