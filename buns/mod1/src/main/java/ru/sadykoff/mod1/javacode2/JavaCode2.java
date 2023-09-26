package ru.sadykoff.mod1.javacode2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sadykoff.mod1.javacode2.Person;
import ru.sadykoff.mod1.javacode2.Config;

public class JavaCode2 {
    public static void main(String[] args) {
        var config = new AnnotationConfigApplicationContext(Config.class);

        var person = config.getBean("personBean", Person.class);
        person.callPet();

        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
