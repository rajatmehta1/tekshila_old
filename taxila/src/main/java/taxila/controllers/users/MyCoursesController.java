package taxila.controllers.users;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import taxila.dao.CourseRepository;
import taxila.dao.EnrolCourseRepository;
import taxila.domain.Course;
import taxila.domain.EnrolledCourse;

import java.util.ArrayList;
import java.util.List;

//Shows enrolled courses
@RequestMapping(value = "/t")
@Controller
public class MyCoursesController {

    Logger logger = Logger.getLogger(MyCoursesController.class);

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EnrolCourseRepository enrolCourseRepository;

    @RequestMapping(value = "/{userId}/mycourses")
    public String viewMyCourses(@PathVariable String userId, Model model) {
        logger.info(" userId path variable -------> " + userId);
        List<EnrolledCourse> enrolledCourses = enrolCourseRepository.findEnrolledCourseByUserId(userId);
        List<Course> mycourses = this.findCourses(enrolledCourses);
            model.addAttribute("mycourses",mycourses);
        return "mycourses";
    }

    private List<Course> findCourses(List<EnrolledCourse> enrolledCourses) {
        List<Course> courses = new ArrayList<>();
        for(EnrolledCourse ec : enrolledCourses) {
            courses.add(courseRepository.findCourseByCourseIdEquals(Integer.parseInt(ec.getCourseId())));
        }
        return courses;
    }

}
