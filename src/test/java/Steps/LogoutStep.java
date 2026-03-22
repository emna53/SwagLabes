package Steps;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutStep {
    WebDriver driver;
    LogoutPage logoutPage;
    LoginPage loginPage;



    @Given("je suis sur la page d acceuil")
    public void jeSuisSurLaPageDAcceuil() {
        //driver=new ChromeDriver();
       // driver.manage().window().maximize();
        this.driver=Hook.driver;
        logoutPage =new LogoutPage(driver);
        driver.get("https://www.saucedemo.com/");
        loginPage =new LoginPage(driver);
        loginPage.enterusername("standard_user");
        loginPage.enterpasseword("secret_sauce");
        loginPage.clicklogin();
    }

   /* @When("je clique sur menu")
    public void jeCliqueSurMenu() {
       logoutPage.clickmenu();
    }

    @And("je clique sur logout")
    public void jeCliqueSurLogout() {
       logoutPage.clickLogout();
    }

    @Then("redirection vers la page connexion")
    public void redirectionVersLaPageConnexion() {
        Assert.assertEquals("https://www.saucedemo.com/",driver.getCurrentUrl());
    driver.quit();

    }*/


}
