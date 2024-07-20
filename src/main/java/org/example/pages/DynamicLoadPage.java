package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadPage extends BasePage{

  @FindBy(linkText = "Example 1: Element on page that is hidden")
  public WebElement example1;

  @FindBy(linkText = "Example 2: Element rendered after the fact")
  public WebElement example2;

  @FindBy(xpath = "//button[text()='Start']")
  public WebElement start;

  @FindBy(id = "finish")
  public WebElement finish;

  @FindBy(xpath = "//img[@src='/img/ajax-loader.gif']")
  public WebElement loader;

  @FindBy(xpath = "//h4[text()='Hello World!']")
  public WebElement hello;


  public DynamicLoadPage(WebDriver driver) {
    super(driver);
  }
}
