package cl.kibernumacademy.basepage.steps;

import cl.kibernumacademy.basepage.pages.BasePage;
import cl.kibernumacademy.basepage.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

  // And I submit the login form
  @And("I submit the login form")
  public void i_submit_the_login_form() {
    loginPage.submitLogin();
  }

  @After
  public void tearDown() {
    BasePage.closeBrowser();
  }
}
