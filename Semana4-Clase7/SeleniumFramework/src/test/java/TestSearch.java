import PageObjects.BaseClass;
import PageObjects.SearchPage;
import dataProviders.SearchProvider;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;


public class TestSearch extends BaseClass {
    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        SearchPage searchPage = new SearchPage(driver);
        int results = Integer.parseInt(expectedResult);
        searchPage.searchByEnter(searchCriteria);

        Assert.assertTrue(searchPage.isSearchInUrl(searchCriteria));
        Assert.assertEquals(searchPage.getSearchIntResults(), results,
                "Expecting " + expectedResult + " results, but got " + searchPage.getSearchIntResults());
    }

    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Test_Empty_Results(@Optional("Star Wars") String searchCriteria, @Optional("0") String expectedResult){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchByEnter(searchCriteria);

        if(searchPage.getSearchIntResults() > 0){
            Assert.assertEquals(searchPage.getSearchIntResults(), expectedResult, "Expecting " + expectedResult + " results, but got " + searchPage.getSearchIntResults());
        }
        else{
            Assert.assertTrue(searchPage.isNoResultsVisible());
        }
    }

    @Test (dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchByClick(testData.getSearchCriteria());

        if(testData.getExpectedResults() > 0){
            Assert.assertEquals(searchPage.getSearchIntResults(), testData.getExpectedResults());
        }
        else{
            Assert.assertTrue(searchPage.isNoResultsVisible());
        }
    }

}
