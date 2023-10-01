package ru.sadykoff.mod1.javacode1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sadykoff.mod1.Person;

public class JavaCode1 {
    public static void main(String[] args) {
        var config = new AnnotationConfigApplicationContext(Config1.class);

        var person = config.getBean("superPerson", Person.class);
        person.callPet();

        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
