package app.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer initiator;
	
	@ManyToOne
	@JoinColumn(name = "bank_transaction_type_id", referencedColumnName = "id")
	private BankTransaction type;
	
	private float amount;
	
	@Column(name = "occurred_on")
	private Date occurredOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getInitiator() {
		return initiator;
	}

	public void setInitiator(Customer initiator) {
		this.initiator = initiator;
	}

	public BankTransaction getType() {
		return type;
	}

	public void setType(BankTransaction type) {
		this.type = type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getOccurredOn() {
		return occurredOn;
	}

	public void setOccurredOn(Date occurredOn) {
		this.occurredOn = occurredOn;
	}	
	
}
