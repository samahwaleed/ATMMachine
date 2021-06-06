package ATMProperties;

import java.util.ArrayList;

public class Account {

	private String name;
    private double balance;
	private String uuid;
	private User holder;
	public ArrayList<Transaction> transactions;

	/**
	 * @param name
	 * @param holder
	 * @param theBank
	 */
	public Account(String name, User holder, Bank theBank) {
		this.name = name;
		this.holder = holder;
		this.uuid = theBank.getNewAccountUUID();
		this.transactions = new ArrayList<Transaction>();

	}

	/**
	 * To get user unique id
	 * 
	 * @return
	 */
	public String getUUID() {
		return this.uuid;
	}

	/**
	 * To print summary of transaction
	 * 
	 * @return
	 */
	public String getSummaryLine() {
		double balance = this.getBalance();

		if (balance >= 0) {
			return String.format("%s: $%.02f : %s", this.uuid, balance, this.name);
		} else {
			return String.format("%s: $(%.02f) : %s", this.uuid, balance, this.name);
		}
	}

	/**
	 * @return
	 */
	public double getBalance() {

		double balance = 0;
		for (Transaction t : this.transactions) {
			balance += t.getAmount();
		}

		return balance;
	}

	/**
	 * To print transaction history
	 * 
	 */
	public void printTransHistory() {
		System.out.printf("\nTransaction history for account %s\n", this.uuid);
		for (int t = this.transactions.size() - 1; t >= 0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();
	}

	/**
	 * To add transaction on user account
	 * 
	 * @param amount
	 * @param memo
	 */
	public void addTransaction(double amount, String memo) {

		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
	}
}
