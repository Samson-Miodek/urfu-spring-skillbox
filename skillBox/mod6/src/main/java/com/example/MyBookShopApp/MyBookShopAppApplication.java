package com.example.MyBookShopApp;

import com.example.MyBookShopApp.repository.Book2UserRepository;
import com.example.MyBookShopApp.repository.Book2UserTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBookShopAppApplication  {

//    implements CommandLineRunner
    public static void main(String[] args) {
        SpringApplication.run(MyBookShopAppApplication.class, args);
    }

//    private static Logger log = LoggerFactory
//            .getLogger(MyBookShopAppApplication.class);
//
//    @Autowired
//    private Book2UserRepository book2UserRepository;
//
//    @Autowired
//    private Book2UserTypeRepository book2UserTypeRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        log.info("TEST");
//        var res = book2UserRepository.custom();
//        var f = res.get(0);
//        log.info(String.valueOf(res.size()));
//        log.info(String.valueOf(f.getBook().getTitle()));
//        log.info(String.valueOf(f.getUser().getName()));
//        log.info(String.valueOf(f.getType().getCode()));
//        log.info(String.valueOf(f.getType().getName()));
//
//        var type = book2UserTypeRepository.findByCode("PAID");
//        log.info(type.getCode());
//        var res2 = book2UserRepository.findAllByType(type);
//        log.info("\n\n\n");
//        log.info(String.valueOf(res2.size()));
//    }
}
