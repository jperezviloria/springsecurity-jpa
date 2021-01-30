package com.springsecurityjpa.demo.service.implementation;

import com.springsecurityjpa.demo.MyUserDetails;
import com.springsecurityjpa.demo.model.User;
import com.springsecurityjpa.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailServiceImplementation implements UserDetailsService{

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user =  userRepository.findUserByUsername(username);

       user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

       return user.map(MyUserDetails::new).get();
    }
}
