package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

  @FindBy(id = "checkbox-1")
  public WebElement cb1;

  @FindBy(xpath = "//input[@value='checkbox-2']")
  public WebElement cb2;

  public CheckBoxPage(WebDriver driver) {
    super(driver);
  }

}
