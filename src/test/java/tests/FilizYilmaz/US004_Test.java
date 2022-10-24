package tests.FilizYilmaz;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class US004_Test {

    PearlyMarketPage pearly = new PearlyMarketPage();

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC00() {


        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        pearly.signIn.click();
        ReusableMethods.waitFor(5);

        pearly.username.sendKeys("testngteam06@hotmail.com");
        pearly.signPass.sendKeys("Batch81");
        ReusableMethods.waitFor(2);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        try {
            pearly.signlog.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearly.signlog));
            pearly.signlog.click();

        }

        ReusableMethods.waitFor(3);

        WebElement sepet = Driver.getDriver().findElement(By.xpath("//a[@class='cart-toggle']//i[@class='w-icon-cart']"));
        js.executeScript("arguments[0].click();", sepet);
        WebElement viewcart = Driver.getDriver().findElement(By.xpath("(//a[normalize-space()='View cart'])[1]"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", viewcart);
        js.executeScript("arguments[0].click();", viewcart);
        ReusableMethods.waitFor(5);

    }


    @Test
    public void TC001() {


        //Rakam, miktar ve toplam olarak görülmeli
        WebElement price = Driver.getDriver().findElement(By.xpath("//th[@class='product-price']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement quantity = Driver.getDriver().findElement(By.xpath("//th[@class='product-quantity']"));
        Assert.assertTrue(quantity.isDisplayed());
        WebElement total = Driver.getDriver().findElement(By.xpath("//th[@class='product-subtotal']"));
        Assert.assertTrue(total.isDisplayed());

    }

    @Test
    public void TC002() {

        //Arti ile urun rakami artirilabilmeli ve eksi ile rakamlar dusurulebilmeli
        WebElement plus = Driver.getDriver().findElement(By.xpath("(//button[@title='Plus'])[1]"));
        js.executeScript("arguments[0].click();", plus);
        Assert.assertTrue(plus.isEnabled());
        WebElement minus = Driver.getDriver().findElement(By.xpath("(//button[@title='Minus'])[1]"));
        Assert.assertTrue(minus.isSelected());

        String urunSayisi = Driver.getDriver().findElement(By.xpath("//input[@type='number']")).getText();
        int urunAdedi = Integer.parseInt(urunSayisi);
        Assert.assertTrue(Boolean.parseBoolean(urunSayisi + 1));
        js.executeScript("arguments[0].click();", minus);
        Assert.assertTrue(Boolean.parseBoolean(String.valueOf(urunAdedi - 1)));

    }

    @Test
    public void TC003() throws InterruptedException {

        //Clear cart ile rakamlar silinebilmeli
        WebElement updatecartt = Driver.getDriver().findElement(By.xpath("//button[@name='update_cart']"));
        js.executeScript("arguments[0].click();", updatecartt);
        WebElement alert = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Driver.getDriver().switchTo().alert().getText();
        Assert.assertTrue(alert.isDisplayed());
        WebElement clear = Driver.getDriver().findElement(By.xpath("//button[@name='clear_cart']"));
        js.executeScript("arguments[0].click();", clear);
        Thread.sleep(4000);
        WebElement empty = Driver.getDriver().findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"));
        Assert.assertTrue(empty.isDisplayed());
    }

    @Test
    public void TC004() {


        //Stok fazlası urun eklenememeli ve Update cart ile rakam ortalamaları güncellenmeli
        //Coupon secenegi olmali

        List<WebElement> urunlerList = Driver.getDriver().findElements(By.xpath("(//*[@class='product-wrap'])"));
        int urunSayisi = urunlerList.size();
        int urunAdedi = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//*[@class='cart-count']")).getText());

        while (urunAdedi <= 5) {
            Random rastgele = new Random();
            int kacinciUrun = rastgele.nextInt(urunSayisi);
            String urn = "(//*[@class='product-wrap'])" + "[" + kacinciUrun + "]";
            System.out.println(urn);
            WebElement urnElemnt = Driver.getDriver().findElement(By.xpath("(//*[@class='product-wrap'])" + "[" + kacinciUrun + "]/div"));
            js.executeScript("arguments[0].click();", urnElemnt);
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", urnElemnt);
            executor.executeScript("arguments[0].click();", urnElemnt);
            urnElemnt.click();
            ReusableMethods.waitFor(5);
            if (pearly.sepeteEkleButton.isDisplayed()) {
                pearly.sepeteEkleButton.click();
                urunlerList.add(urnElemnt);
            }
            Driver.getDriver().navigate().back();
        }
        pearly.sepetim.click();
        pearly.sepetiGoruntule.click();
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        WebElement coupon = Driver.getDriver().findElement(By.xpath("//button[@name='apply_coupon']"));
        Assert.assertTrue(coupon.isDisplayed());
        coupon.sendKeys("1234");
        js.executeScript("arguments[0].click();", coupon);
    }

    @Test
    public void TC005() {

        //Tekrar shopping devam etme butonu olmalı

        ReusableMethods.waitFor(2);
        WebElement continueshopping = Driver.getDriver().findElement(By.xpath("(//a[normalize-space()='Continue Shopping'])[1]"));
        js.executeScript("arguments[0].click();", continueshopping);

    }

    @Test
    public void TC006() {

        //Shipping bilgileri sag tarafta görülmelive toplam rakam sagda populate etmeli
        //Proceed to checkout Miami basarili bir sekilde ödeneklere yönlendirmeli
        ReusableMethods.waitFor(5);
        Assert.assertTrue(pearly.shippingg.isDisplayed());
        Assert.assertTrue(pearly.subTotal.isDisplayed());
    }

    @Test
    public void TC007() {


        ReusableMethods.waitFor(2);
        Assert.assertTrue(pearly.billingDetails.isDisplayed());

    }
}
