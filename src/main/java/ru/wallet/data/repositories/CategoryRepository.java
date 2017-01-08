package ru.wallet.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.wallet.data.entities.MoneyMovingCategory;

import java.util.Optional;

/**
 * @author nivanov
 *         on 08.01.17.
 */
@NoRepositoryBean
public interface CategoryRepository<T extends MoneyMovingCategory> extends CrudRepository<T, Long> {
    Optional<T> findByTitle(String title);
}
