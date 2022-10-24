package tests.ZaferTapikara;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.*;

import java.time.Duration;

public class US009_Test  {
    PearlyMarketPage pearly;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor js;

    @Test
    public void US009_TC001()  {
        //Urun kilosu belirlenebilmeli
        js = (JavascriptExecutor) Driver.getDriver();
        pearly = new PearlyMarketPage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        actions = new Actions(Driver.getDriver());
        //Kullanici https://pearlymarket.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //sign in butonuna tiklar
        pearly.signIn.click();
        //geçerli bir email adres girer
        pearly.username.sendKeys("testngteam06@hotmail.com");
        //geçerli bir password girer
        pearly.signPass.sendKeys("Batch81");
        //login butonuna tiklar
        pearly.signlog.click();
        ReusableMethods.waitForVisibility(pearly.signout, 10);
        //sayfanin en altina iner
        actions.sendKeys(Keys.END).perform();
        // My account linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.myaccount, 10);
        //Footer’daki(sayfanin en altindaki) "My Account" linkine tiklar
        pearly.myaccount.sendKeys(Keys.ENTER);
        // Store manager linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.storemanager, 10);
        //"Store Manager" sekmesine tiklar
        pearly.storemanager.click();
        // Products linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.productsSekme, 10);
        //products sekmesine tiklar
        pearly.productsSekme.click();
        // Product sayfasi acilana kadar bekler
        ReusableMethods.waitFor(5);
        //ürünler listesindeki "Hope Cup" ürününün ismine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);

        js.executeScript("arguments[0].click()", pearly.hopeCup);
        ReusableMethods.waitFor(2);
        //Sayfasinin altindaki shipping sekmesine tiklar
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.shipping);
        js.executeScript("arguments[0].click()", pearly.shipping);
        pearly.weight.clear();
        pearly.weight.sendKeys("0.3");
        pearly.submit.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pearly.shipping.click();
        Assert.assertEquals(pearly.weight.getAttribute("value"), "0.3");
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }

    @Test
    public void US009_TC002() {
        //Urun olculeri belirlenebilmeli
        js = (JavascriptExecutor) Driver.getDriver();
        pearly = new PearlyMarketPage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        actions = new Actions(Driver.getDriver());
        //Kullanici https://pearlymarket.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //sign in butonuna tiklar
        pearly.signIn.click();
        //geçerli bir email adres girer
        pearly.username.sendKeys("testngteam06@hotmail.com");
        //geçerli bir password girer
        pearly.signPass.sendKeys("Batch81");
        //login butonuna tiklar
        pearly.signlog.click();
        ReusableMethods.waitForVisibility(pearly.signout, 10);
        //sayfanin en altina iner
        actions.sendKeys(Keys.END).perform();
        // My account linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.myaccount, 10);
        //Footer’daki(sayfanin en altindaki) "My Account" linkine tiklar
        pearly.myaccount.sendKeys(Keys.ENTER);
        // Store manager linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.storemanager, 10);
        //"Store Manager" sekmesine tiklar.
        pearly.storemanager.click();
        // Products linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.productsSekme, 10);
        //products sekmesine tiklar
        pearly.productsSekme.click();
        // Product sayfasi acilana kadar bekler
        ReusableMethods.waitFor(5);
        //ürünler listesindeki "Hope Cup" ürününün ismine tiklar
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.hopeCup);
        js.executeScript("arguments[0].click()", pearly.hopeCup);
        ReusableMethods.waitFor(2);
        //Sayfasinin altindaki shipping sekmesine tiklar
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.shipping);
        js.executeScript("arguments[0].click()", pearly.shipping);
        pearly.length.clear();
        //length kisminindaki degeri temizler
        pearly.length.sendKeys("10");
        //length degerini 10 olarak girer
        pearly.width.clear();
        pearly.width.sendKeys("5");
        pearly.height.clear();
        pearly.height.sendKeys("15");
        pearly.submit.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.shipping);
        js.executeScript("arguments[0].click()", pearly.shipping);
        Assert.assertEquals(pearly.length.getAttribute("value"), "10");
        Assert.assertEquals(pearly.width.getAttribute("value"), "5");
        Assert.assertEquals(pearly.height.getAttribute("value"), "15");
        //degerlerin dogrulugunu kontrol eder
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }

    @Test
    public void US009_TC003() {
        // islem suresi belirlenebilmeli
        js = (JavascriptExecutor) Driver.getDriver();
        pearly = new PearlyMarketPage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        actions = new Actions(Driver.getDriver());
        //Kullanici https://pearlymarket.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.waitFor(2);
        //sign in butonuna tiklar
        pearly.signIn.click();
        //geçerli bir email adres girer
        pearly.username.sendKeys("testngteam06@hotmail.com");
        //geçerli bir password girer
        pearly.signPass.sendKeys("Batch81");
        //login butonuna tiklar
        pearly.signlog.click();
        ReusableMethods.waitForVisibility(pearly.signout, 10);
        //sayfanin en altina iner
        actions.sendKeys(Keys.END).perform();
        // My account linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.myaccount, 10);
        //Footer’daki(sayfanin en altindaki) "My Account" linkine tiklar
        pearly.myaccount.sendKeys(Keys.ENTER);
        // Store manager linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.storemanager, 10);
        //"Store Manager" sekmesine tiklar
        pearly.storemanager.click();
        // Products linki gorunene kadar bekler
        ReusableMethods.waitForVisibility(pearly.productsSekme, 10);
        //products sekmesine tiklar
        pearly.productsSekme.click();
        // Product sayfasi acilana kadar bekler
        ReusableMethods.waitFor(5);
        //ürünler listesindeki "Hope Cup" ürününün ismine tiklar
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.hopeCup);
        js.executeScript("arguments[0].click()", pearly.hopeCup);
        ReusableMethods.waitFor(2);
        //Sayfasinin altindaki shipping sekmesine tiklar
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.shipping);
        js.executeScript("arguments[0].click()", pearly.shipping);
        //proccessing time zamanini 3-5 business day olarak secer
        Select select = new Select(pearly.processingTimeDDM);
        select.selectByIndex(4);
        //submit butonuna tiklar
        pearly.submit.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.shipping);
        js.executeScript("arguments[0].click()", pearly.shipping);
        //görünen islem süresinin 3-5 business day oldugunu dogrular
        String expectedResult= "3-5 business days";
       String actualResult= select.getFirstSelectedOption().getText();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult);

    }
}
