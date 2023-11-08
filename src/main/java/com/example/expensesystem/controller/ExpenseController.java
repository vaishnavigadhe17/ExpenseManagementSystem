package com.example.expensesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.example.expensesystem.entity.Expense;

import com.example.expensesystem.service.ExpenseService;

@Controller
public class ExpenseController {
	private ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}
	@GetMapping("/viewExpense")
	public String listExpenses(Model model) {
		model.addAttribute("expense",expenseService.getAllExpenses());
		return "view_expense";
	}

	@GetMapping("/addExpense")
	public String addExpense(Model model) {
		
		//create expense object to hold expense data
		Expense expense =new Expense();
		model.addAttribute("expense",expense);
		return "add_expense";
	}
	
	@PostMapping("/viewExpense")
	public String saveExpense(@ModelAttribute("expense") Expense expense) {
		expenseService.saveExpense(expense);
		return "redirect:/viewExpense";
	}
	

	@GetMapping("/viewExpense/editExpense/{id}")
	public String editExpense(@PathVariable Long id, Model model) {
		model.addAttribute("expense",expenseService.getExpenseById(id));
		return "edit_expense";
	}
	
	@PostMapping("/viewExpense/{id}")
	public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense,Model model) {

		Expense existingExpense = expenseService.getExpenseById(id);
		existingExpense.setId(id);
		existingExpense.setExpense_name(expense.getExpense_name());
		existingExpense.setDate(expense.getDate());
		existingExpense.setPrice(expense.getPrice());

		expenseService.updateExpense(existingExpense);
		return "redirect:/viewExpense";		
		
	}

	@GetMapping("/viewExpense/{id}")
	public String deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpenseById(id);
		return "redirect:/viewExpense";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
}
