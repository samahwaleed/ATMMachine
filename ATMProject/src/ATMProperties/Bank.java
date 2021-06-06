package ATMProperties;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Lakshmi.nagandla
 *
 */
public class Bank {

	private String name;
	private ArrayList<User> users;
	public ArrayList<Account> accounts;

	/**
	 * @param name
	 */
	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();

	}

	/**
	 * @return
	 */
	public String getNewUserUUID() {

		String uuid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;

		do {
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer) rng.nextInt(10)).toString();
			}

			nonUnique = false;
			for (User u : this.users) {
				if (uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}

			}

		} while (nonUnique);

		return uuid;
	}
	

	/**
	 * @return
	 */
	public String getNewAccountUUID() {
		String uuid;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique;

		do {
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer) rng.nextInt(10)).toString();
			}

			nonUnique = false;
			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}

			}

		} while (nonUnique);

		return uuid;
	}
	
	

	/**
	 * @param anAcct
	 */
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	

	/**
	 * @param firstName
	 * @param lastName
	 * @param pin
	 * @return
	 */
	public User addUser(String firstName, String lastName, String pin) {
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);

		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);

		return newUser;
	}
	
	

	/**
	 * @param userID
	 * @param pin
	 * @return
	 */
	public User userLogin(String userID, String pin) {

		for (User u : this.users) {
			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			}
		}
		return null;
	}
	
	

	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}
