package app.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column
	private String name;
	
	@Column(name = "national_id")
	private String nationalId;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Embedded
	private ContactInformation contactInformation;
	
	@Embedded
	private BankAccountInformation bankAccountInformation;
	
	@Column(name = "joined_on")
	private Date joinedOn;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	public BankAccountInformation getBankAccountInformation() {
		return bankAccountInformation;
	}

	public void setBankAccountInformation(BankAccountInformation bankAccountInformation) {
		this.bankAccountInformation = bankAccountInformation;
	}
	
	public Date getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(Date joinedOn) {
		this.joinedOn = joinedOn;
	}

}
