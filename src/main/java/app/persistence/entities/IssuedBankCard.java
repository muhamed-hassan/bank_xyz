package app.persistence.entities;

import java.util.Date;
import java.util.Objects;

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
	private BankCard bankCard;
	
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

	public BankCard getBankCard() {
		return bankCard;
	}

	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}

	public Date getDateOfIssuance() {
		return dateOfIssuance;
	}

	public void setDateOfIssuance(Date dateOfIssuance) {
		this.dateOfIssuance = dateOfIssuance;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		IssuedBankCard other = (IssuedBankCard) object;
		return id == other.getId();
	}

}
