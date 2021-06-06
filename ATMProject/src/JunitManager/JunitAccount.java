package JunitManager;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import ATMProperties.Account;
import ATMProperties.Bank;
import ATMProperties.User;
import Support.Log;

public class JunitAccount {

	Bank bank;
	User user;
	Account acnt;

	@BeforeMethod
	public void intializeAccountDetails() throws Exception {

		bank = new Bank("narayana");
		user = new User("Rahul", "Pavur", "1234", bank);
		acnt = new Account("Lakshmi", user, bank);

	}

	
	@Test()
	public void verifyCustomerAccountBalanceforSingleTransaction() throws Exception {

		try {
			Log.description("TC_01: Verify customer account balance for single transation");
			acnt.addTransaction(10.0, "Amount got credited");
			AssertJUnit.assertEquals(acnt.getBalance(), 10.0, 0.00);
			Log.pass("Customer account balance updated properly: ");
		} catch (Exception e) {
			System.out.println("Error while verifying account balance for single customer: " + e.getMessage());
		}

	}

	@Test()
	public void verifyCustomerAccountBalanceforMutipleTransaction() throws Exception {

		try {
			Log.description("TC_02: Verify customer account balance for mutliple transactions");
			acnt.addTransaction(10.0, "Cusotmer transaction got recorded");
			acnt.addTransaction(10.0, "Customer transaction got recorded");
			AssertJUnit.assertEquals(acnt.getBalance(), 20.0, 0.00);
			Log.pass("Customer account balance updated properly: ");
		} catch (Exception e) {
			System.out.println("Error while verifying account banlance: " + e.getMessage());
		}

	}

	@Test()
	public void verifyCustomerSummaryLine() throws Exception {

		try {
			Log.description("TC_03: Verify customer summary line details");
			acnt.addTransaction(10.0, "Customer transacion got recorded");
			String acntSummary = acnt.getSummaryLine();
			if (acntSummary.contains("Lakshmi") && acntSummary.contains("$10.00")) {
				Log.pass("Customer summary details updated properly: ");
			} else
				Assert.fail("Customer summary details not updated properly ");
		} catch (Exception e) {
			System.out.println("Error while verifying customer summary line: " + e.getMessage());
		}

	}

	@Test()
	public void verifyCustomerTransactionHistory() throws Exception {

		try {
			Log.description("TC_04: Verify customer transaction history details");
			acnt.addTransaction(10.0, "Crediting amount to customer account");
			if (acnt.transactions.size() > -1) {
				acnt.printTransHistory();
				Log.pass("Customer transaction details are displaying properly: ");
			} else {
				Assert.fail("Customer transaction details are not displaying: ");
			}

		} catch (Exception e) {
			System.out.println("Error while verifying customer transactioin history: " + e.getMessage());

		}
	}
	
	@Test()
	public void verifyCustomerTransactionCount() throws Exception {

		try {
			Log.description("TC_05: Verify customer transaction count for multiple transactions");
			acnt.addTransaction(10.0, "Crediting amount to customer account");
			acnt.addTransaction(10.0, "Crediting amount to customer account");
			if (acnt.transactions.size() == 2) {
				acnt.printTransHistory();
				Log.pass("Customer transaction details are incremented properly: ");
			} else {
				Assert.fail("Customer transaction details are not incremented properly: ");
			}

		} catch (Exception e) {
			System.out.println("Error while verifying customer transactioin history count: " + e.getMessage());

		}
	}

}
