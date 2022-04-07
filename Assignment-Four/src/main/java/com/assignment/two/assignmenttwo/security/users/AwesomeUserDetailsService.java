package com.assignment.two.assignmenttwo.security.users;

import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.security.users.AwesomeUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class AwesomeUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public AwesomeUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(email);
        var userDetails = new AwesomeUserDetails(user);
        return userDetails;
    }

}
