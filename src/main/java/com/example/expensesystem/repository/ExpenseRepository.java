package com.example.expensesystem.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensesystem.entity.Expense;


public interface ExpenseRepository extends JpaRepository<Expense,Long>{


}
