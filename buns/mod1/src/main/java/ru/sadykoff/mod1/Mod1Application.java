package ru.sadykoff.mod1;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mod1Application {

    public static void main(String[] args) {
        var applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        var dog = applicationContext.getBean("myDog", Pet.class);
        dog.say();
        var cat = applicationContext.getBean("myCat", Pet.class);
        cat.say();
    }

}
