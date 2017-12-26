package net.sinsengumi.sampleapp.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public final class HttpUtil {

    public static String getOriginalRequestUri(HttpServletRequest request) {
        String requestUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        if (StringUtils.isNotEmpty(requestUri)) {
            return requestUri;
        }
        return request.getRequestURI();
    }
}
