package com.epam.lesson1;

public class Singleton {

  private static Singleton ourInstance = new Singleton();

  public static Singleton getInstance() {
    return ourInstance;
  }

  private Singleton() {
  }
}
