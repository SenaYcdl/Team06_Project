package tests.ZeynepSarikaya;

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

public class US012_Test extends TestBaseRapor {
    //Siparisler olmali ve sipariş edilen ürünler sıralanmalı
    //Indirimler; eğer indirimler ürünler tanimlanmissa, indirimli ürünleri listeli görebilmeliyim
    //Adresler ; Daha once girilen fatura adresi ve gönderim adresi listelenmeli
    //Hesap detaylari; hesap bilgisi ve eposta adresi goruntulenmeli ve update edilebilir olmalı

    PearlyMarketPage pearlyPage = new PearlyMarketPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC_001() throws InterruptedException {

        ReusableMethods.signIn();
        //Siparisler olmali ve sipariş edilen ürünler sıralanmalı
        extentTest = extentReports.createTest("US_012 TC_001", "Siparisler olmali ve sipariş edilen ürünler sıralanmalı");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //sayfanın en altına kaydırır
        //ReusableMethods.getActions().moveToElement(pearlyPage.myAccount).perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        try {
            pearlyPage.myAccountt.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearlyPage.myAccountt));
            pearlyPage.myAccountt.click();
        }
        pearlyPage.storeManager.click();
        pearlyPage.orderss.click();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.waitFor(10);
        Assert.assertTrue(pearlyPage.resultOrders.isDisplayed());
        extentTest.info("Siparisler ve sipariş edilen ürünlerin sıralandıgı test edildi ");
        extentTest.pass("US_012 TC_001 PASSED");

    }

    @Test
    public void TC_002() {
        //Indirimler; eğer indirimler ürünler tanimlanmissa, indirimli ürünleri listeli görebilmeliyim
        extentTest=extentReports.createTest( "US_012 TC_002","Indirimler; eğer indirimler ürünler tanimlanmissa, indirimli ürünleri listeli görebilmeliyim");
        //js.executeScript("window.scrollBy(0,-250)");
        ReusableMethods.getActions().sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(3);
        pearlyPage.products.click();

        Assert.assertTrue(pearlyPage.discount.isDisplayed());
        extentTest.info("Indirimler; eğer indirimler ürünler tanimlanmissa, indirimli ürünleri listeli görüldü ");
        extentTest.pass("US_012 TC_002 PASSED");
    }

    @Test
    public void TC_003() {
        //Adresler ; Daha once girilen fatura adresi ve gönderim adresi listelenmeli
        extentTest=extentReports.createTest( "US_012 TC_003","Adresler ; Daha once girilen fatura adresi ve gönderim adresi listelenmeli");

        Driver.getDriver().navigate().back();
        Assert.assertTrue(pearlyPage.billingAddress.isDisplayed());
        Assert.assertTrue(pearlyPage.shippingAddress.isDisplayed());
        extentTest.info("Adresler ; Daha once girilen fatura adresi ve gönderim adresi listelendigi gmrüldü");
        extentTest.pass("US_012 TC_003 PASSED");

    }

    @Test
    public void TC_004() {
        //Hesap detaylari; hesap bilgisi ve eposta adresi goruntulenmeli ve update edilebilir olmalı
        extentTest=extentReports.createTest( "US_012 TC_003","Hesap detaylari; hesap bilgisi ve eposta adresi goruntulenmeli ve update edilebilir olmalı");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        try {
            pearlyPage.myAccountt.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearlyPage.myAccountt));
            pearlyPage.myAccountt.click();
        }

        pearlyPage.accountDetails.click();

        Assert.assertTrue(pearlyPage.firstNamee.isDisplayed()&&pearlyPage.lastName.isDisplayed()&&
                pearlyPage.displayName.isDisplayed()&&pearlyPage.accountDetailsEmail.isDisplayed()&&
                pearlyPage.saveChanges.isDisplayed());
        extentTest.info("Hesap detaylari; hesap bilgisi ve eposta adresi goruntulenmeli ve update edilebilir oldugu test edildi");
        extentTest.pass("US_012 TC_004 PASSED");

        Driver.closeDriver();
    }









}
