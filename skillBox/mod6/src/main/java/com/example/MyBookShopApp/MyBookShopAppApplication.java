package com.example.MyBookShopApp;

import com.example.MyBookShopApp.data.enums.B2UType;
import com.example.MyBookShopApp.repository.Book2UserRepository;
import com.example.MyBookShopApp.repository.Book2UserTypeRepository;
import com.example.MyBookShopApp.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBookShopAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyBookShopAppApplication.class, args);
    }

    private static Logger log = LoggerFactory
            .getLogger(MyBookShopAppApplication.class);

    @Autowired
    private Book2UserRepository book2UserRepository;

    @Autowired
    private Book2UserTypeRepository book2UserTypeRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
//        log.info("TEST");
//        log.info("TEST");
//        log.info("TEST");
//        var type = book2UserTypeRepository.findByCode(B2UType.PAID);
//        var list = book2UserRepository.findAllByType(type);
//        bookRepository.updStatB();
//        bookRepository.updStatC();
//        bookRepository.updStatK();
//        bookRepository.updStatP();
//        log.info(String.valueOf(list.size()));
    }
}
