package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragPage extends BasePage{

  @FindBy(id = "image")
  public WebElement image;

  @FindBy(id = "box")
  public WebElement box;


  public DragPage(WebDriver driver) {
    super(driver);
  }
}
