package ru.wallet.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.wallet.data.entities.SystemUser;

import java.util.Optional;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Repository
public interface UserRepository extends CrudRepository<SystemUser, Long> {
    Optional<SystemUser> findByUsername(String username);
}
