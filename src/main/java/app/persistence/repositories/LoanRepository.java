package app.persistence.repositories;

import org.springframework.stereotype.Repository;

import app.persistence.entities.Loan;
import lib.persistence.repositories.BaseRepository;

@Repository
public class LoanRepository extends BaseRepository<Loan> {

}
