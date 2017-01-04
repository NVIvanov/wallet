package ru.wallet.converting.converters.impl;

import org.springframework.stereotype.Component;
import ru.wallet.converting.converters.Converter;
import ru.wallet.converting.dto.WalletDTO;
import ru.wallet.data.entities.Wallet;

import java.util.Currency;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Component
public class WalletConverter implements Converter<Wallet, WalletDTO> {

    @Override
    public WalletDTO convert(Wallet source) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setUsername(source.getUser().getUsername());
        walletDTO.setCurrency(source.getCurrency().getCurrencyCode());
        walletDTO.setTitle(source.getTitle());
        walletDTO.setId(source.getId());
        walletDTO.setBalance(source.getBalance());
        return null;
    }

    @Override
    public Wallet convertBack(WalletDTO source) {
        Wallet wallet = new Wallet();
        populate(wallet, source);
        return wallet;
    }

    @Override
    public void populate(Wallet existingTarget, WalletDTO source) {
        if (source.getTitle() != null)
            existingTarget.setTitle(source.getTitle());
        if (source.getCurrency() != null)
            existingTarget.setCurrency(Currency.getInstance(source.getCurrency()));
        if (source.getBalance() != null)
            existingTarget.setBalance(source.getBalance());
        if (source.getType() != null)
            existingTarget.setType(Wallet.Type.valueOf(source.getType()));
    }
}
