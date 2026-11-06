package app.persistence.repositories;

import java.util.LinkedHashSet;

import org.springframework.stereotype.Repository;

import app.persistence.entities.Customer;
import app.web.controllers.models.CustomerUpdateModel;
import lib.persistence.repositories.BaseRepository;

@Repository
public class CustomerRepository extends BaseRepository<Customer> {
	
	public Object[] findDetailedViewOfCustomerInformation(int customerId) {
		
		LinkedHashSet<String> pathsOfFields = new LinkedHashSet<String>();
		pathsOfFields.add("customer.name");
		pathsOfFields.add("customer.nationalId");
		pathsOfFields.add("customer.dateOfBirth");
		pathsOfFields.add("customer.contactInformation.mobile");
		pathsOfFields.add("customer.contactInformation.email");
		pathsOfFields.add("customer.contactInformation.mailingAddress");
		pathsOfFields.add("customer.bankAccountInformation.accountNumber");
		pathsOfFields.add("customer.bankAccountInformation.balance");
		pathsOfFields.add("customer.joinedOn");
		
		Object[] rawRecord = findById(customerId, pathsOfFields);
		
		return rawRecord;
	}
	
	public Object[] findUpdateViewOfCustomerInformation(int customerId) {
		
		LinkedHashSet<String> pathsOfFields = new LinkedHashSet<String>();
		pathsOfFields.add("customer.contactInformation.mobile");
		pathsOfFields.add("customer.contactInformation.email");
		pathsOfFields.add("customer.contactInformation.mailingAddress");
		
		Object[] rawRecord = findById(customerId, pathsOfFields);
		
		return rawRecord;
	}
	
	public void update(int customerId, CustomerUpdateModel customerUpdateModel) {
		
		LinkedHashSet<String> pathsOfFields = new LinkedHashSet<String>();
		pathsOfFields.add("customer.contactInformation.mobile");
		pathsOfFields.add("customer.contactInformation.email");
		pathsOfFields.add("customer.contactInformation.mailingAddress");
		
		updateById(customerId, pathsOfFields, customerUpdateModel);		
	}

}
