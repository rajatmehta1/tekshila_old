package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import taxila.domain.Course;
import taxila.domain.EnrolledCourse;

import java.util.List;

@Repository
public interface EnrolCourseRepository extends MongoRepository<EnrolledCourse,String> {
    public List<EnrolledCourse> findEnrolledCourseByUserIdentity(String userIdentity);
    public List<EnrolledCourse> findEnrolledCourseByUserIdentityAndCourseId(String userIdentity, String courseId);
}
