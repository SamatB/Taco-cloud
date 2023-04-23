package ru.beganov.tacos.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.beganov.tacos.db.UserRepository;
import ru.beganov.tacos.entity.User;
import ru.beganov.tacos.service.UserDetailsService;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserBynUserName(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException(format("User with name - %s, not found", userName));
        }
    }
}
