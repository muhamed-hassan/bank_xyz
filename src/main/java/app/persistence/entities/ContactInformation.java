package app.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactInformation {
	
	@Column
	private String mobile;
	
	@Column
	private String email;
	
	@Column(name = "mailing_address")
	private String mailingAddress;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	
}
