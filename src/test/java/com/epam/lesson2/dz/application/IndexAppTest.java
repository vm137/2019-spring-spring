package com.epam.lesson2.dz.application;

import com.epam.lesson2.dz.myDefinitions.MyBeanDefinitionReader;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.Assert.*;

public class IndexAppTest {

    @Test
    public void whenGetBeans_returnsBean() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-conf.xml");
        GenericApplicationContext ctx = new GenericApplicationContext();

        MyBeanDefinitionReader bdr = new MyBeanDefinitionReader(ctx);
        bdr.loadBeanDefinitions("virtual");
        ctx.refresh();

        IndexApp indexApp = ctx.getBean("indexApp", IndexApp.class);
        assertNotNull(indexApp);
        assertSame("Hello World", indexApp.getService().serve());
    }
}
