package cz.homehub.service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:service.properties")
public class ServiceConfig {

    @Value("${userNotFound.id}")
    private String userNotFoundIdMessage;

    @Value("${userNotFound.username}")
    private String userNotFoundUsernameMessage;

    @Value("${operationNotSupported}")
    private String operationNotSupportedMessage;

    @Bean
    public static PropertySourcesPlaceholderConfigurer getConfiguration() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getUserNotFoundIdMessage() {
        return userNotFoundIdMessage;
    }

    public String getUserNotFoundUsernameMessage() {
        return userNotFoundUsernameMessage;
    }

    public String getOperationNotSupportedMessage() {
        return operationNotSupportedMessage;
    }
}
