package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    WebDriver driver;


// locater
    By usernameinput =By.id("user-name");
    By passewordinput= By.id("password");
    By buttonlogin=By.id("login-button");
    By messagederreur=By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");


    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    //actions(les fonctions wraper )
    public void enterusername ( String  username){
        driver.findElement(usernameinput).sendKeys(username);

    }
    public void enterpasseword ( String  passeword){
        driver.findElement(passewordinput).sendKeys(passeword);

    }
    public void clicklogin(){
        driver.findElement(buttonlogin).click();

    }
public String getMessagederreur (){
        return driver.findElement(messagederreur).getText();
}

}
