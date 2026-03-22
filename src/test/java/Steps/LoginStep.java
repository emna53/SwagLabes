package Steps;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginStep {


    //WebDriver driver;
    WebDriver driver=Hook.driver;
    LoginPage loginPage;
    LogoutPage logoutPage;




    @Given("Je suis sur la page de connexion de SauceDemo")
    public void je_suis_sur_la_page_de_connexion_de_sauce_demo() {
        /*driver=new ChromeDriver();
        driver.manage().window().maximize();*/
        this.driver=Hook.driver;
        loginPage =new LoginPage(driver);
        logoutPage =new LogoutPage(driver);
        driver.get("https://www.saucedemo.com/");
    }
    @When("Je saisis le nom d'utilisateur {string}")
    public void je_saisis_le_nom_d_utilisateur(String username) {

        loginPage.enterusername(username);
    }
    @When("Je saisis le mot de passe {string}")
    public void je_saisis_le_mot_de_passe(String passeword) {
loginPage.enterpasseword(passeword);
    }
    @When("Je clique sur le bouton de connexion")
    public void je_clique_sur_le_bouton_de_connexion() {
loginPage.clicklogin();
    }
    @Then("redirection vers la page Home")
    public void redirection_vers_la_page_home() {
    String ActuelURL=driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",ActuelURL);
    }




    @Then("un message d'erreur est affiché")
    public void unMessageDErreurEstAffiché() {
     Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getMessagederreur());

    }

    @Then("un message d'erreur est affiché {string}")
    public void unMessageDErreurEstAffiché(String expectedmessege) {
        Assert.assertEquals(expectedmessege,loginPage.getMessagederreur());
driver.quit();
    }

    @When("je clique sur menu")
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

    }


}
