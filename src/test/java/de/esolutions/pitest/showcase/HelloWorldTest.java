package de.esolutions.pitest.showcase;

import org.junit.jupiter.api.Test;

public class HelloWorldTest {
  @Test
  void shouldPrintHelloWorld() {
    HelloWorld cut = new HelloWorld();

    cut.helloWorld();
  }
}