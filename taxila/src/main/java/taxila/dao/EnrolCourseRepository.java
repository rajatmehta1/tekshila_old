package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import taxila.domain.Course;
import taxila.domain.EnrolledCourse;

import java.util.List;

public interface EnrolCourseRepository extends MongoRepository<EnrolledCourse,String> {
    public List<EnrolledCourse> findEnrolledCourseByUserId(String userId);
}
