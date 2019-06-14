package com.epam.lesson2.dz.application;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class IndexAppTest {

    @Test
    public void whenGetBeans_returnsBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-conf.xml");
        IndexApp indexApp = applicationContext.getBean("indexApp", IndexApp.class);
        assertNotNull(indexApp);
        assertSame("Hello World", indexApp.getService().serve());
    }
}
