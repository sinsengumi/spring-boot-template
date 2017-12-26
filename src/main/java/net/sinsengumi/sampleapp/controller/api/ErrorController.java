package net.sinsengumi.sampleapp.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.sinsengumi.sampleapp.controller.GlobalErrorController;
import net.sinsengumi.sampleapp.exception.ApplicationException;
import net.sinsengumi.sampleapp.infrastructure.ErrorResponse;
import net.sinsengumi.sampleapp.util.AppUtil;

@Slf4j
@RestController
public class ErrorController {

    @RequestMapping(value = "/api/error")
    public ErrorResponse error(HttpServletRequest request, HttpServletResponse response) {
        Throwable e = (Throwable) request.getAttribute(GlobalErrorController.ERROR_EXCEPTION);
        if (e == null) {
            e = new ApplicationException("There is no global error.");
        }

        String errorCode = AppUtil.createErrorCode();

        if (response.getStatus() != HttpStatus.NOT_FOUND.value()) {
            log.error(e.getMessage(), e);
        }

        return ErrorResponse.build(errorCode, e);
    }
}