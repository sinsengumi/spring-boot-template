package net.sinsengumi.sampleapp.controller.restricted;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.sinsengumi.sampleapp.controller.GlobalErrorController;
import net.sinsengumi.sampleapp.exception.ApplicationException;
import net.sinsengumi.sampleapp.util.AppUtil;

@Slf4j
@Controller
public class ErrorController {

    @RequestMapping("/restricted/error")
    public String error(HttpServletRequest request, HttpServletResponse response, Model model) {
        Throwable e = (Throwable) request.getAttribute(GlobalErrorController.ERROR_EXCEPTION);
        if (e == null) {
            e = new ApplicationException("There is no global error.");
        }

        String errorCode = AppUtil.createErrorCode();

        if (response.getStatus() != HttpStatus.NOT_FOUND.value()) {
            log.error(e.getMessage(), e);
        }

        model.addAttribute("errorCode", errorCode);
        model.addAttribute("stackTrace", ExceptionUtils.getStackTrace(e));

        return "restricted/error";
    }
}