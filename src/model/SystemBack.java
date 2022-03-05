package model;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class SystemBack {
	
	ObservableList<Transaction> items = FXCollections.observableArrayList(); 
	FilteredList<Transaction > itemsFiltered = new FilteredList<>(items);
	
	
	public SystemBack() {
		items = FXCollections.observableArrayList(); 
		itemsFiltered = new FilteredList<>(items);
	}
	
	public void addTransaction(double monto, String description, String type, LocalDate date) {
		Transaction obj = new Transaction(monto,description,type,date);
		items.add(obj);
	}
	public void removeTransaction(Transaction transaction) {
		items.remove(transaction);
	}
	
	public FilteredList<Transaction> getData() {
		return itemsFiltered;
	}
	
	//Se agrego
	public void applyFilter(LocalDate minDate, LocalDate maxDate) {

        LocalDate finalMin = minDate == null ? LocalDate.MIN : minDate;
        LocalDate finalMax = maxDate == null ? LocalDate.MAX : maxDate;

        itemsFiltered.setPredicate(item -> !finalMin.isAfter(item.getDate()) && !finalMax.isBefore(item.getDate()));
    }

    public void deleteFilter() {
        itemsFiltered.setPredicate(item -> true);
    }
    
    public double valueBalanceNormal() {
    	double monto = 0.0; 
    	double ingreso = 0.0; 
    	double gasto = 0.0; 
    	for(int i = 0; i <items.size(); i++) {
    		if(items.get(i).getType().equals("Ingreso")) {
    			ingreso+=items.get(i).getMonto(); 
    		}else {
    			gasto+=items.get(i).getMonto(); 
    		}
    	}
    	monto = ingreso-gasto; 
    	return monto; 
    }
    public double valueBalanceFilter() {
    	double monto = 0.0; 
    	double ingreso = 0.0; 
    	double gasto = 0.0; 
    	for(int i = 0; i <itemsFiltered.size(); i++) {
    		if(itemsFiltered.get(i).getType().equals("Ingreso")) {
    			ingreso+=itemsFiltered.get(i).getMonto(); 
    		}else {
    			gasto+=itemsFiltered.get(i).getMonto(); 
    		}
    	}
    	monto = ingreso-gasto; 
    	return monto; 
    }

}
