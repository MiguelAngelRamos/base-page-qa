package cl.kibernumacademy.basepage.pages;

public class LoginPage extends BasePage {
  // Localizadores
  private String emailField = "//input[@id='email']";
  private String passwordField = "//input[@id='password']";
  public void navigateToLogin() {
    navigateTo("https://testing-qa.netlify.app/pages/login");
  }
}
