package ru.sadykoff.mod1.annotationconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sadykoff.mod1.Person;
import ru.sadykoff.mod1.Pet;

public class AnnotationMod1Application {
    public static void main(String[] args) {
        var applicationContext = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
        var cat = applicationContext.getBean("superCat", Pet.class);
        cat.say();

        var person = applicationContext.getBean("superPerson", Person.class);
        person.callPet();

        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
