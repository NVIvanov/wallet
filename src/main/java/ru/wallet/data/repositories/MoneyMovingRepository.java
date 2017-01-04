package ru.wallet.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.wallet.data.entities.MoneyMoving;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@NoRepositoryBean
public interface MoneyMovingRepository<T extends MoneyMoving> extends CrudRepository<T, Long> {
}
