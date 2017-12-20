package net.sinsengumi.sampleapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GlobalErrorController implements ErrorController {

    public static final String ERROR_EXCEPTION = GlobalErrorController.class.getName() + ".exception";

    @Value("${server.error.path}")
    private String errorPath;

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @RequestMapping(value = "${server.error.path}")
    public String error(HttpServletRequest request, WebRequest webRequest) {
        Throwable error = errorAttributes.getError(webRequest);
        String requestURI = (String) request.getAttribute("javax.servlet.forward.request_uri");
        Site site = Site.of(requestURI);

        request.setAttribute(ERROR_EXCEPTION, error);

        // TODO: 404 対応

        log.warn("Caught an error. site = {}, requestURI = {}", site, requestURI);

        return "forward:" + site.getBaseUrl() + "/error";
    }
}