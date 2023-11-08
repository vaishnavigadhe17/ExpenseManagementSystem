package com.example.expensesystem.entity;

import jakarta.persistence.*;
import javax.sql.DataSource;

@Entity
@Table(name="expenses")

public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="expense",nullable=false)
	private String expense_name;
	private String date;
	private String price;
	
	
	public Expense() {
	
	}
	
	public Expense(String expense_name, String date, String price) {
		super();
		this.expense_name = expense_name;
		this.date = date;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpense_name() {
		return expense_name;
	}
	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
