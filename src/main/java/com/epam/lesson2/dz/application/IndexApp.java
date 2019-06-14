package com.epam.lesson2.dz.application;

import com.epam.lesson2.dz.myDefinitions.MyBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

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
        bdr.loadBeanDefinitions("virtual");
        ctx.refresh();

        IndexApp indexApp = ctx.getBean("indexApp", IndexApp.class);
        System.out.println(indexApp.service.serve());
    }
}
