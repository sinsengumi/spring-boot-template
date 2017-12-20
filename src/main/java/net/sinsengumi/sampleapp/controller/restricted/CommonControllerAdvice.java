package net.sinsengumi.sampleapp.controller.restricted;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackageClasses = CommonControllerAdvice.class)
public class CommonControllerAdvice {

    @ModelAttribute
    public void addSomeObjects(Model model) {
        model.addAttribute("userName", "Restricted");
    }
}
