package JunitManager;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import ATMProperties.Account;
import ATMProperties.Bank;
import ATMProperties.User;
import Support.Log;

public class JunitUser {

	Bank bank;
	User user;
	Account acnt;

	@BeforeMethod
	public void initializeUser() throws Exception {

		bank = new Bank("narayana");
		user = new User("Rahul", "Pavur", "1234", bank);
		acnt = new Account("Lakshmi", user, bank);
		user.accounts.add(acnt);

	}

	@Test
	public void verifyUserUID() throws Exception {
		try {
			Log.description("TC-01: Verify user unique ID");
			if (user.getUUID() != null) {
				Log.pass("Use unique ID generated successfully");
			} else {
				Assert.fail("User unique ID not generated");
			}

		} catch (Exception e) {
			System.out.println("Error while validating user unique ID");

		}

	}

	@Test
	public void validateUserPin() throws Exception {
		try {
			Log.description("TC-02: Validate user pin ID");
			if (user.validatePin("1234")) {
				Log.pass("User pin validated successfully");
			} else {
				Assert.fail("User pin not validated");
			}

		} catch (Exception e) {
			System.out.println("Error while validating user pin");

		}

	}

	@Test
	public void validateUserFirstName() throws Exception {
		try {
			Log.description("TC-03: Veify user first name");
			if (user.getFirstName().equalsIgnoreCase("Rahul")) {
				Log.pass("User first name validated successfully");
			} else {
				Assert.fail("User first anme not updated properly");
			}

		} catch (Exception e) {
			System.out.println("Error while validating user first name");

		}

	}

	@Test
	public void verifyUserAccntSize() throws Exception {
		try {
			Log.description("TC-04: Veify user accounts size");
			user.addAccount(acnt);
			System.out.println("User accounts size: " + user.numAccounts());
			if (user.numAccounts() >= 1) {
				Log.pass("User first name validated successfully");
			} else {
				Assert.fail("User first anme not updated properly");
			}

		} catch (Exception e) {
			System.out.println("Error while validating user account size");

		}

	}

	@Test
	public void addUserAccountTransaction() throws Exception {
		try {
			Log.description("TC-05: Add user account transaction");
			user.addAcctTransaction(0, 10.00, "Amount transfer to family");
			System.out.println("User account balance is:" + user.getAcctBalance(0));
		} catch (Exception e) {
			System.out.println("Error while validating user first name");

		}

	}

	@Test
	public void verifyUserAccountBalance() throws Exception {
		try {
			Log.description("TC-06: verify user account balance");
			user.addAcctTransaction(0, 10.00, "Amount transfer to family");
			if (user.getAcctBalance(0) == 10.00)
				Log.pass("User account balance displayed correctly");
			else
				Assert.fail("User account balance not updating correctly");
		} catch (Exception e) {
			System.out.println("Error while verifying user account balance");

		}

	}

	@Test
	public void verifyUserUniqueId() throws Exception {
		try {
			Log.description("TC-07: verify user unique id");
			if (user.getAcctUUID(0) != null)
				Log.pass("User account unique id dispalyed correctly");
			else
				Assert.fail("User account unique id not updated correctly");
		} catch (Exception e) {
			System.out.println("Error while verifying user account UUID");

		}

	}

	@Test
	public void verifyUserAccountTransHistory() throws Exception {
		try {
			Log.description("TC-08: verify user account history");
			user.printAcctTransHistory(0);
			Log.pass("User account unique id dispalyed correctly");
		} catch (Exception e) {
			System.out.println("Error while verifying user account UUID");

		}

	}

}
