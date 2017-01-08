package ru.wallet.converting.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

/**
 * @author nivanov
 *         on 04.01.17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @NotNull
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
