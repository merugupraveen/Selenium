package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalPage extends BasePage{


  @FindBy(id = "modal-button")
  public WebElement modalButton;

  @FindBy(id = "close-button")
  public WebElement closeButton;

  public ModalPage(WebDriver driver) {
    super(driver);
  }
}
