package tests.YusufDemir;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class US016_Test extends TestBaseRapor {

    PearlyMarketPage pearlyMarket = new PearlyMarketPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Test
    public void TC001() throws InterruptedException  {
        extentTest = extentReports.createTest("TC001", "Kayitli kisilerin isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişleri görülmeli");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("Vendor https://pearlymarket.com/ adresine gider");
        pearlyMarket.signIn.click();
        extentTest.info("Sign in butonuna tıklar");
        pearlyMarket.username.sendKeys("testngteam06@hotmail.com");
        extentTest.info("Vendor geçerli bir email adres girer");
        pearlyMarket.signPass.sendKeys("Batch81");
        extentTest.info("Vendor geçerli bir password girer");
        pearlyMarket.signlog.click();
        extentTest.info("Sing in butonuna tiklanir");
        Thread.sleep(4000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.enAltaInme).perform();
        extentTest.info("Sayfada en alta iner");
        Thread.sleep(1000);
        pearlyMarket.myAccount2.click();
        extentTest.info("My Account butonuna tiklar");
        Thread.sleep(1000);
        pearlyMarket.storeManager.click();
        extentTest.info("Store Manager butonuna tiklanir");
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.customers).click().perform();
        extentTest.info("Customers butonuna tiklar");
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        /* isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişlerin gorunurlugunu dogrulama*/
        for (WebElement w : pearlyMarket.musteriBilgileri) {
            Assert.assertTrue(w.isDisplayed());
            Thread.sleep(500);
        }
        extentTest.info("Kayitli kisileri gordugunu dogrular");
        extentTest.pass("Isim,kullanıcı adi,email adresi, harcama miktarı,son siparişlerin gorunurlugu dogrulandi");
    }

    @Test
    public void TC002() throws InterruptedException {
        // TC002 : Kisilerin tum bilgileri pdf, excel ve csv olarak indirilebilmeli
        PearlyMarketPage pearlyMarket = new PearlyMarketPage();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        extentTest = extentReports.createTest("TC002", "Kisilerin tum bilgileri pdf, excel ve csv olarak indirilebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("Vendor https://pearlymarket.com/ adresine gider");
        pearlyMarket.signIn.click();
        pearlyMarket.username.sendKeys("testngteam06@hotmail.com");
        pearlyMarket.signPass.sendKeys("Batch81");
        pearlyMarket.signlog.click();
        extentTest.info("Vendor login olur");
        Thread.sleep(4000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.enAltaInme).perform();
        Thread.sleep(1000);
        pearlyMarket.myAccount2.click();
        extentTest.info("My Account butonuna tiklar");
        Thread.sleep(1000);
        pearlyMarket.storeManager.click();
        extentTest.info("Store Manager butonuna tiklar");
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.customers).click().perform();
        extentTest.info("Customers butonuna tiklar");
        Thread.sleep(2000);
        /* Pdf,Excel ve Csv indirme seceneklerinin gornurlugunu dogrulama */
        Assert.assertTrue(pearlyMarket.pdfDownload.isDisplayed() &&
                pearlyMarket.excelDownload.isDisplayed() &&
                pearlyMarket.csvDownload.isDisplayed());
        Thread.sleep(2000);
        extentTest.info("Pdf,Excel ve Cvs olarak inderme seceneklerini gordugunu dogrular");
        /* Pdf,Excel ve Csv secenekleri ile indirme islemlerinin aktifligini dogrulama */
        Assert.assertTrue(pearlyMarket.pdfDownload.isEnabled() &&
                pearlyMarket.excelDownload.isEnabled() &&
                pearlyMarket.csvDownload.isEnabled());
        Thread.sleep(2000);
        extentTest.info("Pdf,Excel ve Cvs olarak inderme seceneklerinin erisilebilir oldugunu dogrular");
        /* Pdf,Excel ve Csv indirme islemini dogrulama */
        pearlyMarket.pdfDownload.click();
        pearlyMarket.excelDownload.click();
        pearlyMarket.csvDownload.click();
        Thread.sleep(5000);
        String pdfDosyaYolu = "C:\\Users\\yusuf\\Downloads\\Store Manager - Pearly Market.pdf";
        Assert.assertTrue(Files.exists(Paths.get(pdfDosyaYolu)));
        String excelDosyaYolu = "C:\\Users\\yusuf\\Downloads\\Store Manager - Pearly Market.xlsx";
        Assert.assertTrue(Files.exists(Paths.get(excelDosyaYolu)));
        String cvsDosyaYolu = "C:\\Users\\yusuf\\Downloads\\Store Manager - Pearly Market.csv";
        Assert.assertTrue(Files.exists(Paths.get(cvsDosyaYolu)));
        extentTest.pass("TC002 : Pdf, excel ve csv olarak indirme seceneklerinin aktif oldugu dogrulandi");
    }

    @Test
    public void TC003() throws InterruptedException {
        // TC003 : Yeni kisi eklenebilmeli; kullanıcı adi, email, isim, soyisim
        PearlyMarketPage pearlyMarket = new PearlyMarketPage();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        extentTest = extentReports.createTest("TC003", "Yeni kisi eklenebilmeli; kullanıcı adi, email, isim, soyisim");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("Pearly Market sitesine gidilir");
        pearlyMarket.signIn.click();
        extentTest.info("Anasayfa da Sign in butonuna tiklanir");
        pearlyMarket.username.sendKeys("testngteam06@hotmail.com");
        extentTest.info("Username kismina gecerli email adresi girilir");
        pearlyMarket.signPass.sendKeys("Batch81");
        extentTest.info("Parola kismina gecerli parola girilir");
        pearlyMarket.signlog.click();
        extentTest.info("Sing in butonuna tiklanir");
        Thread.sleep(4000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.enAltaInme).perform();
        extentTest.info("Sayfada en alt kisma gidilir");
        Thread.sleep(1000);
        pearlyMarket.myAccount2.click();
        extentTest.info("My Account butonuna tiklanir");
        Thread.sleep(1000);
        pearlyMarket.storeManager.click();
        extentTest.info("Store Manager butonuna tiklanir");
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.customers).click().perform();
        extentTest.info("Customers butonuna tiklanir");
        Thread.sleep(1000);
        pearlyMarket.addNew.click();
        extentTest.info("AddNew butonuna tiklanir");
        Thread.sleep(1000);
        String emailAdresi = faker.internet().emailAddress();
        pearlyMarket.userNameCustomer.sendKeys(faker.name().username());
        actions.sendKeys(Keys.TAB).sendKeys(emailAdresi).sendKeys(Keys.TAB).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(pearlyMarket.kaydedildiYazisi.isDisplayed());
        Thread.sleep(2000);
        extentTest.pass("TC003 : Kullanıcı adi,email,isim ve soyisim ile Yeni kisi ekleme isleminin yapildigi dogrulandi");

    }

    @AfterMethod
    public void tearDown() {

        ReusableMethods.waitFor(2);
        Driver.closeDriver();

    }
}
