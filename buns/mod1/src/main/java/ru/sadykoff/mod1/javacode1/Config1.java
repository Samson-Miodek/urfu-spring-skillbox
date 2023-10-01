package ru.sadykoff.mod1.javacode1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.sadykoff.mod1")
@PropertySource(value = "application.properties")
public class Config1 {
}
