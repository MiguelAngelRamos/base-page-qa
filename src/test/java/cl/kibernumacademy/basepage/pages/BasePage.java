package cl.kibernumacademy.basepage.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

  public static void initDriver(WebDriver webDriver) {
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

 public void write(String locator, String textoToWrite) {
  
 }


}
