package ru.wallet.converting.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ru.wallet.converting.dto.MoneyMovingDTO;
import ru.wallet.converting.dto.WalletDTO;

import java.util.Set;

/**
 * @author nivanov
 *         on 04.01.17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletVO {

    @JsonUnwrapped
    private WalletDTO dto;
    private Set<MoneyMovingDTO> moneyMovingDTOS;

    public WalletDTO getDto() {
        return dto;
    }

    public void setDto(WalletDTO dto) {
        this.dto = dto;
    }

    public Set<MoneyMovingDTO> getMoneyMovingDTOS() {
        return moneyMovingDTOS;
    }

    public void setMoneyMovingDTOS(Set<MoneyMovingDTO> moneyMovingDTOS) {
        this.moneyMovingDTOS = moneyMovingDTOS;
    }
}
