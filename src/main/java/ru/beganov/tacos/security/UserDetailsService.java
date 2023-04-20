package ru.beganov.tacos.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

    UserDetails loadUserBynUserName(String userName) throws UsernameNotFoundException{

    }

}
