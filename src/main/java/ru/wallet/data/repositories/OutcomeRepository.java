package ru.wallet.data.repositories;

import org.springframework.stereotype.Repository;
import ru.wallet.data.entities.Outcome;

/**
 * @author nivanov
 *         on 04.01.17.
 */

@Repository
public interface OutcomeRepository extends MoneyMovingRepository<Outcome>{
}
