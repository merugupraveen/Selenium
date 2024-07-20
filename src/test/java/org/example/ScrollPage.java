package org.example;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScrollPage extends BasePage {



  @FindBy(xpath = "//input[@placeholder='Full name']")
  public WebElement fullName;

  @FindBy(xpath = "//h1[text()='Large page content']")
  public WebElement large;
  public ScrollPage(WebDriver driver) {
    super(driver);
  }
}
