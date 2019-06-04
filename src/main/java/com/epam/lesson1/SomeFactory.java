package com.epam.lesson1;

import java.util.HashMap;
import java.util.Map;

public class SomeFactory {

  private final Map<String, Object> value = new HashMap<>();

  public SomeFactory() {
    value.put("B", new D());
  }

  Object getBean(String name) throws RuntimeException {
    return value.get(name);
  }

  void addBean(String name, Object object) {
    value.put(name, object);
  }

}
