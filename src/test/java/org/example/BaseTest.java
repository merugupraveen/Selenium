package org.example;

import org.testng.annotations.AfterTest;

public class BaseTest {

  @AfterTest
  public void afterTest() {
    Driver.getInstance().close();
    Driver.getInstance().quit();

  }

}
