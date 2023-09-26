package ru.sadykoff.mod1.xmlconfig;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sadykoff.mod1.Person;
import ru.sadykoff.mod1.Pet;

public class XmlMod1Application {

    public static void main(String[] args) {
        var applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        var dog = applicationContext.getBean("myDog", Pet.class);
        var cat = applicationContext.getBean("myCat", Pet.class);
        dog.say();
        cat.say();

        var person = applicationContext.getBean("person", Person.class);
        person.callPet();
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }

}
