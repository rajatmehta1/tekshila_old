package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import taxila.domain.Course;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

    public Course findCourseByCourseIdEquals(int courseId);

}
