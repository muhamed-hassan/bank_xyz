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

@Table(name = "borrowed_loan")
@Entity
public class BorrowedLoan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer borrower;
	
	@ManyToOne
	@JoinColumn(name = "loan_type_id", referencedColumnName = "id")
	private Loan type;
	
	private float amount;
	
	@Column(name = "borrowing_date")
	private Date borrowingDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getBorrower() {
		return borrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}

	public Loan getType() {
		return type;
	}

	public void setType(Loan type) {
		this.type = type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getBorrowingDate() {
		return borrowingDate;
	}

	public void setBorrowingDate(Date borrowingDate) {
		this.borrowingDate = borrowingDate;
	}

}
