package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwitchWindow extends BasePage{

  @FindBy(xpath = "//button[normalize-space()='Open alert']")
  public WebElement alert;

  @FindBy(xpath = "//button[normalize-space()='Open new tab']")
  public WebElement newTab;

  @FindBy(linkText = "Autocomplete'")
  public WebElement autoComplete;



  public SwitchWindow(WebDriver driver) {
    super(driver);
  }
}
