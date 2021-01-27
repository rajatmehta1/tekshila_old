package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import taxila.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
