package taxila;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import taxila.dao.RoleRepository;
import taxila.domain.Role;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }



    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            Role adminRole = roleRepository.findByRole("INSTRUCTOR");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                     newAdminRole.setRole("INSTRUCTOR");
                roleRepository.save(newAdminRole);
            }

            Role userRole = roleRepository.findByRole("STUDENT");
            if (userRole == null) {
                Role newUserRole = new Role();
                     newUserRole.setRole("STUDENT");
                roleRepository.save(newUserRole);
            }
        };

    }



}
