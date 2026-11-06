package app.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "initiated_transaction")
@Entity
public class InitiatedTransaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column
	private float amount;
	
	@Column(name = "occurred_on")
	private Date occurredOn;
	
	@ManyToOne
	@JoinColumn(name = "initiator_id", referencedColumnName = "id")
	private Customer initiator;
	
	@ManyToOne
	@JoinColumn(name = "beneficiary_id", referencedColumnName = "id")
	private Customer beneficiary;
	
	@ManyToOne
	@JoinColumn(name = "bank_transaction_type_id", referencedColumnName = "id")
	private BankTransaction bankTransaction;	
	
	@Column
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public Customer getInitiator() {
		return initiator;
	}

	public void setInitiator(Customer initiator) {
		this.initiator = initiator;
	}

	public Customer getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Customer beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BankTransaction getBankTransaction() {
		return bankTransaction;
	}

	public void setBankTransaction(BankTransaction bankTransaction) {
		this.bankTransaction = bankTransaction;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		InitiatedTransaction other = (InitiatedTransaction) object;
		return id == other.getId();
	}
	
}
