package com.example.blog.services;
import com.example.blog.models.User;
import com.example.blog.models.UserWithRoles;
import com.example.blog.repos.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
    public class UserDetailsLoader implements UserDetailsService {
        private final UserRepository usersDao;

        public UserDetailsLoader(UserRepository usersDao) {
            this.usersDao = usersDao;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = usersDao.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("No user found for " + username);
            }

            return new UserWithRoles(user);
        }
    }

