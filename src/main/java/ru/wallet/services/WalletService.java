package ru.wallet.services;

import ru.wallet.converting.dto.WalletDTO;
import ru.wallet.exceptions.IllegalDTOException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * @author nivanov
 *         on 08.01.17.
 */
public interface WalletService {

    /**
     * Создает кошелёк пользователя
     * @param walletDTO DTO с данными для создания
     * @throws IllegalDTOException walletDTO is invalid
     */
    void createWallet(@NotNull WalletDTO walletDTO);

    /**
     * Получает список кошельков пользователя
     * @param username имя пользователя
     * @return список кошельков пользователя
     */
    @NotNull List<WalletDTO> getWalletsForUser(@NotNull String username);

    /**
     * Получает кошелёк по его идентификатору в базе
     * @param id id кошелька
     * @return {@link Optional} с данными кошелька
     */
    Optional<WalletDTO> getWalletById(@NotNull Long id);

    /**
     * Обновляет данные кошелька по указанному id
     * @param walletDTO DTO с id кошелька и данными для обновления
     * @return DTO с обновлёнными данными
     * @throws IllegalDTOException walletDTO is invalid
     */
    @NotNull WalletDTO updateWallet(@NotNull WalletDTO walletDTO);

    /**
     * Удаляет кошелёк из системы
     * @param id id кошелька
     * @throws IllegalArgumentException wallet with such id does not exist
     */
    void removeWallet(@NotNull Long id);
}
