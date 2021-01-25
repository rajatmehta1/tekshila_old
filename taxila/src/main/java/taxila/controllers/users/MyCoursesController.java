package taxila.controllers.users;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import taxila.controllers.stripe.ChargeRequest;
import taxila.dao.CourseRepository;
import taxila.dao.EnrolCourseRepository;
import taxila.dao.UserRepository;
import taxila.domain.Course;
import taxila.domain.EnrolledCourse;
import taxila.domain.TekUser;

import javax.servlet.http.HttpSession;
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

    UserRepository userRepository;

    @RequestMapping(value = "/{userId}/mycourses")
    public String viewMyCourses(@PathVariable int userId, Model model) {
        logger.info(" userId path variable -------> " + userId);
        List<EnrolledCourse> enrolledCourses = enrolCourseRepository.findEnrolledCourseByUserIdentity("" + userId);
        List<Course> mycourses = this.findCourses(enrolledCourses);
            model.addAttribute("mycourses",mycourses);
            model.addAttribute("userId",userId);
        return "mycourses";
    }

    private List<Course> findCourses(List<EnrolledCourse> enrolledCourses) {
        List<Course> courses = new ArrayList<>();
        for(EnrolledCourse ec : enrolledCourses) {
            Course course = courseRepository.findCourseByCourseIdEquals(Integer.parseInt(ec.getCourseId()));
                   course.setUserIdentity(Integer.parseInt(ec.getUserIdentity()));
                courses.add(course);
        }
        return courses;
    }


    @RequestMapping(value = "/{userId}/mycourses/view/{courseId}", method = {RequestMethod.GET})
    public String viewCourse(@PathVariable(name = "userId") int userId,
                             @PathVariable(name = "courseId") String courseId,
                             Model model, HttpSession httpSession) {
//        EnrolledCourse course = enrolCourseRepository.findEnrolledCourseByUserId()
        return "courses/preparing_for_system_design/design_mint";
    }

    @RequestMapping(value = "/view/{courseId}/{userId}", method = {RequestMethod.GET})
    public String viewCourse(@PathVariable(name = "courseId") String courseId,@PathVariable(name = "userId") String userId, Model model, HttpSession httpSession) {
//        EnrolledCourse course = enrolCourseRepository.findEnrolledCourseByUserId()
        return "courses/preparing_for_system_design/design_mint";
    }


}
