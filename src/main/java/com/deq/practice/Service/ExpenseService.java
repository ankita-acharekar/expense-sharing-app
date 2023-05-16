package com.deq.practice.Service;
/**
 * @author ${Ankita}
 */
import java.util.List;

import com.deq.practice.Model.User;
import com.deq.practice.Model.expense.EqualExpense;
import com.deq.practice.Model.expense.ExactExpense;
import com.deq.practice.Model.expense.Expense;
import com.deq.practice.Model.expense.ExpenseMetadata;
import com.deq.practice.Model.expense.ExpenseType;
import com.deq.practice.Model.split.Split;

public class ExpenseService {
	public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        switch (expenseType) {
            case EXACT:
                return new ExactExpense(amount, paidBy, splits, expenseMetadata);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                return new EqualExpense(amount, paidBy, splits, expenseMetadata);
            default:
                return null;
        }
    }
}
