package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasketballenglandStepdefs {
    WebDriver driver;
    String email = (System.currentTimeMillis() % 100000) + "@mailnesia.com";

    //Testa två olika browsers

    @Given("I am at BasketballEngland page using {string}")
    public void IAmAtBasketBallEnglandPage(String browser) {
        if (browser.equals("chrome")) driver = new ChromeDriver();
        if (browser.equals("firefox")) driver = new FirefoxDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();

    }

    //Skapa konto, checka i allt

    @When("I create an account")
    public void ICreateAnAccount() {

        driver.findElement(By.id("dp"))
                .sendKeys("27/08/1990" + "\n");
        driver.findElement(By.cssSelector("#member_firstname"))
                .sendKeys("Test");
        driver.findElement(By.cssSelector("#member_lastname"))
                .sendKeys("Testsson");
        driver.findElement(By.cssSelector("#member_emailaddress"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("#member_confirmemailaddress"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("#signupunlicenced_password"))
                .sendKeys("abc123");
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword"))
                .sendKeys("abc123");
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(3) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(6) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(9) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(12) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(15) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(18) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(21) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(24) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(27) .box"))
                .click();
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box"))
                .click();
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box"))
                .click();
        driver.findElement(By.xpath("//div[4]/label/span[3]"))
                .click();
        driver.findElement(By.xpath("//div[5]/label/span[3]"))
                .click();
        driver.findElement(By.xpath("//div[7]/label/span[3]"))
                .click();
        driver.findElement(By.cssSelector(".btn"))
                .click();

    }

    //Kontrollera att verifieringssida laddar

    @Then("The account is successfully created")
    public void TheAccountIsSuccessfullyCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("GO TO MY LOCKER"))).click();
    }

    //Kontrollera att vi får svar på verifieringssida

    @Then("We see our account page {string}")
    public void weSeeOurAccountPage(String confirmationUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".username")));
        String url = driver.getCurrentUrl();
        assertEquals(url, confirmationUrl);
    }

    //Är på sida utan att testa browsers

    @Given("I am at BasketballEngland page")
    public void iAmAtBasketballEnglandPage() {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();
    }

    //Testa email

    @When("I enter my email {string}")
    public void iEnterMyEmail(String email) {
        driver.findElement(By.cssSelector("#member_emailaddress"))
                .sendKeys(email);
    }

    @And("I confirm my email {string}")
    public void iConfirmMyEmail(String confirmemail) {
        driver.findElement(By.cssSelector("#member_confirmemailaddress"))
                .sendKeys(confirmemail + "\n");
    }

    //Testa lösenord

    @When("I enter my password {string}")
    public void iEnterMyPassword(String password) {
        driver.findElement(By.cssSelector("#signupunlicenced_password"))
                .sendKeys(password);
    }

    @And("I confirm my password {string}")
    public void iConfirmMyPassword(String confirmpassword) {
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword"))
                .sendKeys(confirmpassword + "\n");
    }

    //Testa namn

    @When("I enter my name {string}")
    public void iEnterMyName(String name) {
        driver.findElement(By.cssSelector("#member_firstname"))
                .sendKeys(name);
    }

    //Testa efternamn

    @And("I enter my lastname {string}")
    public void iEnterMyLastname(String lastname) {
        driver.findElement(By.cssSelector("#member_lastname"))
                .sendKeys(lastname + "\n");
    }

    //Testa varningsmeddelande samtliga

    @Then("The {string} is displayed")
    public void theErrormessageIsDisplayed(String errormessage) {
        String err = driver.findElement(By.cssSelector(".warning > span")).getText();
        assertEquals(errormessage, err);
    }

    //Skapa konto utan att checka i Terms and Conditions

    @When("I create an account without accepting terms and conditions")
    public void iCreateAnAccountWithoutAcceptingTermsAndConditions() {

        driver.findElement(By.id("dp"))
                .sendKeys("27/08/1990" + "\n");
        driver.findElement(By.cssSelector("#member_firstname"))
                .sendKeys("Test");
        driver.findElement(By.cssSelector("#member_lastname"))
                .sendKeys("Testsson");
        driver.findElement(By.cssSelector("#member_emailaddress"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("#member_confirmemailaddress"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("#signupunlicenced_password"))
                .sendKeys("abc123");
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword"))
                .sendKeys("abc123");
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(3) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(6) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(9) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(12) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(15) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(18) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(21) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(24) .box"))
                .click();
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(27) .box"))
                .click();
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box"))
                .click();
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box"))
                .click();
        driver.findElement(By.xpath("//div[4]/label/span[3]"))
                .click();
        driver.findElement(By.xpath("//div[5]/label/span[3]"))
                .click();
        driver.findElement(By.cssSelector(".btn"))
                .click();
    }
}



