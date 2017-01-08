package ru.wallet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.wallet.converting.converters.Converter;
import ru.wallet.converting.dto.WalletDTO;
import ru.wallet.data.entities.SystemUser;
import ru.wallet.data.entities.Wallet;
import ru.wallet.data.repositories.UserRepository;
import ru.wallet.data.repositories.WalletRepository;
import ru.wallet.exceptions.IllegalDTOException;
import ru.wallet.services.WalletService;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author nivanov
 *         on 08.01.17.
 */
@Service
public class WalletServiceImpl implements WalletService {
    private final Converter<Wallet, WalletDTO> converter;
    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    @Autowired
    public WalletServiceImpl(Converter<Wallet, WalletDTO> converter,
                             WalletRepository walletRepository, UserRepository userRepository) {
        this.converter = converter;
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createWallet(@NotNull WalletDTO walletDTO) {
        Wallet wallet = converter.convertBack(walletDTO);
        wallet.setMoneyMovingSet(new HashSet<>());
        Optional<SystemUser> systemUserOptional = userRepository.findByUsername(walletDTO.getUsername());
        wallet.setUser(systemUserOptional.orElseThrow(() -> new IllegalDTOException("WALLET", "username")));
        walletRepository.save(wallet);
    }

    @Override
    public List<WalletDTO> getWalletsForUser(@NotNull String username) {
        return walletRepository.findByUserUsername(username)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WalletDTO> getWalletById(@NotNull Long id) {
        Wallet wallet = walletRepository.findOne(id);
        if (wallet == null)
            return Optional.empty();
        else
            return Optional.of(converter.convert(wallet));
    }

    @Override
    public WalletDTO updateWallet(@NotNull WalletDTO walletDTO) {
        if (walletDTO.getId() == null)
            throw new IllegalDTOException("WALLET", "id");
        Wallet wallet = walletRepository.findOne(walletDTO.getId());
        if (wallet == null)
            throw new IllegalDTOException("WALLET", "id");
        converter.populate(wallet, walletDTO);
        walletRepository.save(wallet);
        return converter.convert(wallet);
    }

    @Override
    public void removeWallet(@NotNull Long id) {
        Wallet wallet = walletRepository.findOne(id);
        if (wallet == null)
            throw new IllegalArgumentException();
        walletRepository.delete(wallet);
    }
}
