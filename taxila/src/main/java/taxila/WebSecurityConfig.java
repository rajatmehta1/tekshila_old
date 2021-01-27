package taxila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import taxila.services.CustomizeAuthenticationSuccessHandler;
import taxila.services.UserService;

/*
 * This class will be used by the filter for authentication
 */
@Configuration //enable this annotation to specify this is a configuration class i.e. loaded only once at startup
@EnableWebSecurity //Use this class to enable
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/t/home").permitAll()
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler)
                .loginPage("/login").failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout();
    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {  // (2)
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll() // (3), "/t/home","/t/courses/*"
//                .antMatchers("/t/home").permitAll()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated() // (4)
//                .and()
//                .formLogin().successHandler(customizeAuthenticationSuccessHandler) // (5)
//                .loginPage("/login").successForwardUrl("/t/home") // (5)
//                .permitAll()
//                .and()
//                .logout() // (6)
//                .permitAll()
//                .and()
//                .httpBasic(); // (7)
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //This specifies that we want to use
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userService);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/assets/**","/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
