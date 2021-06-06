package ATMProperties;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

	private String firstName;
	private String lastName;
	private String uuid;
	private byte pinHash[];
	public ArrayList<Account> accounts;

	/**
	 * @param firstName
	 * @param lastName
	 * @param pin
	 * @param theBank
	 */
	public User(String firstName, String lastName, String pin, Bank theBank) {
		this.firstName = firstName;
		this.lastName = lastName;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}

		this.uuid = theBank.getNewUserUUID();
		this.accounts = new ArrayList<Account>();

		System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.uuid);
	}

	/**
	 * @param anAcct
	 */
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}

	/**
	 * @return
	 */
	public String getUUID() {
		return this.uuid;
	}

	/**
	 * @param aPin
	 * @return
	 */
	public boolean validatePin(String aPin) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}

		return false;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 */
	public void printAccountsSummary() {
		System.out.printf("\n\n%s's accounts summary\n", this.firstName);
		for (int a = 0; a < this.accounts.size(); a++) {
			System.out.printf("   %d) %s\n", a + 1, this.accounts.get(a).getSummaryLine());
		}

		System.out.println();
	}

	/**
	 * @return
	 */
	public int numAccounts() {
		return this.accounts.size();
	}

	/**
	 * @param acctIdx
	 */
	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();

	}

	/**
	 * @param acctIdx
	 * @return
	 */
	public double getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}

	/**
	 * @param acctIdx
	 * @return
	 */
	public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}

	/**
	 * @param acctIdx
	 * @param amount
	 * @param memo
	 */
	public void addAcctTransaction(int acctIdx, double amount, String memo) {

		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}
}
