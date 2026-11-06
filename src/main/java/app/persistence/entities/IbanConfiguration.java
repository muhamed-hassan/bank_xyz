package app.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "iban_configuration")
@Entity
public class IbanConfiguration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "check_digits")
	private String checkDigits;
	
	@Column(name = "bank_code")
	private String bankCode;
	
	@Column(name = "sort_code")
	private String sortCode;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCheckDigits() {
		return checkDigits;
	}

	public void setCheckDigits(String checkDigits) {
		this.checkDigits = checkDigits;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}	
	
}
