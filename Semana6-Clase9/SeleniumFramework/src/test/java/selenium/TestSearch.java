package selenium;

import PageObjects.BaseClass;
import PageObjects.SearchResultsPage;
import dataProviders.SearchProvider;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;

public class TestSearch extends BaseClass {

    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        SearchResultsPage searchPage = new SearchResultsPage(driver);
        int results = Integer.parseInt(expectedResult);
        searchPage.searchByEnter(searchCriteria);

        Assert.assertTrue(searchPage.isSearchInUrl(searchCriteria));
        Assert.assertEquals(searchPage.getResultsCount(), results,
                "Expecting " + expectedResult + " results, but got " + searchPage.getResultsCount());
    }

    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Test_Empty_Results(@Optional("Star Wars") String searchCriteria, @Optional("0") String expectedResult){
        SearchResultsPage searchPage = new SearchResultsPage(driver);
        searchPage.searchByEnter(searchCriteria);

        if(searchPage.getResultsCount() > 0){
            Assert.assertEquals(searchPage.getResultsCount(), expectedResult, "Expecting " + expectedResult + " results, but got " + searchPage.getResultsCount());
        }
        else{
            Assert.assertTrue(searchPage.isNoResultsVisible());
        }
    }

    @Test (dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.searchByClick(testData.getSearchCriteria());

        if(testData.getExpectedResults() > 0){
            Assert.assertEquals(searchResultsPage.getResultsCount(), testData.getExpectedResults());
        }
        else{
            Assert.assertTrue(searchResultsPage.isNoResultsVisible());
        }
    }
}
