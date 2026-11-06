package app.persistence.repositories;

import org.springframework.stereotype.Repository;

import app.persistence.entities.BankTransaction;
import lib.persistence.repositories.BaseRepository;

@Repository
public class BankTransactionRepository extends BaseRepository<BankTransaction> {

}
