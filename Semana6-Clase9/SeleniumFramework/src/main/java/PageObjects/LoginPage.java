package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    //Elementos
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By submitButtonSelector = By.cssSelector("[value='Login']");
    private By unsuccessLoginMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
    public By logOutButtonLocator = By.linkText("Logout");

    public LoginPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void EnterEmail(String email){
        this.driver.findElement(emailInputLocator).sendKeys(email);
    }
    public void EnterPassword(String password){
        this.driver.findElement(passwordInputLocator).sendKeys(password);
    }
    public void ClickSubmitButton(){
        this.driver.findElement(submitButtonSelector).click();
    }
    public String UnsucessLoginMessage() {return  this.driver.findElement(unsuccessLoginMessage).getText().toLowerCase().trim(); };
    public Boolean IsLogOutButtonDisplayed() {return  this.driver.findElement(logOutButtonLocator).isDisplayed(); };



    public void login(String username, String password){
        this.driver.findElement(emailInputLocator).sendKeys(username);
        this.driver.findElement(passwordInputLocator).sendKeys(password);
        this.driver.findElement(submitButtonSelector).click();
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();
    }
}
