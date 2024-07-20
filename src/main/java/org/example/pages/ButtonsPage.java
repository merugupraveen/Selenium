package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage{

  @FindBy(xpath = "//button[text()='Primary']")
  public WebElement primary;

  @FindBy(xpath = "//button[text()='Primary']//following-sibling::button[1]")
  public WebElement success;

  @FindBy(xpath = "//button[text()='Primary']//following-sibling::button[2]")
  public WebElement info;

  @FindBy(xpath = "//button[text()='Warning']")
  public WebElement warning;

  @FindBy(xpath = "//button[text()='Link']//preceding-sibling::button[1]")
  public WebElement danger;

  @FindBy(xpath = "//button[normalize-space()='Dropdown']")
  public WebElement dropDown;

  @FindBy(xpath = "//button[normalize-space()='Dropdown']//parent::div//a[text()='Dropdown link 1']")
  public WebElement dropdownlink1;


  public ButtonsPage(WebDriver driver) {
    super(driver);
  }


}
