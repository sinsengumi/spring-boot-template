package net.sinsengumi.sampleapp.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
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

    @RequestMapping("/error")
    public String error(HttpServletRequest request, Model model) {
        Throwable e = (Throwable) request.getAttribute(GlobalErrorController.ERROR_EXCEPTION);
        if (e == null) {
            e = new ApplicationException("There is no global error.");
        }

        String errorCode = AppUtil.createErrorCode();

        log.error(e.getMessage(), e);

        model.addAttribute("errorCode", errorCode);
        model.addAttribute("stackTrace", ExceptionUtils.getStackTrace(e));

        return "user/error";
    }
}