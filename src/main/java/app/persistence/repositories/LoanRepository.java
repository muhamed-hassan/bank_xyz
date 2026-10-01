package app.persistence.repositories;

import app.persistence.entities.Loan;
import lib.persistence.repositories.BaseRepository;

//@ApplicationScoped with Java EE / @Repository with Spring
public class LoanRepository extends BaseRepository<Loan> {

	protected LoanRepository() {
		super(Loan.class);
	}

}
