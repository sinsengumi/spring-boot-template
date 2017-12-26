package net.sinsengumi.sampleapp.controller.user;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sinsengumi.sampleapp.controller.AbstractController;

public abstract class AbstractUserController extends AbstractController {

    protected void addFlashAttribute(String message, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("flashMessage", message);
    }
}
