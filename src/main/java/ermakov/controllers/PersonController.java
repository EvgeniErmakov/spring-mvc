package ermakov.controllers;

import ermakov.model.Person;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/people")
public class PersonController {
    @GetMapping
    public String m(Model model) {
        return null;
    }

    @GetMapping("/{id}")
    public String m(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        return "form";
    }

    @GetMapping("form")
    public String form() {
        return "form";
    }

    //Маппит сам параметры приходящие из URI "?name=Zhenya" в объект Person
    //BindingResult должен идти после объекта который он validate
    @GetMapping("person")
    public String person(@ModelAttribute("person") @Valid Person person, BindingResult error) {
        if (error.hasErrors()) {
            System.out.println();
        }
        return "form";
    }

    @GetMapping("/model") // эквивалентно методу person
    public String model(@RequestParam("name") String name, Model model) {
        Person person = new Person();
        person.setName(name + " add smth");
        model.addAttribute("person", person);
        return "form";
    }

    @GetMapping("/{model}") // эквивалентно методу person
    public String model(@PathVariable("model") String model) {
        System.out.println("!!!!!!!!!");
        return "form";
    }

    @GetMapping("/*/*") // можно надобавлять звёздочек и писать что угодно
    public void add() {
        System.out.println("try!");
    }

    //в каждую модель каждого эндпоинта запихивает атрибут с ключом hello и значением"ModelAttribute = Hello"
    @ModelAttribute("Hello")
    public String helloModelAtr() {
        return "ModelAttribute = Hello";
    }

    @RestController
    @RequestMapping("/home")
    public class IndexController {

        @RequestMapping(value = {
            "",
            "/page",
            "page*",
            "view/*,**/msg"
        })
        String indexMultipleMapping() {
            return "Hello from index multiple mapping.";
        }
    }

    @RequestMapping(path = "/topic", headers = "content-type=text/plain")
    void get() {
        System.out.println("Hello from get");
    }

    @RequestMapping(path = "/ggg")
    void get2() {
        System.out.println("Hello from get2");
    }

    @RequestMapping(value = "/head", headers = {
        "content-type=text/plain", "content-type=text/html"})
    String post() {
        return "Mapping applied along with headers";
    }

    @RequestMapping(value = "/f", params = {
        "personId=10", "name=Zhenya"})
    void getParams(@RequestParam("personId") String id) {
        System.out.println("Fetched parameter using params attribute = " + id);
    }

    @RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
    void getDynamicUriValueRegex(@PathVariable("name") String name) {
        System.out.println("Name is " + name);
        System.out.println("Dynamic URI parameter fetched using regex");
    }

    @RequestMapping (value= "testParams" , params={ "param1=value1" , "param2" , "!param3" })
    public void testParams() {
        System.out.println("testParam");
    }
}
