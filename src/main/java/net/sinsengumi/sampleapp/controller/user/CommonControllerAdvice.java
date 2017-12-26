package net.sinsengumi.sampleapp.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.sinsengumi.sampleapp.util.HttpUtil;


@ControllerAdvice(basePackageClasses = CommonControllerAdvice.class)
public class CommonControllerAdvice {

    @ModelAttribute
    public void addSomeObjects(HttpServletRequest request, Model model) {
        model.addAttribute("userName", "User");

        model.addAttribute("originalRequestUri", HttpUtil.getOriginalRequestUri(request));
        model.addAttribute("now", new Date());
    }
}
