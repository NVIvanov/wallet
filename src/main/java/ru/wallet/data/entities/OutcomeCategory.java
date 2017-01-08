package ru.wallet.data.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author nivanov
 *         on 08.01.17.
 */
@Entity
public class OutcomeCategory extends MoneyMovingCategory{

    @NotNull
    @OneToMany
    private Set<Outcome> outcomes;

    public Set<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Set<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
