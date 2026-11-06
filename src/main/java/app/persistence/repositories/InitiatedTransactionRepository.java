package app.persistence.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import app.persistence.entities.InitiatedTransaction;
import lib.persistence.repositories.BaseRepository;

@Repository
public class InitiatedTransactionRepository extends BaseRepository<InitiatedTransaction> {

	public ArrayList<Object[]> findTheLast5TransactionsThatBelongsToCustomerOf(int customerId) {
		
		String idParam = "idParam";
		
		String dataQuery = "SELECT   initiatedTransaction.id, initiatedTransaction.amount, initiatedTransaction.occurredOn, " +
							"        initiatedTransaction.bankTransaction.type " +
				           "FROM     InitiatedTransaction initiatedTransaction " +
				           "WHERE    initiatedTransaction.initiator.id = :" + idParam + " " +
				           "ORDER BY initiatedTransaction.id ASC";
		
		ArrayList<Object[]> rawData = (ArrayList<Object[]>) entityManager.createQuery(dataQuery, Object[].class)
																			.setParameter(idParam, customerId)
																			.setMaxResults(5)
																			.getResultList();
		
		return rawData;
	}
	
}
