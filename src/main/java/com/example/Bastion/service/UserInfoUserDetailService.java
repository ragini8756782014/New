package com.example.Bastion.service;
import com.example.Bastion.configuration.UserInfoUserDetails;
import com.example.Bastion.Repository.crmrepo.UserInfoRepository;
import com.example.Bastion.entitty.crmentity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserInfoUserDetailService  implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =userInfoRepository.findByUserName(username);
        return user.map( UserInfoUserDetails ::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found "+ username));
    }
}
