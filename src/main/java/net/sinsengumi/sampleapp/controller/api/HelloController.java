package net.sinsengumi.sampleapp.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sinsengumi.sampleapp.exception.ApplicationException;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(@RequestParam(required = false) String name) {
        if ("sinsengumi".equals(name)) {
            throw new ApplicationException("sample error. name = " + name);
        }

        return "Hello, " + name;
    }
}
