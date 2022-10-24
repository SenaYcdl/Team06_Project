package tests.KenanAgca;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US020_Test extends TestBaseRapor {
   //Kullanici bilgisi, yazmış olduğu comment
   //Verdigi rate ve comment tarihi tanımlanmalı
    PearlyMarketPage pearlyPage= new PearlyMarketPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC_001() {
        ReusableMethods.signIn();
        extentTest = extentReports.createTest("US_020 TC_001", "Kullanici bilgisi, yazmış olduğu comment");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        try {
            pearlyPage.myAccountt.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearlyPage.myAccountt));
            pearlyPage.myAccountt.click();
        }
        pearlyPage.storeManager.click();
        ReusableMethods.waitFor(3);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        try {
            pearlyPage.reviews.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearlyPage.reviews));
            pearlyPage.reviews.click();
        }
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici bilgisi, yazmış olduğu comment");
        extentTest.pass("US_020 TC_001 PASSED");


    }

    @Test
    public void TC_002() {
        extentTest = extentReports.createTest("US_020 TC_002", "Verdigi rate ve comment tarihi tanımlanmalı");
        pearlyPage.productsReview.click();
        ReusableMethods.waitForVisibility(pearlyPage.productsReviewResult,5);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(pearlyPage.productsReviewResult.isDisplayed());
        Assert.assertTrue(pearlyPage.reviewTable.isDisplayed());
        extentTest.info(" Verdigi rate ve comment tarihi tanımlanmalı");
        extentTest.pass("US_020 TC_002 PASSED");
    }
}
