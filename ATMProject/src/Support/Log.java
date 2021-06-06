package Support;

import org.junit.Assert;

public class Log {
	
	/**
	 * @param message
	 * @throws Exception
	 */
	public static void pass(String message) throws Exception {
		Assert.assertEquals(true, true);
		System.out.println(message+" Passed ");
	}
	
	/**
	 * @param message
	 * @throws Exception
	 */
	public static void fail(String message) throws Exception {
		Assert.assertEquals(true, false);
		System.out.println(message+" Failed ");
	}
	
	/**
	 * @param message
	 * @throws Exception
	 */
	public static void description(String message) throws Exception {
		System.out.println(message);
	}

}
