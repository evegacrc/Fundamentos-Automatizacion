package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage{
    private WebDriver driver;

    //Elementos
    private By NameLocator = By.name("firstname");
    private By LastNameLocator = By.name("lastname");
    private By EmailLocator = By.name("email");
    private By TelephoneLocator = By.name("telephone");
    private By PasswordLocator = By.name("password");
    private By ConfirmLocator = By.name("confirm");
    private By ConfirmRegisterMessageLocator = By.xpath("//div[@id='content']/h1");
    private By TermsCheckBoxLocator = By.name("agree");
    private By ContinueButtonLocator = By.xpath("//input[@value='Continue']");


    public RegisterPage(WebDriver _driver){
        this.driver = _driver;
    }
    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();
    }

    public String[] GenerateNewUserInfo(){
        String emailName = RandomStringUtils.randomAlphanumeric(8);
        String emailTag = "@test.com";
        String randomEmail = emailName.concat(emailTag);
        String randomName = RandomStringUtils.randomAlphabetic(8);
        String randomLastName = RandomStringUtils.randomAlphabetic(8);
        String randomTelephone = RandomStringUtils.randomAlphabetic(8);
        String randomPassword = RandomStringUtils.randomAlphanumeric(8);
        String[] userInfo = new String[] {randomName,randomLastName,randomEmail,randomTelephone,randomPassword};

        return userInfo;
    }
    public void FillForm(String firstName, String lastName, String email, String telephone, String password){
        driver.findElement(NameLocator).sendKeys(firstName);
        driver.findElement(LastNameLocator).sendKeys(lastName);
        driver.findElement(EmailLocator).sendKeys(email);
        driver.findElement(TelephoneLocator).sendKeys(telephone);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(ConfirmLocator).sendKeys(password);
        driver.findElement(TermsCheckBoxLocator).click();
        driver.findElement(ContinueButtonLocator).click();
    }



    public String GetConfirmationMessage(){
        return driver.findElement(ConfirmRegisterMessageLocator).getText();
    }


}
