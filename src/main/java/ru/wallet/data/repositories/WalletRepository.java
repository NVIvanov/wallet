package ru.wallet.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.wallet.data.entities.Wallet;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {
}
