package net.sinsengumi.sampleapp.infrastructure.resttemplate;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestTemplateElapsedLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return execution.execute(request, body);
        } finally {
            stopWatch.stop();
            log.info("Http request [{} {}] elapsed = {} (ms)", request.getMethod(), request.getURI(), stopWatch.getTotalTimeMillis());
        }
    }

}