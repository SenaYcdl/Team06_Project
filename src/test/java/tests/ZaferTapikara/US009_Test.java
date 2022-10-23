package tests.ZaferTapikara;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

    @Test
    public void US009_TC001()  {
        //Urun kilosu belirlenebilmeli
        //Kullanici https://pearlymarket.com/ adresine gider
        //sign in butonuna tiklar
        //geçerli bir email adres girer
        //geçerli bir password girer
        //login butonuna tiklar
        //Footer’daki(sayfanin en altindaki) "My Account" linkine tiklar
        //"Store Manager" sekmesine tiklar
        //products sekmesine tiklar
        //ürünler listesindeki "Hope Cup" ürününün ismine tiklar
        //Sayfasinin altindaki shipping sekmesine tiklar
        //ürünün kilosunu 0.3 kg olarak girer
        //submit butonuna tiklar
        //Sayfasinin altindaki shipping sekmesine tiklar
        //ürünün kg degerinin 0.3 oldugunu dogrular

        pearly = new PearlyMarketPage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        pearly.signIn.click();
        pearly.username.sendKeys("testngteam06@hotmail.com");
        pearly.signPass.sendKeys("Batch81");
        pearly.signlog.click();
        ReusableMethods.waitForVisibility(pearly.signout, 10);
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitForVisibility(pearly.myaccount, 10);                     // My account linki gorunene kadar bekler
        pearly.myaccount.sendKeys(Keys.ENTER);                                       // My account linkine tiklar
        ReusableMethods.waitForVisibility(pearly.storemanager, 10);                  // Store manager linki gorunene kadar bekler
        pearly.storemanager.click();                                                 // Store manager linkine tiklar
        ReusableMethods.waitForVisibility(pearly.productsSekme, 10);                     // Products linki gorunene kadar bekler
        pearly.productsSekme.click();                                                    // Products linkine tiklar
        ReusableMethods.waitFor(6);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();        //sayfayi asagi kaydirir
        pearly.hopeCup.sendKeys(Keys.ENTER);                                         //Hope Cup urunune tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pearly.shipping.click();                                                      //shipping sekmesine tiklar
        pearly.weight.clear();                                                         // weight kisminda bir deger varsa temizler
        pearly.weight.sendKeys("0.3");                                     //weight degerini girer
        pearly.submit.sendKeys(Keys.ENTER);                                            // submit butonuna tiklar
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pearly.shipping.click();
        Assert.assertEquals(pearly.weight.getAttribute("value"), "0.3");
        ReusableMethods.waitFor(3);
        Driver.closeDriver();//weight degerini dogrular
    }

    @Test
    public void US009_TC002() {
        //Urun olculeri belirlenebilmeli
        //Kullanici https://pearlymarket.com/ adresine gider
        //sign in butonuna tiklar
        //geçerli bir email adres girer
        //geçerli bir password girer
        //login butonuna tiklar
        //Footer’daki(sayfanin en altindaki) "My Account" linkine tiklar
        //"Store Manager" sekmesine tiklar
        //products sekmesine tiklar
        //ürünler listesindeki "Hope Cup" ürününün ismine tiklar
        //Sayfasinin altindaki shipping sekmesine tiklar
        //urunun uzunluk, genislik ve yukseklik olculerini 10, 5 ve 15 cm girer.
        //submit butonuna tiklar
        //Sayfasinin altindaki shipping sekmesine tiklar
        //yazilan olculerin 10,5 ve 15 cm oldugunu dogrular

        pearly = new PearlyMarketPage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        pearly.signIn.click();
        pearly.username.sendKeys("testngteam06@hotmail.com");
        pearly.signPass.sendKeys("Batch81");
        pearly.signlog.click();
        ReusableMethods.waitForVisibility(pearly.signout, 10);
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitForVisibility(pearly.myaccount, 10);
        // My account linki gorunene kadar bekler
        pearly.myaccount.sendKeys(Keys.ENTER);
        // My account linkine tiklar
        ReusableMethods.waitForVisibility(pearly.storemanager, 10);
        // Store manager linki gorunene kadar bekler
        pearly.storemanager.click();
        // Store manager linkine tiklar
        ReusableMethods.waitForVisibility(pearly.productsSekme, 10);
        // Products linki gorunene kadar bekler
        pearly.productsSekme.click();
        // Products linkine tiklar
        ReusableMethods.waitForVisibility(pearly.productsWait, 10);
        // Product sayfasi acilana kadar bekler
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //sayfayi asagi kaydirir
        ReusableMethods.waitForVisibility(pearly.hopeCup, 10);
        pearly.hopeCup.sendKeys(Keys.ENTER);
        //Hope Cup urunune tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pearly.shipping.click();
        //shipping sekmesine tiklar
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
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pearly.shipping.click();
        Assert.assertEquals(pearly.length.getAttribute("value"), "10");
        Assert.assertEquals(pearly.width.getAttribute("value"), "5");
        Assert.assertEquals(pearly.height.getAttribute("value"), "15");
        //degerlerin dogrulugunu kontrol eder
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
