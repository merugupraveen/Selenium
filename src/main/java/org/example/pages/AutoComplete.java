package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoComplete extends BasePage{

  @FindBy(linkText = "Autocomplete")
  public WebElement autoComplete;

  public AutoComplete(WebDriver driver) {
    super(driver);
  }
}
