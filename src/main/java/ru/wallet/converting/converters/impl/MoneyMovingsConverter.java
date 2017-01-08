package ru.wallet.converting.converters.impl;

import ru.wallet.converting.converters.Converter;
import ru.wallet.converting.dto.MoneyMovingDTO;
import ru.wallet.data.entities.MoneyMoving;

/**
 * @author nivanov
 *         on 04.01.17.
 */
public abstract class MoneyMovingsConverter<T extends MoneyMoving> implements Converter<T, MoneyMovingDTO> {

    @Override
    public MoneyMovingDTO convert(MoneyMoving source) {
        MoneyMovingDTO dto = new MoneyMovingDTO();
        dto.setValue(source.getValue());
        dto.setId(source.getId());
        dto.setEventTime(source.getEventTime());
        dto.setUserComment(source.getUserComment());
        dto.setWalletId(source.getWallet().getId());
        dto.setCategory(source.getCategory().getTitle());
        return dto;
    }

    @Override
    public void populate(MoneyMoving existingTarget, MoneyMovingDTO source) {
        if (source.getValue() != null)
            existingTarget.setValue(source.getValue());
        if (source.getEventTime() != null)
            existingTarget.setEventTime(source.getEventTime());
        if (source.getUserComment() != null)
            existingTarget.setUserComment(source.getUserComment());
    }
}
