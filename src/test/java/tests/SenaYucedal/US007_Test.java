package tests.SenaYucedal;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;



public class US007_Test  {


    PearlyMarketPage pearly = new PearlyMarketPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void test001() {

        //TC001


        ReusableMethods.storeManager();
        pearly.productSena.click();
        pearly.addNewButtonSena.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(pearly.productsBrands.isDisplayed());

        for (WebElement w : pearly.brands) {
            Assert.assertTrue(w.isDisplayed());

        }

    }

    @AfterClass
    public void tearDown() {

        ReusableMethods.waitFor(2);
        Driver.closeDriver();

    }
}

