package JunitRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import JunitManager.JunitAccount;
import JunitManager.JunitBank;
import JunitManager.JunitTransaction;
import JunitManager.JunitUser;

public class TestRunner {
   public static void main(String[] args) {
	   									
      		Result result = JUnitCore.runClasses(JunitAccount.class, JunitBank.class, JunitTransaction.class, JunitUser.class);					
			for (Failure failure : result.getFailures()) {							
        		System.out.println(failure.toString());					
     }		
     System.out.println(result.wasSuccessful());					
  	
   }		 
		   
}  	
