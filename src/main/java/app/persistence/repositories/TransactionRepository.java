package app.persistence.repositories;

import app.persistence.entities.Transaction;
import lib.persistence.repositories.BaseRepository;

//@ApplicationScoped with Java EE / @Repository with Spring
public class TransactionRepository extends BaseRepository<Transaction> {

	protected TransactionRepository() {
		super(Transaction.class);
	}

}
