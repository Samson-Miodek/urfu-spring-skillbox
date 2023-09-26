package ru.sadykoff.mod1.javacode2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "application.properties")
public class Config {

    @Bean
    public Pet catBean(){
        return new Cat();
    }

    @Bean
    public Pet dogBean(){
        return new Dog();
    }

    @Bean
    public Person personBean(){
        return new Person(catBean());
    }

}
