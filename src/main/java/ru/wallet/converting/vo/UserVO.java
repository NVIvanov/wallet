package ru.wallet.converting.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ru.wallet.converting.dto.UserDTO;
import ru.wallet.converting.dto.WalletDTO;

import java.util.Set;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVO {
    @JsonUnwrapped
    private UserDTO userDTO;
    private Set<WalletDTO> wallets;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Set<WalletDTO> getWallets() {
        return wallets;
    }

    public void setWallets(Set<WalletDTO> wallets) {
        this.wallets = wallets;
    }
}
