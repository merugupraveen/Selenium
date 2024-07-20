package org.example.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePicker extends BasePage {

  @FindBy(id = "datepicker")
  public WebElement datePicker;

  @FindBy(xpath = "//div[@class='datepicker-days']/table//tr[2]/th[@class='datepicker-switch']")
  public WebElement yearMonth;

  @FindBy(xpath = "//div[@class='datepicker-months']/table//tr[2]/th[@class='datepicker-switch']")
  public WebElement currentYear;

  @FindBy(xpath = "//div[@class='datepicker-years']/table//tr[2]/th[@class='datepicker-switch']")
  public WebElement currentYearRange;

  @FindBy(xpath = "//div[@class='datepicker-years']/table//tr[2]/th[1]")
  public WebElement prevYear;

  @FindBy(xpath = "//div[@class='datepicker-years']/table//tr[2]/th[3]")
  public WebElement nextYear;

  @FindBy(xpath = "//div[@class='datepicker-months']/table//tr[1]//td[1]//span")
  public List<WebElement> listOfMonths;

  @FindBy(xpath = "//div[@class='datepicker-years']/table//tr//span")
  public List<WebElement> listOfYears;

  @FindBy(xpath = "//div[@class='datepicker-days']/table//tr//td")
  public List<WebElement> listOfDays;


  public DatePicker(WebDriver driver) {
    super(driver);
  }

}
