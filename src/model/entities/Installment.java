package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Installment {
	private LocalDate dueDate;
	private Double amount;
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Construtores
	
	public Installment() {
		
	}
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	// Lista para adicionar informações a este juro
	
	List <Installment> list = new  ArrayList<>();	
	
	
	// Ge
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Double amount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return dueDate.format(fmt) +
				" - "
				+ String.format("%.2f%n", amount);}

}
