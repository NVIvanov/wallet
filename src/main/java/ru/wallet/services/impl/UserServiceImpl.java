package ru.wallet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import ru.wallet.converting.converters.Converter;
import ru.wallet.converting.dto.UserDTO;
import ru.wallet.data.entities.SystemUser;
import ru.wallet.data.repositories.UserRepository;
import ru.wallet.services.UserService;

import java.util.Optional;

/**
 * @author nivanov
 *         on 04.01.17.
 */

@Service
public class UserServiceImpl implements UserService {
    private final static String USER_EXISTS = "User already exists";
    private final UserRepository userRepository;
    private final Converter<SystemUser, UserDTO> converter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Converter<SystemUser, UserDTO> converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public void createUser(UserDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent())
            throw new IllegalArgumentException(USER_EXISTS);
        userRepository.save(converter.convertBack(dto));
    }

    @Override
    public Optional<UserDTO> getUser(String username) {
        Optional<SystemUser> systemUserOptional = userRepository.findByUsername(username);
        if (systemUserOptional.isPresent())
            return Optional.of(converter.convert(systemUserOptional.get()));
        else
            return Optional.empty();
    }

    @Override
    public UserDTO updateUser(UserDTO dto) {
        Optional<SystemUser> systemUserOptional = userRepository.findByUsername(dto.getUsername());
        if (systemUserOptional.isPresent()){
            SystemUser user = systemUserOptional.get();
            converter.populate(user, dto);
            userRepository.save(user);
            return converter.convert(user);
        }else
            throw new IllegalStateException(USER_EXISTS);
    }

    @Override
    public String currentUsername() {
        return ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }
}
