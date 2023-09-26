package ru.sadykoff.mod1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMod1Application {
    public static void main(String[] args) {
        var applicationContext = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
        var cat = applicationContext.getBean("superCat",Pet.class);
        cat.say();

        var person = applicationContext.getBean("superPerson",Person.class);
        person.callPet();
    }
}
