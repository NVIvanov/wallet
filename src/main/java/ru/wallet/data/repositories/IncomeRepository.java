package ru.wallet.data.repositories;

import org.springframework.stereotype.Repository;
import ru.wallet.data.entities.Income;

/**
 * @author nivanov
 *         on 04.01.17.
 */

@Repository
public interface IncomeRepository extends MoneyMovingRepository<Income> {
}
