package com.office.ctifier.config;

import com.office.ctifier.properties.OpenOfficeConnectionProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dizzy
 */
@Configuration
@EnableConfigurationProperties({
        OpenOfficeConnectionProperties.class,
})
public class CtifierConfig {
}
