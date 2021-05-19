package com.softserve.travelagency.security;

import com.softserve.travelagency.dao.UserDAO;
import com.softserve.travelagency.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



@Service("userDetailsServiceImpl")
@AllArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return SecurityUser.fromUser(user);
    }
}
