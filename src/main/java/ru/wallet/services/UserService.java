package ru.wallet.services;

import ru.wallet.converting.dto.UserDTO;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author nivanov
 *         on 04.01.17.
 */
public interface UserService {
    /**
     * Создает пользователя
     * @param dto DTO с данными пользователя
     */
    void createUser(@NotNull UserDTO dto);

    /**
     * Получает пользователя по его имени пользователя
     * @param username имя пользователя
     * @return {@link Optional} с данными пользователя
     */
    Optional<UserDTO> getUser(@NotNull String username);

    /**
     * Обновляет данные пользователя
     * @param dto DTO с username пользователя и данными для обновления
     * @return DTO с обновленными данными
     */
    @NotNull UserDTO updateUser(@NotNull UserDTO dto);

    /**
     * Получает имя текущего пользователя в сессии
     * @return имя пользователя
     */
    @NotNull String currentUsername();
}
