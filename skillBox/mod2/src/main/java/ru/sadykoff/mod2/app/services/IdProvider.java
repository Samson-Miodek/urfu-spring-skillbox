package ru.sadykoff.mod2.app.services;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.sadykoff.mod2.web.dto.Book;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class IdProvider implements InitializingBean, DisposableBean, BeanPostProcessor {

    Logger logger = Logger.getLogger(IdProvider.class);

    public String provideId(Book book) {
        return String.format("%s_%s",this.hashCode(),book.hashCode());
    }

    private void iniIdProvider() {
        logger.info("iniIdProvider");
    }

    private void destroyIdProvider() {
        logger.info("destroyIdProvider");
    }

    private void defaultInit(){
        logger.info("defaultInit in provider");
    }

    private void defaultDestroy(){
        logger.info("defaultDestroy in provider");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("provider afterPropertiesSet invoked");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("DisposibleBean destroy invoked");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info(String.format("postProcessBeforeInitialization invoked by bean %s",beanName));
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info(String.format("postProcessAfterInitialization invoked by bean %s",beanName));
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @PostConstruct
    public void postConstructIdProvider(){
        logger.info("PostConstruct by IdProvider");
    }
    @PreDestroy
    public void preDestroyIdProvider(){
        logger.info("PreDestroy by IdProvider");
    }
}
