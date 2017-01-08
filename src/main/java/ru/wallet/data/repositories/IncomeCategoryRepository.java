package ru.wallet.data.repositories;

import org.springframework.stereotype.Repository;
import ru.wallet.data.entities.IncomeCategory;

/**
 * @author nivanov
 *         on 08.01.17.
 */
@Repository
public interface IncomeCategoryRepository extends CategoryRepository<IncomeCategory> {
}
