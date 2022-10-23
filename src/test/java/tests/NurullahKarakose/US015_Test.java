package tests.NurullahKarakose;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US015_Test {

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    PearlyMarketPage page = new PearlyMarketPage();
    Faker faker = new Faker();

    @Test
    public void US015_TC001() throws InterruptedException {

        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.click(page.limitButton).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(page.usageLimitText.isDisplayed());
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

    @Test
    public void US015_TC002() throws InterruptedException {

        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.click(page.limitButton).perform();
        ReusableMethods.waitFor(2);
        page.usageLimitBox.sendKeys("5");
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

    @Test
    public void US015_TC003() throws InterruptedException {

        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.click(page.limitButton).perform();
        ReusableMethods.waitFor(2);
        page.userLimitBox.sendKeys("5");
        ReusableMethods.waitFor(5);
        Driver.closeDriver();

    }
}
