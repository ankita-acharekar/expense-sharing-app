package com.deq.practice.Model.split;
/**
 * @author ${Ankita}
 */
import com.deq.practice.Model.User;

public class ExactSplit extends Split{

	public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
