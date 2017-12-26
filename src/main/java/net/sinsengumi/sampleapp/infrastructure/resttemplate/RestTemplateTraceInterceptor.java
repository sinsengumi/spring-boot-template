package net.sinsengumi.sampleapp.infrastructure.resttemplate;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestTemplateTraceInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        if (log.isTraceEnabled()) {
            log.trace("=========================== REQUEST BEGIN ===========================");
            log.trace("URI         : {}", request.getURI());
            log.trace("Method      : {}", request.getMethod());
            log.trace("Headers     : {}", request.getHeaders());
            log.trace("Request body: {}", new String(body, "UTF-8"));
            log.trace("=========================== REQUEST END   ===========================");
        }
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        if (log.isTraceEnabled()) {
            log.trace("=========================== RESPONSE BEGIN ===========================");
            log.trace("Status code  : {}", response.getStatusCode());
            log.trace("Status text  : {}", response.getStatusText());
            log.trace("Headers      : {}", response.getHeaders());
            log.trace("=========================== RESPONSE END   ===========================");
        }
    }
}