package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By currencySelector = By.xpath("//*[@id=\"form-currency\"]/div/button/i");
    private By eurCurreny = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    private By poundCurreny = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");
    private By usdCurreny = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");

                                //*[@id="content"]/div[1]/div[2]/ul[2]/li[2]/h2

    public HeaderPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }
    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }
    public void clickOnCurrency(String currency) {
        driver.findElement(currencySelector).click();
        if(currency.equals("usd")) {
            driver.findElement(usdCurreny).click();
        } else if(currency.equals("eur")) {
            driver.findElement(eurCurreny).click();
        } else if(currency.equals("pound")) {
            driver.findElement(poundCurreny).click();
        }
    }
}
