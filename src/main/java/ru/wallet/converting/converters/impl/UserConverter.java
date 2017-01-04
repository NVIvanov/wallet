package ru.wallet.converting.converters.impl;

import org.springframework.stereotype.Component;
import ru.wallet.converting.converters.Converter;
import ru.wallet.converting.dto.UserDTO;
import ru.wallet.data.entities.SystemUser;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Component
public class UserConverter implements Converter<SystemUser, UserDTO> {

    @Override
    public UserDTO convert(SystemUser source) {
        UserDTO dto = new UserDTO();
        dto.setUsername(source.getUsername());
        return dto;
    }

    @Override
    public SystemUser convertBack(UserDTO source) {
        SystemUser systemUser = new SystemUser();
        populate(systemUser, source);
        return systemUser;
    }

    @Override
    public void populate(SystemUser existingTarget, UserDTO source) {
        if (source.getPassword() != null)
            existingTarget.setPassword(source.getPassword());
        if (source.getUsername() != null)
            existingTarget.setUsername(source.getUsername());
    }
}
