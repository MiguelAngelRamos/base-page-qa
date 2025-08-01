package cl.kibernumacademy.basepage.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
  
  protected static WebDriver driver;
  private static WebDriverWait wait;

  /**
   * Inicializa el WebDriver y WebDriverWait para cada escenario.
   * Se debe llamar desde el hook @Before en los steps.
   * Referencia: https://cucumber.io/docs/cucumber/environment-variables/
  */

  public static void initDriver() {
    if(driver != null) driver.quit();

    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--window-size=1920,1080"); // 800, 600
    driver = new ChromeDriver(chromeOptions);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public BasePage() {
    // Esto no hace nada por que todo lo inicializamos en el initDriver()
  }

  //* Ir hacia el sitio web 
  public static void navigateTo(String url) {
    System.out.println(url);
    driver.get(url);
  }

 //* Cerrar el navegador
 public static void closeBrowser() {
    if(driver != null) {
      driver.quit();
      driver = null;
      wait = null;
    }
 }

 //* Método que private solo es ser accesible dentro de la clase
   protected WebElement find(String type, String locator) {
    By by;
    switch (type.toLowerCase()) {
      case "id":
        by = By.id(locator);
        break;
      case "css":
        by = By.cssSelector(locator);
        break;
      case "xpath":
        by = By.xpath(locator);
        break;
      case "class":
        by = By.className(locator);
        break;
      case "name":
        by = By.name(locator);
        break;
      case "tag":
        by = By.tagName(locator);
        break;
      case "linktext":
        by = By.linkText(locator);
        break;
      default:
        throw new IllegalArgumentException("Tipo de locator no soportado: " + type);
    }
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }


  public void write(String type, String locator, String textToWrite) {
    find(type, locator).clear();
    find(type, locator).sendKeys(textToWrite);
  }


  public void clickElement(String type, String locator) {
    find(type, locator).click();
  }

  public String getInputValidationMessageByIdBootstrap5(String inputId) {
    WebElement input = find("id", inputId); // EL objetivo es obtener el input email y password o cualquier elemento de input
    if(input.getAttribute("class").contains("is-invalid")) {
      // selecciona todos los elementos <div> que son hermanos del mismo padre y están despues del input
      // Y filtra solos los div que contengan la clase 'invalid-feedback'
      return input.findElement(By.xpath("following-sibling::div[contains(@class, 'invalid-feedback')]")).getText();
      
    }
    return "";
  }


}
