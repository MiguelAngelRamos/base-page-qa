package cl.kibernumacademy.basepage.pages;

public class LoginPage extends BasePage {
  // Localizadores
  private String emailField = "//input[@id='email']";
  private String passwordField = "//input[@id='password']";
  private String submitButton = "//button[@type='submit']";

  public void navigateToLogin() {
    navigateTo("https://testing-qa.netlify.app/pages/login");
  }

  public void enterEmail(String email) {

  }

  public void enterPassword(String password) {
    
  }
}
