package ermakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/helloHtml")
    public String helloHtml() {
        return "helloHtml";
    }
}
