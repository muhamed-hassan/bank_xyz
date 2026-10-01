package app.persistence.repositories;

import app.persistence.entities.BankTransaction;
import lib.persistence.repositories.BaseRepository;

//@ApplicationScoped with Java EE / @Repository with Spring
public class BankTransactionRepository extends BaseRepository<BankTransaction> {

	protected BankTransactionRepository() {
		super(BankTransaction.class);
	}

}
