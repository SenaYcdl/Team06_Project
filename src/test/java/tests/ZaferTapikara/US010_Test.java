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
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US010_Test {
    PearlyMarketPage pearly;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void US010_TC001() {
        //Renk secenegi;blue, brown, green ve gray renkleri belirtilmeli
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
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.attributes);
        js.executeScript("arguments[0].click()", pearly.attributes);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()", pearly.colorCheckBox);
        ReusableMethods.waitFor(1);
        pearly.selectAll.click();
        ReusableMethods.waitFor(1);
       List<WebElement> colorDropDown= Driver.getDriver().findElements(By.xpath("//li[@class='select2-selection__choice']"));
       List<String> expectedList = new ArrayList<>();
       expectedList.add("Blue");
       expectedList.add("Brown");
       expectedList.add("Green");
       expectedList.add("Gray");
       List<String> actualList = new ArrayList<>();
        for (WebElement webElement : colorDropDown) {
            actualList.add(webElement.getAttribute("title"));
        }
        for (String color : expectedList) {
            Assert.assertTrue(actualList.contains(color));
        }
        Driver.closeDriver();
    }


    @Test
    public void US010_TC002() {
        //Size secenegi; small, medium, large, extra large olmali
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
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.attributes);
        js.executeScript("arguments[0].click()", pearly.attributes);
        ReusableMethods.waitFor(1);
        pearly.sizeCheckBox.click();
        ReusableMethods.waitFor(1);
        js.executeScript("arguments[0].click()", pearly.sizeSelectAll);
        ReusableMethods.waitFor(1);
        List<WebElement> sizeDropDown =Driver.getDriver().findElements(By.xpath("//li[@class='select2-selection__choice']"));
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Small");
        expectedList.add("Medium");
        expectedList.add("Large");
        expectedList.add("Extra Large");
        List<String> actualList = new ArrayList<>();
        for (WebElement element : sizeDropDown
             ) {
            actualList.add(element.getAttribute("title"));
        }
        for (String size : actualList
             ) {
            Assert.assertTrue(actualList.contains(size));
        }

    }
}
