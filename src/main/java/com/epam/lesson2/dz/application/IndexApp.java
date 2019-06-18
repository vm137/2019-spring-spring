package com.epam.lesson2.dz.application;

import com.epam.lesson2.dz.myDefinitions.MyBeanDefinition;
import com.epam.lesson2.dz.myDefinitions.MyBeanDefinitionReader;
import com.epam.lesson2.dz.myDefinitions.MyResource;
import org.springframework.context.support.GenericApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class IndexApp {
    private IService service;

    public IndexApp() {
    }

    public IndexApp(IService service) {
        this.service = service;
    }

    public void setService(IService service) {
        this.service = service;
    }

    public IService getService() {
        return service;
    }


    public static void main(String[] args) {
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
        System.out.println(indexApp.service.serve());
    }
}
