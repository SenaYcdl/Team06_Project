package tests.MehmetDuman;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class US021_Test {
    PearlyMarketPage pearly = new PearlyMarketPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US021_TC01() {
        ReusableMethods.storeManager();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        pearly.reportsButton.click();

        Assert.assertTrue(pearly.yearReportButton.isDisplayed());
        Assert.assertTrue(pearly.lastmonthReportButton.isDisplayed());
        Assert.assertTrue(pearly.thismonthReportButton.isDisplayed());
        Assert.assertTrue(pearly.last7daysReportButton.isDisplayed());

    }

    @Test
    public void US021_TC02() {
        ReusableMethods.waitFor(2);
        ReusableMethods.storeManager();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        pearly.reportsButton.click();
        Assert.assertTrue(pearly.choosedateReportButton.isDisplayed());
        pearly.choosedateReportButton.click();
        pearly.choosedateReportButton.sendKeys("2022-10-10 to 2022-10-20");
        Assert.assertTrue(pearly.choosedateReportTable.isDisplayed());

    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}
