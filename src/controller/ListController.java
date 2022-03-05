package controller;

import java.time.LocalDate;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Transaction;

public class ListController {
		@FXML
	    TableView<Transaction> table;
		

	    @FXML
	    TableColumn<Transaction, Double> montoColumn;

	    @FXML
	    TableColumn<Transaction, LocalDate> dateColumn;

	    @FXML
	    TableColumn<Transaction, String> descriptionColumn;

	    @FXML
	    TableColumn<Transaction, String> typeColumn;
	    
	    
	    @FXML
	    Button deleteButton;

	    private Main main; 
	    
	    @FXML 
	    Label valueB;
	    
	    @FXML
	    Button backPanel;
	    
	    @FXML
	    DatePicker dateMax;

	    @FXML
	    DatePicker dateMin;
	    
	    
	    @FXML
	    public void initialize() {
	        montoColumn.setCellValueFactory(new PropertyValueFactory<>("monto"));
	        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
	        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
	        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
	        
	    }
	    
	    @FXML
	    public void deleteObj(ActionEvent event) {
	    	
	    	Transaction transaction = table.getSelectionModel().getSelectedItem();
	    	
			main.deleteTrasaction(transaction);
	    	
			refrestData(); 
	    }
	    
	    public void refrestData() {
	    	table.setItems(main.getDatos());
	    	calculateB(); 
	    }
	    
	    public void setMain(Main main) {
	    	this.main = main; 
	    }
	    
	    
	    public void calculateB() {
	    	valueB.setText(main.refreshBalanceNormal());
	    }
	    @FXML
	    public void returnMain(ActionEvent event) {
	    	main.returnPanelMain();
	    }
	    
	    @FXML 
	    public void shareFiltre(){ 
	    	LocalDate min = dateMin.getValue();
	    	LocalDate max = dateMax.getValue(); 
	    	main.applyFilter(min, max); 
	    	valueB.setText(main.refreshBalanceFilter());
	    	dateMin.setValue(null);
	    	dateMax.setValue(null);
	    }
	    
	    @FXML
	    public void deleteFil() {
	    	main.deleteFilt();
	    	
	    	calculateB(); 
	    }
	    
	    
}
