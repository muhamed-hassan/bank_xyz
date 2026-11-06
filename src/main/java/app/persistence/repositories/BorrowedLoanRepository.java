package app.persistence.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import app.persistence.entities.BorrowedLoan;
import lib.persistence.repositories.BaseRepository;

@Repository
public class BorrowedLoanRepository extends BaseRepository<BorrowedLoan> {

	public ArrayList<Object[]> findTheLast5BorrowedLoansThatBelongsToCustomerOf(int customerId) {
		
		String idParam = "idParam";
		
		String dataQuery = "SELECT   borrowedLoan.id, borrowedLoan.amount, borrowedLoan.borrowingDate, borrowedLoan.loan.type " +
				           "FROM     BorrowedLoan borrowedLoan " +
				           "WHERE    borrowedLoan.borrower.id = :" + idParam + " " +
				           "ORDER BY borrowedLoan.id ASC";
		
		ArrayList<Object[]> rawData = (ArrayList<Object[]>) entityManager.createQuery(dataQuery, Object[].class)
																			.setParameter(idParam, customerId)
																			.setMaxResults(5)
																			.getResultList();
		
		return rawData;
	}

}
