package ATMProperties;
import java.util.Date;

public class Transaction {

	private double amount;
	private Date timestamp;
	public String memo;
	private Account inAccount;
	
	
	/**
	 * @param amount
	 * @param inAccount
	 */
	public Transaction(double amount, Account inAccount){
		this.amount = amount;
		this.inAccount = inAccount;
		this.timestamp = new Date();
		this.memo = "";
	}
	
	/**
	 * @param amount
	 * @param memo
	 * @param inAccount
	 */
	public Transaction(double amount, String memo, Account inAccount){
		
		this(amount, inAccount);
		this.memo = memo;
	}
	
	/**
	 * @return
	 */
	public double getAmount(){
		return this .amount;
	}
	
	/**
	 * @return
	 */
	public String getSummaryLine(){
		
		if(this.amount >= 0){
			return String.format("%s: $%.02f : %s", this.timestamp.toString(), this.amount, this.memo);
		}else{
			return String.format("%s: $(%.02f) : %s", this.timestamp.toString(), -this.amount, this.memo);
		}
	}
}
