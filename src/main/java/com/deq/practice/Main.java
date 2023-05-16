package com.deq.practice;
/**
 * @author ${Ankita}
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.deq.practice.Model.User;
import com.deq.practice.Model.expense.ExpenseType;
import com.deq.practice.Model.split.EqualSplit;
import com.deq.practice.Model.split.ExactSplit;
import com.deq.practice.Model.split.Split;

public class Main {
	public static void main(String[] args) {
		ExpenseManager expenseManager = new ExpenseManager();

		expenseManager.addUser(new User("u1", "User1", "ankita@deqode.com", "8652458752"));
		expenseManager.addUser(new User("u2", "User2", "swati@deqode.com", "9876543210"));
		expenseManager.addUser(new User("u3", "User3", "harish@deqode.com", "9658742001"));
		expenseManager.addUser(new User("u4", "User4", "abhishek@deqode.com", "7852036985"));

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String command = scanner.nextLine();
			String[] commands = command.split(" ");
			String commandType = commands[0];

			switch (commandType) {
			case "SHOW":
				if (commands.length == 1) {
					expenseManager.showBalances();
				} else {
					expenseManager.showBalance(commands[1]);
				}
				break;
			case "EXPENSE":
				String paidBy = commands[1];
				Double amount = Double.parseDouble(commands[2]);
				int noOfUsers = Integer.parseInt(commands[3]);
				String expenseType = commands[4 + noOfUsers];
				List<Split> splits = new ArrayList<>();
				switch (expenseType) {
				case "EQUAL":
					for (int i = 0; i < noOfUsers; i++) {
						splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
					}
					expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
					break;
				case "EXACT":
					for (int i = 0; i < noOfUsers; i++) {
						splits.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]),
								Double.parseDouble(commands[5 + noOfUsers + i])));
					}
					expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
					break;
				}
				break;
			}
		}
	}
}
