package taxila;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * This class will be used by the filter for authentication
 */
@Configuration //enable this annotation to specify this is a configuration class i.e. loaded only once at startup
@EnableWebSecurity //Use this class to enable
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {  // (2)
        http
                .authorizeRequests()
                .antMatchers("/", "/t/home","/t/courses/*").permitAll() // (3)
                .anyRequest().authenticated() // (4)
                .and()
                .formLogin() // (5)
                .loginPage("/t/user/login") // (5)
                .permitAll()
                .and()
                .logout() // (6)
                .permitAll()
                .and()
                .httpBasic(); // (7)
    }

}
