package ru.wallet.converting.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ru.wallet.converting.dto.CategoryDTO;
import ru.wallet.data.entities.MoneyMoving;

import java.util.Set;

/**
 * @author nivanov
 *         on 08.01.17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryVO {

    @JsonUnwrapped
    private CategoryDTO category;
    private Set<MoneyMoving> moneyMovingSet;

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Set<MoneyMoving> getMoneyMovingSet() {
        return moneyMovingSet;
    }

    public void setMoneyMovingSet(Set<MoneyMoving> moneyMovingSet) {
        this.moneyMovingSet = moneyMovingSet;
    }
}
