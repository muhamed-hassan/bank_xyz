package app.persistence.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import app.persistence.entities.IssuedBankCard;
import lib.persistence.repositories.BaseRepository;

@Repository
public class IssuedBankCardRepository extends BaseRepository<IssuedBankCard> {
	
	public ArrayList<Object[]> findTheLast5IssuedBankCardsThatBelongsToCustomerOf(int customerId) {
		
		String idParam = "idParam";
		
		String dataQuery = "SELECT   issuedBankCard.id, issuedBankCard.dateOfIssuance, issuedBankCard.bankCard.type " +
				           "FROM     IssuedBankCard issuedBankCard " +
				           "WHERE    issuedBankCard.issuer.id = :" + idParam + " " +
				           "ORDER BY issuedBankCard.id ASC";
		
		ArrayList<Object[]> rawData = (ArrayList<Object[]>) entityManager.createQuery(dataQuery, Object[].class)
																			.setParameter(idParam, customerId)
																			.setMaxResults(5)
																			.getResultList();
		
		return rawData;
	}

}
