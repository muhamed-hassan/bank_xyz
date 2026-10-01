package app.persistence.repositories;

import app.persistence.entities.IssuedBankCard;
import lib.persistence.repositories.BaseRepository;

//@ApplicationScoped with Java EE / @Repository with Spring
public class IssuedBankCardRepository extends BaseRepository<IssuedBankCard> {

	protected IssuedBankCardRepository() {
		super(IssuedBankCard.class);
	}

}
