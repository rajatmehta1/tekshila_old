package taxila.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import taxila.domain.Course;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest //This will spin the local mongo instance
@TestPropertySource(locations="classpath:application.yml")
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;


    @Test
    public void testAddCourse() {
        Course c = new Course();
            c.setCreateDate(new Date());
            c.setDescription("Microservices Interview");
            c.setName("Microservices Interview");
            c.setUserIdentity(1);//some user id
            c.setCategory("INTERVIEWS");
            c.setRating("5");
            c.setCreatedBy(1);

        Course newCourse = courseRepository.save(c);
            System.out.println("course id generated ==> " + newCourse.getCourseId() );
        Assert.assertNotNull(newCourse);
    }


    @Test
    public void testFetchCourse() {
        List<Course> courses = courseRepository.findAll();
            courses.forEach(System.out::println);
            Assert.assertEquals(6, courses.size());
    }




}
