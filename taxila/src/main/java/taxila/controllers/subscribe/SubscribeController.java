package taxila.controllers.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import taxila.dao.SubscribeRepository;
import taxila.domain.Subscribe;
import taxila.dtos.SubscriberDto;

/*
 * Subscribe to weekly newsletter
 *
 * @Author Rajat
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/t")
public class SubscribeController {

    @Autowired
    SubscribeRepository subscribeRepository;

//    @Autowired
//    public SubscribeController(SubscribeRepository subscribeRepository) {
//        this.subscribeRepository = subscribeRepository;
//    }

    //Subscribe to weekly news letter and redirect to home
    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public String subscribeNewsLetter(Model model, SubscriberDto subscribeDto) {
        Subscribe s = new Subscribe();
            s.setEmail(subscribeDto.getEmail());
        subscribeRepository.save(s);

        model.addAttribute("subscribed","YES");
        model.addAttribute("subscribeDto",new SubscriberDto());

        return "home";
    }

}
