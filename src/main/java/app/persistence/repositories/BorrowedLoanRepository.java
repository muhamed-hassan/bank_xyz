package app.persistence.repositories;

import app.persistence.entities.BorrowedLoan;
import lib.persistence.repositories.BaseRepository;

//@ApplicationScoped with Java EE / @Repository with Spring
public class BorrowedLoanRepository extends BaseRepository<BorrowedLoan> {

	protected BorrowedLoanRepository() {
		super(BorrowedLoan.class);
	}

}
