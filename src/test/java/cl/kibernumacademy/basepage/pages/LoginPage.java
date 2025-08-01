package cl.kibernumacademy.basepage.pages;

public class LoginPage extends BasePage {
  // Localizadores
  private String emailField = "//input[@id='email']";
  private String passwordField = "//input[@id='password']";
  private String submitButton = "//button[@type='submit']";
  // Ejemplo para utilizar los id pero podria haber utlizado xpath
  private String emailFieldById = "email";
  private String passwordFieldById = "password";


  public void navigateToLogin() {
    navigateTo("https://testing-qa.netlify.app/pages/login");
  }

  public void enterEmail(String email) {
    write("xpath", emailField, email);
  }

  public void enterPassword(String password) {
    write("xpath", passwordField, password);
  }

  public void submitLogin() {
    clickElement("xpath", submitButton);
  }

  // Obtener El mensaje de validacion de email

  public String getEmailValidationMessageBootstrap5() {
    return getInputValidationMessageByIdBootstrap5(emailFieldById);
  }

  // Obtener el mensaje de validacion de password
  public String getPasswordValidationMessageBootstrap5() {
    return getInputValidationMessageByIdBootstrap5(passwordFieldById);
  }

}
