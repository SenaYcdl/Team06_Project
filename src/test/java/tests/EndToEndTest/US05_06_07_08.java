package tests.EndToEndTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class US05_06_07_08 extends TestBaseRapor {

    PearlyMarketPage pearly = new PearlyMarketPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC00() {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        pearly.signIn.click();
        ReusableMethods.waitFor(5);


        pearly.username.sendKeys("testngteam06@hotmail.com");
        pearly.signPass.sendKeys("Batch81");
        // pearly.username.sendKeys(ConfigReader.getProperty("pearlyEmail"));
        // pearly.signPass.sendKeys(ConfigReader.getProperty("pearlyPassword"));

        ReusableMethods.waitFor(3);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        try {
            pearly.signlog.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(pearly.signlog));
            pearly.signlog.click();

        }

        ReusableMethods.waitFor(3);


        //ReusableMethods.getActions().scrollToElement(pearly.myaccount).perform();
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", pearly.myaccount);
    }

    @Test
    public void TC01() {

        extentTest = extentReports.createTest("US_005 TC01", "Productsta urun listesi, status, stock, price, date gorulmeli");

        //Productsta urun listemi görmeliyim; status, stock, price, date

        pearly.storemanager.click();
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        pearly.productsnida.click();
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        ReusableMethods.getSoftAssert().assertTrue(pearly.status.isDisplayed());
        ReusableMethods.getSoftAssert().assertTrue(pearly.stock.isDisplayed());
        ReusableMethods.getSoftAssert().assertTrue(pearly.price.isDisplayed());
        ReusableMethods.getSoftAssert().assertTrue(pearly.date.isDisplayed());
        ReusableMethods.waitFor(3);

        extentTest.info("User products, status, stock, price, date gordu ");
        extentTest.pass("US_005 TC01 PASSED");


    }

    @Test
    public void TC02() {

        //Yeni urun ekle (Add new); urun icin virtual veya downloadable secenegi olmali

        extentTest = extentReports.createTest("US_005 TC01", "Yeni urun ekle (Add new); urun icin virtual veya downloadable secenegi olmali");
        js.executeScript("arguments[0].click();", pearly.addnew);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.getSoftAssert().assertTrue(pearly.virtual.isDisplayed());
        ReusableMethods.getSoftAssert().assertTrue(pearly.downloadable.isDisplayed());
        extentTest.info("Yeni urun ekle (Add new); urun icin virtual veya downloadable secenegi goruldu");
        extentTest.pass("US_005 TC02 PASSED");

    }

    @Test
    public void TC03() {

        //Urun eklerken product title ve satis miktari bilgileri girilebilmeli

        extentTest = extentReports.createTest("US_005 TC03", "Urun eklerken product title ve satis miktari bilgileri girilebilmeli");
        js.executeScript("arguments[0].click();", pearly.addnew);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.getSoftAssert().assertTrue(pearly.productTitle.isDisplayed());
        ReusableMethods.getSoftAssert().assertTrue(pearly.prices.isDisplayed());
        ReusableMethods.getSoftAssert().assertTrue(pearly.salesPrice.isDisplayed());

        ReusableMethods.getActions().click(pearly.productTitle).sendKeys("Long Dress").sendKeys(Keys.TAB).
                sendKeys("400").sendKeys(Keys.TAB).sendKeys("250").perform();
        ReusableMethods.getSoftAssert().assertTrue(pearly.dress.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.info("User product title ve satis miktari girebildi");
        extentTest.pass("US_005 TC03 PASSED");

    }

    @Test
    public void TC04() throws InterruptedException, AWTException {

        //Urun fotografi eklenebilmeli

        extentTest = extentReports.createTest("US_005 TC04", "Urun fotografi eklenebilmeli.");
        js.executeScript("arguments[0].click();", pearly.addfoto);
        pearly.selectfile.click();
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.selectfile);
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        // String homeDirectory=System.getProperty("user.home");
        // String filePath=homeDirectory+"/Desktop/LongDress.jpg";
        // pearly.selectfile.sendKeys(filePath,Keys.ENTER);

        Robot robot = new Robot();
        StringSelection str = new StringSelection("C:\\Users\\Administrator\\Desktop\\LongDress.jpg");
        //StringSelection str = new StringSelection("src/main/resources/LongDress.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(7000);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(7000);
        pearly.addproductSelect.click();
        ReusableMethods.waitFor(5);

        js.executeScript("arguments[0].click();", pearly.addimage);
        ReusableMethods.waitFor(5);


        WebElement alldate = Driver.getDriver().findElement(By.
                xpath("(//select[@id='media-attachment-date-filters'])[1]"));
        WebElement image = Driver.getDriver().findElement(RelativeLocator.with(By.xpath("(//div[@class='thumbnail'])[8]")).below(alldate));
        image.click();

        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].scrollIntoView(true);", pearly.addToGallery);
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.addToGallery);

        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici urun fotografi ekleyebildi");
        extentTest.pass("US_005 TC04 PASSED");


    }

    @Test
    public void TC05() {


        //Short description, Description kisimlarina bilgi girilebilmeli

        ReusableMethods.waitFor(5);
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@id='excerpt_ifr']"));
        frame.click();
        Driver.getDriver().switchTo().frame(frame);
        WebElement text = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        text.sendKeys("Fisto Long Dress");
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.waitFor(3);
        WebElement frame2 = Driver.getDriver().findElement(By.xpath("//iframe[@id='description_ifr']"));
        js.executeScript("arguments[0].click();", frame2);
        Driver.getDriver().switchTo().frame(frame2);
        WebElement text2 = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        text2.sendKeys("Fresh Summer Dress:)");


        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("User short description, description kisimlarina bilgi girebildi");
        extentTest.pass("US_005 TC05 PASSED");


    }

    @Test
    public void TC06() throws InterruptedException {

        //Secilen ürünlerin categorileriini belirlemeliyim
        //accessories,appoıntment,best seller
        //Books & Music & Film,Clothing,Computers
        //Electronics ,Fashion ,Food
        //Furniture, Games,Gift İdeas
        //Health & Beauty, Home & Garden, Kids
        //Kitchen, Men, New Arrivals, Office Tools
        //Services, Shoes, Sports, Toys & Games
        //Trending,Women
        //Uncategorized

        extentTest = extentReports.createTest("US_006 TC01", "Secilen ürünlerin categorilerini belirlemeliyim");
        ReusableMethods.getActions().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();

        Thread.sleep(5000);

        List<WebElement> categorie = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']"));
        for (WebElement w : categorie) {

            js.executeScript("arguments[0].click();", w);
            ReusableMethods.getSoftAssert().assertTrue(w.isSelected());

        }

        ReusableMethods.getSoftAssert().assertTrue(pearly.categories.isDisplayed());
        extentTest.pass("User categories secenegini görebildi");

        ReusableMethods.getActions().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        js.executeScript("arguments[0].click();", pearly.bestSellerButton);
        extentTest.info("US007 TC01 Products Brand gorulebildi");
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", pearly.amazonBasic);
        Thread.sleep(200);

         extentTest.info("US008 TC01 SKU,manageStock,stockQty gorulebildi. ");
         Assert.assertTrue(pearly.sku.isDisplayed());
         ReusableMethods.waitFor(3);
         js.executeScript("arguments[0].click();", pearly.sku);
         js.executeScript("arguments[0].click();", pearly.manageStock);
         ReusableMethods.waitFor(3);
         pearly.stockQty.click();
         pearly.stockQty.clear();
         pearly.stockQty.sendKeys("15", Keys.ENTER);
         ReusableMethods.waitFor(5);

         System.out.println(pearly.stockQty.getText());
         Assert.assertTrue(pearly.stockQty.isDisplayed());
         ReusableMethods.waitFor(5);


         js.executeScript("arguments[0].click();", pearly.allowBackorders);
         Assert.assertTrue(pearly.allowBackorders.isDisplayed());
         ReusableMethods.waitFor(3);

         if (!pearly.allow.isSelected()) {
             pearly.allow.click();
         }

         if (!pearly.allowButNotifyCustomer.isSelected()) {
             pearly.allowButNotifyCustomer.click();
         }

         if (!pearly.doNotAllow.isSelected()) {
             pearly.doNotAllow.click();
         }


         ReusableMethods.waitFor(3);
         Assert.assertTrue(pearly.soldIndividually.isDisplayed());


         js.executeScript("arguments[0].scrollIntoView(true);", pearly.submit);
         js.executeScript("arguments[0].click();", pearly.submit);

        extentTest.info("Kullanici secilen urunlerin brandlerini belirleyebildi");
        extentTest.pass("US_008 TC02 PASSED");


        ReusableMethods.getSoftAssert().assertAll();

    }


}
