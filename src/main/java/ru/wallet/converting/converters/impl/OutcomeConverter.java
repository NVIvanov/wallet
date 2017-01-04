package ru.wallet.converting.converters.impl;

import org.springframework.stereotype.Component;
import ru.wallet.converting.dto.MoneyMovingDTO;
import ru.wallet.data.entities.Outcome;

/**
 * @author nivanov
 *         on 04.01.17.
 */

@Component
public class OutcomeConverter extends MoneyMovingsConverter<Outcome> {

    @Override
    public Outcome convertBack(MoneyMovingDTO source) {
        Outcome outcome = new Outcome();
        populate(outcome, source);
        return outcome;
    }
}
