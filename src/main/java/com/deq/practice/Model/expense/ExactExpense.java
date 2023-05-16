package com.deq.practice.Model.expense;
/**
* @author ${Ankita}
*/
import java.util.List;

import com.deq.practice.Model.User;
import com.deq.practice.Model.split.ExactSplit;
import com.deq.practice.Model.split.Split;

public class ExactExpense extends Expense{

	public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }

        if (totalAmount != sumSplitAmount) {
            return false;
        }

        return true;
    }
}
