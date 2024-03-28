package com.project.bookstore.services.response;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for setting up message sources in the application.
 * Implements {@link WebMvcConfigurer} to customize Spring MVC configuration.
 */
@Configuration
public class MessageConfig implements WebMvcConfigurer {

    /**
     * Configures and provides a message source bean for message localization in the application.
     *
     * @return A MessageSource bean configured with {@link ResourceBundleMessageSource}.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }
}
