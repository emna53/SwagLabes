package Pages;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitPage {
    WebDriver driver;
    WebDriverWait wait;

    By addcart= By.cssSelector("#add-to-cart-sauce-labs-backpack");
    By panier=By.cssSelector("#shopping_cart_container > a");
   By nomproduit =By.cssSelector( "#item_4_title_link > div");
    By nomproduitpanier= By.cssSelector("#item_4_title_link > div");
    By notificationproduit= By.cssSelector("#shopping_cart_container > a > span");
    By nomdeuxiemeproduit=By.cssSelector("#item_0_title_link > div");
    By addcart2=By.cssSelector("#add-to-cart-sauce-labs-bike-light");
    By remouve=By.id("remove-sauce-labs-backpack");
    By listproduit=By.className("cart_item_label");
    By productnames=By.className("inventory_item_name");
    @FindBy(css = "#item_4_title_link > div")
    List<WebElement>nameproduct;
    //By filtreicon=By.cssSelector("#header_container > div.header_secondary_container > div > span > select");

   @FindBy (css ="#header_container > div.header_secondary_container > div > span > select" )
    WebElement filtreicone ;

   By checkout=By.id("checkout");
   By firstnameinput= By.id("first-name");
    By lastnameinput= By.id("last-name");
    By postalcodeinput= By.id("postal-code");
    By Continue =By.id("continue");
    By finish=By.id("finish");
    By message= By.className("complete-header");
    By messageerreur=By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3");
    By prix=By.className("inventory_item_price");
    By iteamprice=By.className("summary_subtotal_label");
    By taxe=By.className("summary_tax_label");
    By totalprice=By.className("summary_total_label");




    public ProduitPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void clickaddcart(){

        //driver.findElement(addcart).click();
      wait.until(ExpectedConditions.elementToBeClickable(addcart));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(addcart));

    }
    public void clickaddcart2() {

        //driver.findElement(addcart).click();

        wait.until(ExpectedConditions.elementToBeClickable(addcart2));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(addcart2));
    }


    public void clickpanier (){

        //driver.findElement(panier).click();

            // Attendre que l'icône du panier soit présente
            wait.until(ExpectedConditions.presenceOfElementLocated(panier));
            // Forcer le clic via JS
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(panier));

    }
    public void verifierajoutproduitpanier(){
        String actuelproduit= driver.findElement(nomproduitpanier).getText();
        String expectproduit =driver.findElement(nomproduit).getText();
        Assert.assertEquals(expectproduit,actuelproduit);
    }

    public void verificationproduit(){
      String notifiproduit= driver.findElement(notificationproduit).getText();
     Assert.assertEquals("1",notifiproduit);
    }

    public int getnumberbadge(){
         List <WebElement>badges =driver.findElements(notificationproduit);
        if (badges.isEmpty()){
            return 0;
        }

        return Integer.parseInt(driver.findElement(notificationproduit).getText());
    }

    public void verfierincrementation(){

    }
    public void verificationajoutdeuxproduit(){
        String notifiproduit= driver.findElement(notificationproduit).getText();


        Assert.assertEquals("1",notifiproduit);
    }

  /*public String nomproduit() {

        return driver.findElement(nomproduit).getText();
   }
    public String nomproduitpanier() {

        return driver.findElement(nomproduitpanier).getText();
    }*/
     public void remove(){
         wait.until(ExpectedConditions.presenceOfElementLocated(remouve)).click();
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].click();", driver.findElement(remouve));
        //driver.findElement(remouve).click();
     }
     public List<WebElement>  obtenirlistproduit(){
        return driver.findElements(listproduit);


     }
     public void verifproduitsupprime(){

        Assert.assertTrue(nameproduct.isEmpty());

}
public void choisirfiltre(){
    Select filtre=new Select(filtreicone);
    filtre.selectByVisibleText("Name (Z to A)");


}
public void verfifiltreAtoZ(){
          List<WebElement> AtoZ=driver.findElements(productnames);
          List<String>actuelnames=new ArrayList<>();
          for (WebElement e:AtoZ){
              actuelnames.add(e.getText());
          }
          List<String>expectedlist=new ArrayList<>(actuelnames);
          expectedlist.sort(Collections.reverseOrder());
          Assert.assertEquals(expectedlist,actuelnames);

}
 public void checkout (){
     wait.until(ExpectedConditions.elementToBeClickable(checkout));
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].click();", driver.findElement(checkout));
       //driver.findElement(checkout).click();
 }
 /*public void remplirinfo(String firstname,String lastname,String postalcode){
     driver.findElement(firstnameinput).sendKeys(firstname);
     driver.findElement(lastnameinput).sendKeys(lastname);
     driver.findElement(postalcodeinput).sendKeys(postalcode)};*/

    public void enterfirstname ( String firstname) {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstnameinput)).sendKeys(firstname);

    }
    public void enterlastname(String lastname){
        wait.until(ExpectedConditions.presenceOfElementLocated(lastnameinput)).sendKeys(lastname);

    }
    public void enterpostalcode(String postalcode){
        wait.until(ExpectedConditions.presenceOfElementLocated(postalcodeinput)).sendKeys(postalcode);

    }
public void continueclick(){
    wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

}
    public void finishclick(){
        //wait.until(ExpectedConditions.elementToBeClickable(finish));
    driver.findElement(finish).click();
}

public String messageconfirmatio(){
    return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();


}
  public String getmessagefailedcheckout (){
     return wait.until(ExpectedConditions.visibilityOfElementLocated(messageerreur)).getText();

  }
  public void verifcalcultotal(){


       wait.until(
              ExpectedConditions.visibilityOfElementLocated(iteamprice)
      );
        List<WebElement>priceselements=driver.findElements(prix);
       double somme=0;

        for (WebElement p :priceselements){
            String pricetext= p.getText().replace("$","");
            //somme =somme+Double.parseDouble(pricetext);
            somme +=Double.parseDouble(pricetext);
        }

        String prixtext=driver.findElement(iteamprice).getText();
        double prixaffiche= Double.parseDouble(prixtext.replace("Item total: $",""));
        String taxes=driver.findElement(taxe).getText();
        double taxeaffiche=Double.parseDouble(taxes.replace("Tax: $" ,""));
        String prixtotal=driver.findElement(totalprice).getText();
        double prixtotalaffiche=Double.parseDouble(prixtotal.replace("Total: $", ""));
      Assert.assertEquals(somme, prixaffiche);
      Assert.assertEquals(prixaffiche + taxeaffiche, prixtotalaffiche);

  }

}



