
package com.ouhk.webforum.service;

import com.ouhk.webforum.dao.ForumUserRepository;
import com.ouhk.webforum.model.ForumUser;
import com.ouhk.webforum.model.UserRole;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ForumUserService implements UserDetailsService {

    @Resource
    ForumUserRepository forumUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        ForumUser forumUser = forumUserRepo.findOne(username);
        if (forumUser == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : forumUser.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(forumUser.getUsername(), forumUser.getPassword(), authorities);
    }
}

