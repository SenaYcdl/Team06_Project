package tests.ZeynepSarikaya;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US013_Test extends TestBaseRapor {
    //Store manager olarak, kuponları olusturabilmeliyim
    //Coupon kodu verilmeli
    //Tanimlama yazılmalı
    //Indirim sekli / discount
    //Coupon amount
    //Coupon expiry date / urun kuponu son kullanım tarihi girilmeli
    //Free shipping uygulanmalı
    //Show on store

    PearlyMarketPage pearlyPage = new PearlyMarketPage();
    JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC_01234567() {
        ReusableMethods.signIn();
        extentTest=extentReports.createTest( "US_013 TC_001-2-3-4-5-6-7","//Coupon kodu verilmeli\n" +
                "    //Tanimlama yazılmalı\n" +
                "    //Indirim sekli / discount\n" +
                "    //Coupon amount\n" +
                "    //Coupon expiry date / urun kuponu son kullanım tarihi girilmeli\n" +
                "    //Free shipping uygulanmalı\n" +
                "    //Show on store");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        try {
            pearlyPage.myAccount.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearlyPage.myAccount));
            pearlyPage.myAccount.click();
        }
        pearlyPage.storeManager.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).moveToElement(pearlyPage.coupons).build().perform();
        try {
            pearlyPage.coupons.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearlyPage.coupons));
            pearlyPage.coupons.click();
        }

        pearlyPage.couponAddNew.click();
        ReusableMethods.waitFor(3);
        pearlyPage.code.sendKeys("12345");
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys("just for gift").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).
                sendKeys("20").sendKeys(Keys.TAB).sendKeys("2023-05-12").sendKeys(Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        ReusableMethods.getActions().moveToElement(pearlyPage.freeShipping).click().sendKeys(Keys.TAB).
                moveToElement(pearlyPage.showOnStore).click().perform();
        ReusableMethods.waitFor(3);
        extentTest.info(" //Coupon kodu verilmeli\n" +
                "    //Tanimlama yazılmalı\n" +
                "    //Indirim sekli / discount\n" +
                "    //Coupon amount\n" +
                "    //Coupon expiry date / urun kuponu son kullanım tarihi girilmeli\n" +
                "    //Free shipping uygulanmalı\n" +
                "    //Show on store girisleri yapıldı");

        extentTest.pass("US_013 TC_001-2-3-4-5-6-7 PASSED");


        Driver.quitDriver();
    }













}
