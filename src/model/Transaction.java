package model;

import java.time.LocalDate;

public class Transaction {
	
	private double monto;
	private String description; 
	private String type;
	private LocalDate date; 
	
	public Transaction(double monto, String description, String type, LocalDate date) {
		this.monto = monto;
		this.description = description; 
		this.type = type;
		this.date = date; 
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
