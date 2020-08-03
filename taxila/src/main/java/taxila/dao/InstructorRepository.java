package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import taxila.domain.Instructor;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {

}
