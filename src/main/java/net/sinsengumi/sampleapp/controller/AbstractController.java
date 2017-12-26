package net.sinsengumi.sampleapp.controller;

public abstract class AbstractController {

    public String redirect(String to) {
        return "redirect:" + to;
    }

    public String forward(String to) {
        return "forward:" + to;
    }
}
