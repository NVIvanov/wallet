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
public class IncomeCategory extends MoneyMovingCategory {

    @NotNull
    @OneToMany
    private Set<Income> incomes;

    public Set<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(Set<Income> incomes) {
        this.incomes = incomes;
    }
}
