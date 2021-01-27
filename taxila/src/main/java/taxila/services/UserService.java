package taxila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import taxila.dao.UserRepository;
import taxila.domain.TekUser;

import java.util.Arrays;
import java.util.List;

/*
 * This class contains the methods for pulling information about the users
 *
 * This gets passed to the authentication service
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TekUser tekshilaUsr = userRepository.findByEmail(username);

        if(null == tekshilaUsr) {
            throw new UsernameNotFoundException("User not found");
        }
        //put some default
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("STUDENT"));
        return new User(tekshilaUsr.getUsername(), tekshilaUsr.getPassword(), authorities);

    }

}
