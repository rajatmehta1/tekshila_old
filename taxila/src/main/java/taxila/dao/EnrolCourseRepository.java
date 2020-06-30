package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import taxila.domain.EnrolledCourse;

public interface EnrolCourseRepository extends MongoRepository<EnrolledCourse,String> {

}
