package JunitManager;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.ArrayList;
import ATMProperties.Account;
import ATMProperties.Bank;
import ATMProperties.User;
import Support.Log;

public class JunitBank {
	
	public String name;
	public ArrayList<User> users;
	public ArrayList<Account> accounts;
	public Bank bank;
	public User user;
	public Account acnt;
	public static String userid;
	
	@BeforeMethod
	public void initializeBankDetails() throws Exception {

       bank = new Bank("ICICI");
	   user = new User("Rahul", "Pavur", "1234", bank);
	   userid = user.getUUID();
	   acnt = new Account("Lakshmi", user, bank);
	}

	@Test()
	public void verifyBankName() throws Exception {

		try {
			Log.description("TC_01: Verify bank name ");
			if(bank.getName().equals("ICICI")) 
				Log.pass("Bank name displaying properly: ");
			else
				Assert.fail("Bank name not displaying properly: ");
			
		} catch (Exception e) {
			System.out.println("Error while verifying bank name: " + e.getMessage());
		}

	}
	
	@Test()
	public void verifyCustomerUniqueId() throws Exception {
		try {
			Log.description("TC_02: Verify customer unique id in bank ");
			if(bank.getNewUserUUID()!= null)
				Log.pass("Customer unique id generated properly: ");
			else 
				Assert.fail("customer unique id not generated properly");
		} catch (Exception e) {
			System.out.println("Error while verifying customer unique id: ");
			
		}
	}

	@Test()
	public void verifyCusotmerAccountUUID() throws Exception {
		try {
			Log.description("TC_03: Verify customer account unique id in bank ");
			if(bank.getNewAccountUUID()!= null)
				Log.pass("Customer account unique id generated properly: ");
			else 
				Assert.fail("customer account unique id not generated properly");
		} catch (Exception e) {
			System.out.println("Error while verifying customer account unique id: ");
			
		}
	}
	
	@Test()
	public void verifyCusotmerAccountCreation() throws Exception {
		try {
			Log.description("TC_04: Verify customer account creation in bank ");
			bank.addAccount(acnt);
			if(bank.accounts.size() == 1)
				Log.pass("Customer account details are added successfully ");
			else 
				Assert.fail("customer account details are not added properly");
		} catch (Exception e) {
			System.out.println("Error while adding customer account details");
			
		}
	}
	
	
	@Test()
	public void verifyCusotmerDetailsCreation() throws Exception {
		try {
			Log.description("TC_05: Verify customer details creation in bank ");
			user = bank.addUser("Rahul", "Pavur", "1234");
			userid = user.getUUID();
			if(user != null)
				Log.pass("Customer details are added successfully in bank ");
			else 
				Assert.fail("customer details are not added properly in bank");
		} catch (Exception e) {
			System.out.println("Error while adding customer details in bank");
			
		}
	}
	
	@Test()
	public void verifyExistingCusotmerLogin() throws Exception {
		try {
			Log.description("TC_06: Verify existing customer login creation in bank ");
			user = bank.addUser("Rahul", "Pavur", "1234");
			userid = user.getUUID();
			user = bank.userLogin(userid, "1234");
			if(user != null)
				Log.pass("user details successfully identified in bank ");
			else 
				Assert.fail("customer details are not identified in bank");
		} catch (Exception e) {
			System.out.println("Error while identifying customer details in bank");
			
		}
	}
	
	@Test()
	public void verifyNonExistingCusotmerLogin() throws Exception {
		try {
			Log.description("TC_07: Verify non existing customer login creation in bank ");
			user = bank.userLogin("****", "1234");
			if(user != null)
				Assert.fail("user details successfully identified in bank ");
			else 
				Log.pass("customer details are not identified in bank and cusomer not registred");
		} catch (Exception e) {
			System.out.println("Error while identifying customer details in bank");
			
		}
	}
	
	
}
