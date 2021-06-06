package JunitManager;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import ATMProperties.Account;
import ATMProperties.Bank;
import ATMProperties.Transaction;
import ATMProperties.User;
import Support.Log;

public class JunitTransaction {

	public Bank bank;
	public User user;
	public Account acnt;
	public Transaction transaction;

	@BeforeMethod
	public void initializeTransactionDetails() throws Exception {

		bank = new Bank("ICICI");
		user = new User("Rahul", "Pavur", "1234", bank);
		acnt = new Account("Lakshmi", user, bank);
		transaction = new Transaction(10.00, "Amount for saving", acnt);

	}

	@Test
	public void verifyTransactionAmount() {

		try {
			Log.description("TC_01: Verify customer amount dsipalyingg properly in bank transacions");
			if (transaction.getAmount() == 10.00)
				Log.pass("Cusotmer amonut displayed properly in Bank transaction");
			else
				Assert.fail("Customer amount not updated properly in bank transaction");

		} catch (Exception e) {
			System.out.println("Error while veryfying customer amount in transaction details");

		}

	}

	@Test
	public void verifyTransactionSummaryLine() {

		try {
			Log.description("TC_02: Verify customer transaction summary line displaying properly");
			if (transaction.getSummaryLine() != null)
				Log.pass("Cusotmer transaction summary line details are updated properly");
			else
				Assert.fail("Customer transaction summary line details are not displayed properly");

		} catch (Exception e) {
			System.out.println("Error while veryfying customer transaction summary details");

		}

	}

	@Test
	public void verifyTransactionMemo() {

		try {
			Log.description("TC_03: Verify customer transaction memo details");
			if (transaction.memo.equalsIgnoreCase("Amount for saving"))
				Log.pass("Cusotmer transaction memo updated properly");
			else
				Assert.fail("Customer transaction memo details are not displayed properly");

		} catch (Exception e) {
			System.out.println("Error while veryfying customer memo details");

		}

	}

}
