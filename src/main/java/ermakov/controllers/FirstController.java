package ermakov.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api") // можно не указывать
public class FirstController {
    @RequestMapping(value = "end", method = RequestMethod.GET)
    public String hello() {
        return "end";
    }

    @GetMapping("/hello")
    public String helloHtml() {
        return "hello";
    }

    @GetMapping("/19") //если параметра name нет - значение null
    public void httpServletRequest(HttpServletRequest request) {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getContextPath());
    }

    @GetMapping("/19+") // если параметра нет - ошибка
    public void requestParam(@RequestParam("name") String name) {
        System.out.println(name);
    }

    @GetMapping("/model") // если параметра нет - ошибка
    public String model(Model model) {
        model.addAttribute("text", "Zhenya");
        return "forModel";
    }
}
