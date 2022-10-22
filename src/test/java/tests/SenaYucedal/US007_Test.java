package tests.SenaYucedal;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class US007_Test extends TestBaseRapor {


    PearlyMarketPage pearly = new PearlyMarketPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void test001() {

        //TC001

        extentTest= extentReports.createTest("US007","Kullanici valid degerleele giris yapabilmeli ve " +
                "store nanager sayfasina gidebilmeli");
        ReusableMethods.storeManager();
        extentTest.info("Store maneger sayfasina gidildi.");
        pearly.productSena.click();
        extentTest.info("Product a click yapildi");
        pearly.addNewButtonSena.click();
        extentTest.info("Add new butonuna click yapildi");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(pearly.productsBrands.isDisplayed());
        extentTest.info("Product brands kategorisinin gorunurlugu dogrulandi");

        for (WebElement w : pearly.brands) {
            Assert.assertTrue(w.isDisplayed());

        }

    }

    @AfterClass
    public void tearDown() {

        ReusableMethods.waitFor(2);
        Driver.closeDriver();
        extentTest.pass("Sayfa basarili sekilde kapatildi.");
    }
}

