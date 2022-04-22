package com.sentinels.manage.service;

import com.sentinels.manage.domain.Users.Users;
import com.sentinels.manage.domain.Users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users users = usersRepository.findByUserid(userId);

        if(users == null) throw new UsernameNotFoundException("Not Found account.");
        return users;
    }
}
