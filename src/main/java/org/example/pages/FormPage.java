package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage{

  @FindBy(id = "select-menu")
  public WebElement select;

  public FormPage(WebDriver driver) {
    super(driver);
  }
}
