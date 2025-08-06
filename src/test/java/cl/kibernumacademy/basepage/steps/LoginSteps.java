package cl.kibernumacademy.basepage.steps;

import org.junit.jupiter.api.Assertions;

import cl.kibernumacademy.basepage.pages.BasePage;
import cl.kibernumacademy.basepage.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
  LoginPage loginPage;

  @Before
  public void setUp() {
    BasePage.initDriver();
    loginPage = new LoginPage();
  }

  @Given("I am on the login page")
  public void i_am_on_the_login_page() {
    loginPage.navigateToLogin();
  }
  //   When I enter email "usuario@invalido" and password "123"
  @When("I enter email {string} and password {string}")
  public void i_enter_email_and_password(String email, String password) {
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
  }
ñ
  // And I submit the login form
  @And("I submit the login form")
  public void i_submit_the_login_form() {
    loginPage.submitLogin();
  }

  @Then("I should see email validation error")
  public void i_should_see_email_validation_error() {
    // Ingrese un correo válido.
    Assertions.assertEquals("Ingrese un correo válido.", loginPage.getEmailValidationMessageBootstrap5());
  }

  @And("I should see password validation error")
  public void i_should_see_password_validation_error() {
    // Mínimo 8 caracteres, al menos una letra y un número.
   Assertions.assertEquals("Mínimo 8 caracteres, al menos una letra y un número.", loginPage.getPasswordValidationMessageBootstrap5());
  }

  @After
  public void tearDown() {
    BasePage.closeBrowser();
  }
}
