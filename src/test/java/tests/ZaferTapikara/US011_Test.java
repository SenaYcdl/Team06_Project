package tests.ZaferTapikara;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US011_Test {
    PearlyMarketPage pearly;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor js;
    @Test
    public void US011_TC001() {
        //toptan urun gosterme sekmesinde parca turleri piece, carton ve kg olmali
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
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.hopeCup);
        js.executeScript("arguments[0].click()", pearly.hopeCup);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.toptanUrunGostermeAyarlari);
        js.executeScript("arguments[0].click()", pearly.toptanUrunGostermeAyarlari);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(pearly.pieceOption.getText(), "Piece");
        Assert.assertEquals(pearly.cartonOption.getText(), "Carton");
        Assert.assertEquals(pearly.kgOption.getText(), "Kg");
        Driver.quitDriver();

    }

    @Test
    public void US011_TC002() {
        //Units per piece kisminda sayi belirtebilmeli
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
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.hopeCup);
        js.executeScript("arguments[0].click()", pearly.hopeCup);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.toptanUrunGostermeAyarlari);
        js.executeScript("arguments[0].click()", pearly.toptanUrunGostermeAyarlari);
        ReusableMethods.waitFor(1);
        pearly.unitPerPiece.clear();
        pearly.unitPerPiece.sendKeys("10");
        pearly.submit.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()", pearly.toptanUrunGostermeAyarlari);
        Assert.assertEquals(pearly.unitPerPiece.getAttribute("value"), "10");
        ReusableMethods.waitFor(3);
        Driver.quitDriver();
    }

    @Test
    public void US011_TC003() {
        //Minimum order quantity miktari belirtilmeli
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
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.hopeCup);
        js.executeScript("arguments[0].click()", pearly.hopeCup);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.toptanUrunGostermeAyarlari);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()", pearly.toptanUrunGostermeAyarlari);
        ReusableMethods.waitFor(1);
        pearly.minOrderQuantity.clear();
        pearly.minOrderQuantity.sendKeys("50");
        pearly.submit.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.toptanUrunGostermeAyarlari);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()", pearly.toptanUrunGostermeAyarlari);
        Assert.assertEquals(pearly.minOrderQuantity.getAttribute("value"), "50");
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}
