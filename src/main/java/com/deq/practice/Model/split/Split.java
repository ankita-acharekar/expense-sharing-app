package com.deq.practice.Model.split;
/**
 * @author ${Ankita}
 */
import com.deq.practice.Model.User;

public class Split {

	private User user;
    double amount;

    public Split(User user) {
        this.user = user;
    }

	public User getUser() {
		return user;
	}

	public double getAmount() {
		return amount;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
