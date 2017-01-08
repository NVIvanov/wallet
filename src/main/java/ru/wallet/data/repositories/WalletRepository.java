package ru.wallet.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.wallet.data.entities.Wallet;

import java.util.List;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {
    List<Wallet> findByUserUsername(String username);
}
