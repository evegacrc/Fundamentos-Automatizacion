package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BaseClass {

    private static final String ERROR_MESSAGE_NO_RESULTS_DISPLAYED = "There is no product that matches the search criteria.";
    private static final String ALERT_DANGER_NOT_IN_STOCK = " Products marked with *** are not available in the desired quantity or not in stock!";

    //elementos
    private By resultsSelector = By.cssSelector(".product-thumb");
    private By noResultsSelector = By.id("content");

    private By searchInput = By.name("search");
    private By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    private By productThumb = By.cssSelector(".product-thumb");
    private By macbookSearch = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a");
    private By outOfStock = By.xpath("//*[@id=\"checkout-cart\"]/div[1]");
    private By productPrice = By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[*]/h2");


    public SearchResultsPage(WebDriver driver){
        super.driver = driver;
    }
    public void ClickMacbookSearchElement(){
        if(this.driver.findElement(macbookSearch).getAttribute("innerHTML").contains("MacBook")) {
            this.driver.findElement(macbookSearch).click();
        }
    }
    public int getResultsCount(){ return this.driver.findElements(productThumb).size();}
    public boolean isNoResultsVisible(){return driver.findElement(noResultsSelector).getAttribute("innerHTML").contains(ERROR_MESSAGE_NO_RESULTS_DISPLAYED);}
    public void searchByEnter(String searchCriteria){ driver.findElement(searchInput).sendKeys(searchCriteria, Keys.ENTER);}
    public void searchByClick(String searchCriteria){ this.driver.findElement(searchInput).sendKeys(searchCriteria); this.driver.findElement(searchButton).click(); }
    public boolean isSearchInUrl(String searchCriteria) { return this.driver.getCurrentUrl().contains("search="+searchCriteria);}
    public boolean isItemOutOfStock(){return driver.findElement(outOfStock).getAttribute("innerHTML").contains(ALERT_DANGER_NOT_IN_STOCK);}
    public void ClickProductSearchElement(By element){ this.driver.findElement(element).click(); }
    public String GetProductPrice(){return driver.findElement(productPrice).getAttribute("innerHTML");}


}
