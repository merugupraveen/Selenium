package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {

  public WebDriver getDriver() {
    return driver;
  }

  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }

  private static WebDriver driver;

  public static WebDriver getInstance(){
    return driver;
  }
  public static WebDriver getInstance(String broswer){
    if(driver==null) {
      switch (broswer) {
        case "CHROME":
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          break;
        case "EDGE":
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();
      }
    }
    return driver;
  }

}
