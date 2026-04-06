package app.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BankAccountInfo {

	@Column(name = "account_number")
	private String accountNumber;	
	
	private float balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
}
