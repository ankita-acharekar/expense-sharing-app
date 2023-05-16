package com.deq.practice.Model.expense;
/**
* @author ${Ankita}
*/
import java.util.List;

import com.deq.practice.Model.User;
import com.deq.practice.Model.split.EqualSplit;
import com.deq.practice.Model.split.Split;

public class EqualExpense extends Expense{

	public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
