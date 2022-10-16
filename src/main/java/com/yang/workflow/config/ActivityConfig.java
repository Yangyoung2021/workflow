package com.yang.workflow.config;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ActivityConfig {

    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(DataSourceProperties properties) {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setJdbcUsername(properties.getUsername());
        configuration.setJdbcUrl(properties.getUrl());
        configuration.setJdbcDriver(properties.getDriverClassName());
        configuration.setJdbcPassword(properties.getPassword());
        configuration.setDatabaseSchemaUpdate("true");
        return configuration;
    }
}
