package de.friedrichs.malteser.data.service;


import java.nio.charset.Charset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AFR
 */
@Service
@ConfigurationProperties(prefix = "crm.basicauthentication")
public class RestService {
    
    private static final Logger LOG = LoggerFactory.getLogger(RestService.class);
    
    private String user;
    private String password;
    
    @Bean("CRMRestTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        LOG.info("Erzeuge CRMRestTemplate mit User {}", user);
        return builder
                .basicAuthentication(user, password)
                .defaultHeader("Accept", "application/json")
                .additionalMessageConverters(new StringHttpMessageConverter(Charset.forName("UTF-8")))
                .build();
    }
    
    @Bean("MoodleRestTemplate")
    public RestTemplate moodleRestTemplate(RestTemplateBuilder builder) {
        return builder
                .defaultHeader("Accept", "application/json")
                .additionalMessageConverters(new StringHttpMessageConverter(Charset.forName("UTF-8")))
                .build();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
