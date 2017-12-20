package net.sinsengumi.sampleapp.controller.restricted;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sinsengumi.sampleapp.exception.ApplicationException;

@Controller
public class HelloController {

    @GetMapping("/restricted/hello")
    public String hello(@RequestParam(required = false) String name, Model model) {
        if ("sinsengumi".equals(name)) {
            throw new ApplicationException("sample error. name = " + name);
        }

        model.addAttribute("name", name);

        return "restricted/hello";
    }
}
