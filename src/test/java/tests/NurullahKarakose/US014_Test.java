package tests.NurullahKarakose;


import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US014_Test {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    PearlyMarketPage page = new PearlyMarketPage();
    Faker faker = new Faker();

    @Test
    public void US014_TC001() throws InterruptedException {

        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        page.codeBox.sendKeys(faker.phoneNumber().phoneNumber());
        page.descriptionBox.sendKeys(faker.name().name());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.minimumSpendBox.sendKeys("5");
        ReusableMethods.waitFor(5);
        Driver.closeDriver();

    }


    @Test
    public void US014_TC002() throws InterruptedException {
        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        page.codeBox.sendKeys(faker.phoneNumber().phoneNumber());
        page.descriptionBox.sendKeys(faker.name().name());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.maximumSpendBox.sendKeys("1000", Keys.TAB);
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

    @Test
    public void US014_TC003() throws InterruptedException {

        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(page.individualUseOnlyCheckBox.isEnabled());
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

    @Test
    public void US014_TC004() throws InterruptedException {

        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(page.excludeSaleItemsBox).click().perform();
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

    @Test
    public void US014_TC005() throws InterruptedException {

        ReusableMethods.storeManager();
        Thread.sleep(4000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(page.couponsButton).perform();
        actions.click(page.addNewButton).perform();
        Thread.sleep(4000);
        page.codeBox.sendKeys(faker.phoneNumber().phoneNumber());
        page.descriptionBox.sendKeys(faker.name().name());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.minimumSpendBox.sendKeys("5");
        page.maximumSpendBox.sendKeys("1000",Keys.TAB);
        Assert.assertTrue(page.individualUseOnlyCheckBox.isEnabled());
        Thread.sleep(1000);
        actions.moveToElement(page.excludeSaleItemsBox).click().perform();
        Thread.sleep(2000);
        actions.click(page.excludeCategoriesBox).perform();
        Thread.sleep(3000);
        actions.sendKeys("For").perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER).sendKeys("Women").perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(page.succesfullyMessage.isDisplayed());
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}

