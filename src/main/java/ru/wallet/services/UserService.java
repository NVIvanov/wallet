package ru.wallet.services;

import ru.wallet.converting.dto.UserDTO;

import java.util.Optional;

/**
 * @author nivanov
 *         on 04.01.17.
 */
public interface UserService {
    void createUser(UserDTO dto);
    Optional<UserDTO> getUser(String username);
    UserDTO updateUser(UserDTO dto);
}
