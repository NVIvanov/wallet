package ru.wallet.converting.converters.impl;

import org.springframework.stereotype.Component;
import ru.wallet.converting.dto.MoneyMovingDTO;
import ru.wallet.data.entities.Income;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Component
public class IncomeConverter extends MoneyMovingsConverter<Income> {

    @Override
    public Income convertBack(MoneyMovingDTO source) {
        Income income = new Income();
        populate(income, source);
        return income;
    }
}
