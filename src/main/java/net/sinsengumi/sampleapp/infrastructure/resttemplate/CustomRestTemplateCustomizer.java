package net.sinsengumi.sampleapp.infrastructure.resttemplate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {

    @Autowired
    RestTemplateUserAgentInterceptor userAgentInterceptor;
    @Autowired
    RestTemplateTraceInterceptor traceInterceptor;
    @Autowired
    RestTemplateElapsedLoggingInterceptor elapsedLoggingInterceptor;

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(clientHttpRequestFactory());
        restTemplate.setInterceptors(Arrays.asList(userAgentInterceptor, traceInterceptor, elapsedLoggingInterceptor));
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(2000);
        factory.setReadTimeout(10000);
        return factory;
    }
}
