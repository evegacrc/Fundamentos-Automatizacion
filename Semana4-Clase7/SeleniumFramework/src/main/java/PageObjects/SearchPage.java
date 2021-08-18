package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BaseClass {

   // private WebDriver driver;
    //Elementos
    private static final String ERROR_MESSAGE_NO_RESULTS_DISPLAYED = "There is no product that matches the search criteria.";
    private By searchInput = By.name("search");
    private By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    private By productThumb = By.cssSelector(".product-thumb");
    private By noResultsSelector = By.id("content");

    public SearchPage(WebDriver _driver){ super.driver = _driver; }

    public void searchByEnter(String searchCriteria){ driver.findElement(searchInput).sendKeys(searchCriteria, Keys.ENTER);}
    public void searchByClick(String searchCriteria){ this.driver.findElement(searchInput).sendKeys(searchCriteria); this.driver.findElement(searchButton).click(); }
    public int getSearchIntResults(){ return this.driver.findElements(productThumb).size();}
    public boolean isNoResultsVisible(){return driver.findElement(noResultsSelector).getAttribute("innerHTML").contains(ERROR_MESSAGE_NO_RESULTS_DISPLAYED);}
    public boolean isSearchInUrl(String searchCriteria) { return this.driver.getCurrentUrl().contains("search="+searchCriteria);}

}
