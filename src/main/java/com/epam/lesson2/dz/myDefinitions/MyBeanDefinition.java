package com.epam.lesson2.dz.myDefinitions;

import java.io.Serializable;

public class MyBeanDefinition implements Serializable {
    String type;
    String name;
    Class clazz;
    String ref;

    public MyBeanDefinition(String type, String name, Class clazz, String ref) {
        this.type = type;
        this.name = name;
        this.clazz = clazz;
        this.ref = ref;
    }
}
