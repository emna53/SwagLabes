package Steps;

import Pages.LoginPage;
import Pages.ProduitPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.VisuelValidation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class  ProduitStep {

    WebDriver driver;
    ProduitPage produitPage;
    LoginPage loginPage;
    int compteuravant;
    int nbavantsupprission;


    @Given("je suis sur la page home")
    public void je_suis_sur_la_page_home() {


        //System.setProperty("webdriver.edge.driver", "C:/Users/HP/Downloads/msedgedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage =new LoginPage(driver);
        produitPage=new ProduitPage(driver);
        loginPage.enterusername("standard_user");
        loginPage.enterpasseword("secret_sauce");
        loginPage.clicklogin();
        compteuravant= produitPage.getnumberbadge();
        //produitPage.remplirinfo("emna","lih","77997" );

    }

    @When("je clique sur le button add to cart")
    public void je_clique_sur_le_button_add_to_cart() {
        produitPage.clickaddcart();
    }

    @When("je clique sur button panier")
    public void je_clique_sur_button_panier() {
        produitPage.clickpanier();
    }

    @Then("le produit est ajouté avec succés")
    public void le_produit_est_ajouté_avec_succés() {
       produitPage.verifierajoutproduitpanier();

    }

    @Then("notification d ajout s affiche sur le panier")
    public void notificationDAjoutSAfficheSurLePanier() {
    int competeurapres =produitPage.getnumberbadge();
        Assert.assertEquals(compteuravant+1,competeurapres);
        //compteuravant = competeurapres;

    }

    @And("je clique sur le button add to cart deuxieme produit")
    public void jeCliqueSurLeButtonAddToCartDeuxiemeProduit() {
produitPage.clickaddcart2();
    }

    @Then("incrementation panier")
    public void incrementationPanier() {
        int competeurapres =produitPage.getnumberbadge();
        Assert.assertEquals(compteuravant+1,competeurapres);
    }


    @And("incrementation un seul produit")
    public void incrementationUnSeulProduit() {
        int competeurapres =produitPage.getnumberbadge();
        Assert.assertEquals(compteuravant+1,competeurapres);
        compteuravant = competeurapres;
    }

    @And("je clique sur le button remove")
    public void jeCliqueSurLeButtonRemove() {
        nbavantsupprission=produitPage.obtenirlistproduit().size();
        produitPage.remove();

    }

    @Then("produit est supprime avec succée")
    public void produitEstSupprimeAvecSuccée() {
        List<WebElement>listapres=produitPage.obtenirlistproduit();
        int nbapressupprission=listapres.size();
        Assert.assertEquals(nbavantsupprission-1,nbapressupprission);
         produitPage.verifproduitsupprime();
        //Assert.assertTrue();
    }



    @When("je choisi Z to A")
    public void jeChoisiZToA() {
        produitPage.choisirfiltre();
    }

    @Then("produits filtrés selon ZtoA")
    public void produitsFiltrésSelonZtoA() {
//produitPage.verfifiltreAtoZ();
    }

    @And("je clique sur button checkout")
    public void jeCliqueSurButtonCheckout() {
        produitPage.checkout();
    }

    /*@And("je remplis les informations personnelles")
    public void jeRemplisLesInformationsPersonnelles(String firstname,String lastname,String postalcode) {
produitPage.remplirinfo(firstname,lastname,postalcode);
    }*/



    @And("je saisis firstname {string}")
    public void jeSaisisFirstname(String firstname) {
        produitPage.enterfirstname(firstname);
    }

    @And("je saisis lastname {string}")
    public void jeSaisisLastname(String lastname) {
        produitPage.enterlastname(lastname);
    }

    @And("je saisis le postalecode {string}")
    public void jeSaisisLePostalecode(String postalecode) {
    produitPage.enterpostalcode(postalecode);

    }
    @And("je clique sur continue")
    public void jeCliqueSurContinue() {
        produitPage.continueclick();
    }

    @And("je clique sur finish")
    public void jeCliqueSurFinish() {
        produitPage.finishclick();
    }

    @Then("le message de confirmation s affiche")
    public void leMessageDeConfirmationSAffiche() {
        Assert.assertEquals("Thank you for your order!",produitPage.messageconfirmatio());
    }

    @Then("le message d erreur s affiche {string}")
    public void leMessageDErreurSAffiche(String Expectedmessage) {
Assert.assertEquals(Expectedmessage,produitPage.getmessagefailedcheckout());
    }

    @Then("le prix total doit etre correct")
    public void lePrixTotalDoitEtreCorrect() {
produitPage.verifcalcultotal();
    }

    @Then("l icone doit etre graphiquement conforme")
    public void lIconeDoitEtreGraphiquementConforme() throws Exception{
String screenshotpath="target/screenshots/curentpage.png";
String templatepath="src/test/Resources/Panier.png";
double seuilmin=0.9;
// 2. Prendre une capture d'écran de la page actuelle
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get(screenshotpath);
        Files.createDirectories(destination.getParent());
        Files.copy(srcFile.toPath(), destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        boolean ismatch= VisuelValidation.isElementPresent(screenshotpath,templatepath,seuilmin);
        Assert.assertTrue("icone de panier ne coorespondant pas a l image ",ismatch);
    }
}


