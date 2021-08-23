package selenium;

import PageObjects.BaseClass;
import dataProviders.ProductProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ProductsData;
import java.util.Hashtable;
import java.util.Map;


public class TestProductsPrice extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test (dataProvider = "getProductsDataFromJson", dataProviderClass = ProductProvider.class)
    public void Test_Products_Price(ProductsData testDataProducts){
        Hashtable<String, String> ht = new Hashtable<>();
        ht.put("usd",testDataProducts.getUsdPrice());
        ht.put("eur",testDataProducts.getEurPrice());
        ht.put("pound",testDataProducts.getPoundPrice());
        searchResultsPage().searchByClick(testDataProducts.getProduct());
        searchResultsPage().ClickProductSearchElement(By.linkText(testDataProducts.getProduct()));

        for (Map.Entry<String, String> e : ht.entrySet()) {
            headerPage().clickOnCurrency(e.getKey());
            String actualPrice = searchResultsPage().GetProductPrice();
            Assert.assertEquals(actualPrice,e.getValue());
        }
    }
}
