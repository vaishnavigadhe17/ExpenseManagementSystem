package com.example.expensesystem.service;


import java.util.List;

import com.example.expensesystem.entity.Expense;


public interface ExpenseService {
	List<Expense> getAllExpenses();
	
	Expense saveExpense(Expense expense);
	
	Expense getExpenseById(Long id);
	Expense updateExpense(Expense expense);
	
	void deleteExpenseById(Long id);
}
