package ru.beganov.tacos.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.beganov.tacos.db.UserRepository;

public interface UserDetailsService {

    UserDetails loadUserBynUserName(String userName) throws UsernameNotFoundException;

}
