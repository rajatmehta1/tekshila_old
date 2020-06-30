package taxila.controllers.users;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import taxila.dao.CourseRepository;
import taxila.domain.Course;

import java.util.List;

//Shows enrolled courses
@RequestMapping(value = "/t")
@Controller
public class MyCoursesController {

    Logger logger = Logger.getLogger(MyCoursesController.class);

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value = "/{userId}/mycourses")
    public String viewMyCourses(@PathVariable String userId, Model model) {
        logger.info(" userId path variable -------> " + userId);
        return "mycourses";
    }

}
