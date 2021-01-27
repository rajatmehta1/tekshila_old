package taxila.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taxila.dtos.User;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String viewLogin(@RequestParam(name="cid", required = false) String cid, Model model) {

        User u = new User();
        //course id
        if(null != cid && !"".equalsIgnoreCase(cid)) {
//            model.addAttribute("redirect_url","forward:/t/courses/view/" + cid);
            u.setRedirect_url("/t/courses/view/" + cid);
        }

        model.addAttribute("user", u);
        return "login";
    }

}
