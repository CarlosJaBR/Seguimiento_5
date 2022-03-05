package application;
	
import java.io.IOException;
import java.time.LocalDate;

import controller.ListController;
import controller.PanelController;
import controller.PanelMainController;
import controller.RegisterController;
import javafx.application.Application;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.SystemBack;
import model.Transaction;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//PROYECTO BANCO ALFA
	private Stage currentStage;
	private SystemBack sb; 
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			sb = new SystemBack();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Panel.fxml"));
			
			BorderPane root;
			root = (BorderPane)loader.load();
			PanelController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
			//currentStage.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public void showPanelMain() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/PanelMain.fxml"));
			
			BorderPane root;
			root = (BorderPane)loader.load();
			PanelMainController panelMain = loader.getController();
			panelMain.setMain(this);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			currentStage.close();
			stage.show();
			currentStage = stage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showRegister() {
		
		try {
			Stage stage = new Stage(); // Ventana
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Register.fxml"));   
			root = (BorderPane)loader.load();
			RegisterController regis = loader.getController();
			regis.setMain(this);
			Scene scene = new Scene(root); //Contenido de la ventana
			stage.setScene(scene);
			stage.show();
			currentStage = stage; 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void showList() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/PanelList.fxml"));
			
			BorderPane root;
			root = (BorderPane)loader.load();
			ListController listController = loader.getController();
			listController.setMain(this);
			listController.refrestData();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			currentStage.close();
			stage.show();
			currentStage = stage; 
		
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}	
	
	public void returnPanelMain() {
		currentStage.close(); 
	}
	
	public void registerTransaction(double monto, String description, String type, LocalDate date) {
		sb.addTransaction(monto, description, type, date);
		
	}
	
	public void deleteTrasaction(Transaction transaction) {
		sb.removeTransaction(transaction); 
	}
	
	public FilteredList<Transaction> getDatos() {
		return sb.getData();  
		
	}
	
	public String refreshBalanceNormal() {
		String text = Double.toString(sb.valueBalanceNormal());
		return text; 
	}
	public String refreshBalanceFilter() {
		String text = Double.toString(sb.valueBalanceFilter());
		return text;
	}
	
	public void applyFilter(LocalDate minDate, LocalDate maxDate) {
        sb.applyFilter(minDate, maxDate);
    }

    public void deleteFilt() {
        sb.deleteFilter();
    }
    
	
}
