package com.epam.lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A {

  private final B bclass;
  private final SomeFactory someFactory;

  public A() {
    someFactory = new SomeFactory();
    bclass = (B) someFactory.getBean("B");
  }

  public void soSmt() {
    bclass.getValue();
  }

  public static void main(String[] args) {
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
    classPathXmlApplicationContext.refresh();
  }

}

interface B {
  String getValue();
}

class C implements B {

  @Override
  public String getValue() {
    return "some_value";
  }
}

class D implements B {

  @Override
  public String getValue() {
    return "some_another_value";
  }
}
