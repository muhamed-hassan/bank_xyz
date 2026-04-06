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

@Table(name = "issued_bank_card")
@Entity
public class IssuedBankCard {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer issuer;
	
	@ManyToOne
	@JoinColumn(name = "bank_card_type_id", referencedColumnName = "id")
	private BankCard type;
	
	@Column(name = "date_of_issuance")
	private Date dateOfIssuance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getIssuer() {
		return issuer;
	}

	public void setIssuer(Customer issuer) {
		this.issuer = issuer;
	}

	public BankCard getType() {
		return type;
	}

	public void setType(BankCard type) {
		this.type = type;
	}

	public Date getDateOfIssuance() {
		return dateOfIssuance;
	}

	public void setDateOfIssuance(Date dateOfIssuance) {
		this.dateOfIssuance = dateOfIssuance;
	}

}
