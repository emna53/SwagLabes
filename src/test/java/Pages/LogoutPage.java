package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;
    WebDriverWait wait;


    By logout = By.id("logout_sidebar_link");
    By menu=By.id("react-burger-menu-btn");


    public LogoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }




    public void clickmenu(){
        driver.findElement(menu).click();
    }
    public void clickLogout(){
        wait.until(ExpectedConditions.presenceOfElementLocated(logout)).click();
        //driver.findElement(logout).click();
    }






}


