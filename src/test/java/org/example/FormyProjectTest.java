package org.example;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import org.example.pages.AutoComplete;
import org.example.pages.ButtonsPage;
import org.example.pages.CheckBoxPage;
import org.example.pages.DatePicker;
import org.example.pages.DragPage;
import org.example.pages.DynamicLoadPage;
import org.example.pages.FormPage;
import org.example.pages.FormyProjectHerokuappHome;
import org.example.pages.ModalPage;
import org.example.pages.SwitchWindow;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FormyProjectTest extends BaseTest {

  WebDriver driver = Driver.getInstance("EDGE");
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

  @Test
  public void test1() {
    driver.get("https://formy-project.herokuapp.com/");
    FormyProjectHerokuappHome formyProjectHerokuappHome = new FormyProjectHerokuappHome(driver);
    formyProjectHerokuappHome.buttons.click();

    ButtonsPage buttonsPage = new ButtonsPage(driver);
    wait.until(ExpectedConditions.visibilityOf(buttonsPage.primary));

    buttonsPage.success.click();

    Actions actions = new Actions(driver);
    actions.click(buttonsPage.info);

    actions.moveToElement(buttonsPage.warning).click().build().perform();

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click;", buttonsPage.danger);

    buttonsPage.dropDown.click();

    buttonsPage.dropdownlink1.click();

  }

  @Test
  public void cbTest() {
    WebDriver driver1 = Driver.getInstance("EDGE");
    driver1.get("https://formy-project.herokuapp.com/");
    FormyProjectHerokuappHome formyProjectHerokuappHome = new FormyProjectHerokuappHome(driver1);
    formyProjectHerokuappHome.checkbox.click();
    CheckBoxPage checkBoxPage = new CheckBoxPage(driver1);
    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.elementToBeClickable(checkBoxPage.cb1));

    checkBoxPage.cb1.click();
    checkBoxPage.cb2.click();
    if (checkBoxPage.cb1.isSelected()) {
      checkBoxPage.cb1.click();
    }
  }

  @Test
  public void datePickerTest() throws ParseException, InterruptedException {
    WebDriver driver1 = Driver.getInstance("EDGE");
    driver1.get("https://formy-project.herokuapp.com/");
    FormyProjectHerokuappHome formyProjectHerokuappHome = new FormyProjectHerokuappHome(driver1);
    formyProjectHerokuappHome.datepicker.click();

    DatePicker datePicker = new DatePicker(driver1);

    Thread.sleep(1000);
    datePicker.datePicker.click();
    Thread.sleep(1000);
    datePicker.yearMonth.click();
    Thread.sleep(1000);
    Actions actions = new Actions(driver);
    actions.click(datePicker.currentYear);
    wait.until(ExpectedConditions.elementToBeClickable(datePicker.currentYear));

    Thread.sleep(5000);
    datePicker.currentYear.click();
    selectDate(datePicker, "2054-01-01");

  }

  void selectDate(DatePicker datePicker, String date) throws ParseException {
    LocalDate localDate = LocalDate.parse(date);
    int expYear = localDate.getYear();

    LocalDate currentDate = LocalDate.now();

    Optional<WebElement> optional = datePicker.listOfYears.stream()
        .filter(year -> Integer.parseInt(year.getText()) == expYear).findFirst();
    if (optional.isPresent()) {
      optional.get().click();
      return;
    }

    if (expYear < currentDate.getYear()) {

      findPrevYear(datePicker, expYear);

    } else if (expYear > currentDate.getYear()) {

      findNextYear(datePicker, expYear);

    }
  }

  private void findNextYear(DatePicker datePicker, int expYear) {
    if (checkYearAvailable(expYear, datePicker)) {
      datePicker.listOfYears.stream()
          .filter(year -> Integer.parseInt(year.getText()) == expYear).findFirst().get().click();
    } else {
      wait.until(ExpectedConditions.visibilityOf(datePicker.nextYear));
      datePicker.nextYear.click();
      findNextYear(datePicker, expYear);
    }
  }

  private void findPrevYear(DatePicker datePicker, int expYear) {
    if (checkYearAvailable(expYear, datePicker)) {
      datePicker.listOfYears.stream()
          .filter(year -> Integer.parseInt(year.getText()) == expYear).findFirst().get().click();
    } else {
      datePicker.prevYear.click();
      findPrevYear(datePicker, expYear);
    }
  }

  private boolean checkYearAvailable(int expYear, DatePicker datePicker) {
    Optional<WebElement> optional = datePicker.listOfYears.stream()
        .filter(year -> Integer.parseInt(year.getText()) == expYear).findFirst();
    return optional.isPresent();
  }

  @Test
  public void dragAndDrop() throws InterruptedException {
    driver.get("https://formy-project.herokuapp.com/");
    FormyProjectHerokuappHome formyProjectHerokuappHome = new FormyProjectHerokuappHome(driver);
    formyProjectHerokuappHome.dragAndDrop.click();

    DragPage dragPage = new DragPage(driver);
    wait.until(ExpectedConditions.visibilityOf(dragPage.image));
    Actions actions = new Actions(driver);
    for (int i = 0; i < 5; i++) {
      try {
//        actions.clickAndHold(dragPage.image).dragAndDropBy(dragPage.box, 10, 10).build().perform();
        actions.clickAndHold(dragPage.image).perform();
        Thread.sleep(2000);
        actions.moveByOffset(
            dragPage.box.getLocation().getX() - dragPage.image.getLocation().getX(),
            dragPage.box.getLocation().getY() - dragPage.image.getLocation().getY()).perform();
        break;
      } catch (Exception e) {

      }
    }
    //        .dragAndDrop(dragPage.image , dragPage.box).perform();

    Thread.sleep(4000);
  }

  @Test
  public void windowpopup() throws InterruptedException {
    driver.get("https://formy-project.herokuapp.com/modal");
    ModalPage modalPage = new ModalPage(driver);
    wait.until(ExpectedConditions.visibilityOf(modalPage.modalButton));
    modalPage.modalButton.click();
    Thread.sleep(3000);
    modalPage.closeButton.click();


  }

  @Test
  public void scroll() throws InterruptedException {
    driver.get("https://formy-project.herokuapp.com/scroll");
    ScrollPage scrollPage = new ScrollPage(driver);
    wait.until(ExpectedConditions.visibilityOf(scrollPage.large));

    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].scrollIntoView(true)", scrollPage.fullName);
//    js.executeScript("window.scrollBy(0,100)", scrollPage.fullName);
    js.executeScript("window.scrollTo(0,document.body.scrollHeight)", scrollPage.fullName);

    Thread.sleep(4000);

  }

  @Test
  public void popups() throws InterruptedException {
    driver.get("https://formy-project.herokuapp.com/switch-window");
    SwitchWindow switchWindow = new SwitchWindow(driver);
    Thread.sleep(2000);
    switchWindow.alert.click();
    Thread.sleep(2000);

    Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
    alert.dismiss();
//    driver.switchTo().alert().accept();
    Thread.sleep(2000);

  }

  @Test
  public void popups2() throws InterruptedException {
    driver.get("https://formy-project.herokuapp.com/switch-window");
    SwitchWindow switchWindow = new SwitchWindow(driver);
    Thread.sleep(2000);
    String parentId = driver.getWindowHandle();
    switchWindow.newTab.click();
    Thread.sleep(2000);

    Set<String> setHandles = driver.getWindowHandles();
    setHandles.iterator().forEachRemaining(handle -> {
      if (!handle.equals(parentId)) {

        driver.switchTo().window(handle);
        AutoComplete autoComplete = new AutoComplete(driver);
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        autoComplete.autoComplete.click();
      }
    });

    Thread.sleep(2000);

  }

  @Test
  public void form() throws InterruptedException {
    driver.get("https://formy-project.herokuapp.com/");

    FormyProjectHerokuappHome formyProjectHerokuappHome = new FormyProjectHerokuappHome(driver);
    formyProjectHerokuappHome.completeWebForm.click();
    FormPage formPage = new FormPage(driver);
    wait.until(ExpectedConditions.elementToBeClickable(formPage.select));

    Select select = new Select(formPage.select);
    select.selectByIndex(0);
    Thread.sleep(2000);
    select.selectByValue("2");
    Thread.sleep(2000);
    select.selectByVisibleText("10+");
    Thread.sleep(2000);

  }


  @Test
  public void dynamic() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/dynamic_loading");

    DynamicLoadPage dynamicLoadPage = new DynamicLoadPage(driver);
    dynamicLoadPage.example1.click();
    Thread.sleep(2000);
    dynamicLoadPage.start.click();
    wait.until(ExpectedConditions.attributeToBe(dynamicLoadPage.finish,"style",""));

    driver.navigate().back();

    dynamicLoadPage.example2.click();
    Thread.sleep(2000);
    dynamicLoadPage.start.click();
    wait.until(ExpectedConditions.visibilityOf(dynamicLoadPage.hello));

  }
}
