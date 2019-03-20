package learn.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value="/")
    public Message index(){
        return new Message("Hello World");
    }
}
