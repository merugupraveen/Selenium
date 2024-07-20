package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormyProjectHerokuappHome extends BasePage {

  @FindBy(linkText = "Buttons")
  public WebElement buttons;

  @FindBy(linkText = "Checkbox")
  public WebElement checkbox;

  @FindBy(linkText = "Datepicker")
  public WebElement datepicker;


  @FindBy(linkText = "Drag and Drop")
  public WebElement dragAndDrop;


  @FindBy(linkText = "Complete Web Form")
  public WebElement completeWebForm;



  WebDriver driver;

  public FormyProjectHerokuappHome(WebDriver driver) {
    super(driver);
  }

}
