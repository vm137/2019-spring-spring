package com.epam.lesson2.dz.application;

import com.epam.lesson2.dz.myDefinitions.MyBeanDefinition;
import com.epam.lesson2.dz.myDefinitions.MyBeanDefinitionReader;
import com.epam.lesson2.dz.myDefinitions.MyResource;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class IndexAppTest {

    @Test
    public void whenGetBeans_returnsBean() {
        GenericApplicationContext ctx = new GenericApplicationContext();
        MyBeanDefinitionReader bdr = new MyBeanDefinitionReader(ctx);

        Set<MyBeanDefinition> mbdSet = new HashSet<>();
        mbdSet.add(new MyBeanDefinition("basic", "indexService", com.epam.lesson2.dz.application.IndexService.class, ""));
        mbdSet.add(new MyBeanDefinition("property", "indexApp", com.epam.lesson2.dz.application.IndexApp.class, "indexService"));

        MyResource mr = new MyResource();
        mr.setMyBeans(mbdSet);

        bdr.loadBeanDefinitions(mr);
        ctx.refresh();

        IndexApp indexApp = ctx.getBean("indexApp", IndexApp.class);
        assertNotNull(indexApp);
        assertSame("Hello World", indexApp.getService().serve());
    }
}
