package net.sinsengumi.sampleapp.infrastructure.resttemplate;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateUserAgentInterceptor implements ClientHttpRequestInterceptor {

    @Value("${spring.application.name}")
    String applicationName;
    @Value("${build.version}")
    String buildVersion;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add(HttpHeaders.USER_AGENT, applicationName + "/" + buildVersion);
        return execution.execute(request, body);
    }
}