package tests.KenanAgca;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class US018_Test {

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    PearlyMarketPage pearly = new PearlyMarketPage();

    WebDriver driver;

    @Test
    public void test01() {

        //RequestID; geri isteme istegi
        ReusableMethods.signIn();

        //Urunu arama çubunda ara
        ReusableMethods.waitFor(2);
        pearly.aramaKutusu.sendKeys("Hope Cup", Keys.ENTER);
        ReusableMethods.waitFor(3);
        pearly.hopeCupNew.click();

        //Sepete ekle Click;
        ReusableMethods.waitFor(2);
        pearly.sepeteEkleNew.click();

        //Sepetim'e click;
        ReusableMethods.waitFor(2);
        pearly.sepetimK.click();

        //Ödeme Click;
        //Siparişi onayla click;
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", pearly.proceedToCheckout);
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", pearly.odeme);

        //Listeye geri dön click;
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", pearly.listeyeDon);

        //Store manager click;
        pearly.store.click();

        //Orders click;
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();", pearly.ordersK);

        //View Details click;
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.viewDetails);

        //Order Status kısmı 'Completed'seklinde secilecek;
        WebElement completed = driver.findElement(By.xpath("//select[@id='wcfm_order_status']"));
        Select option = new Select(completed);
        option.selectByIndex(4);


        //Update click;
        js.executeScript("arguments[0].click();", pearly.uptade);

        //Hesabım butonu click;
        js.executeScript("arguments[0].click();", pearly.myAccountNew);

        //Siparişler cilck;
        js.executeScript("arguments[0].click();", pearly.ordersNew);

        //Destek Click;
        js.executeScript("arguments[0].click();", pearly.supportK);

        //Support Tıcket-Issues you are having - data yazılır;
        pearly.issues.sendKeys("I do not like it");

        //Submit cilck;
        js.executeScript("arguments[0].click();", pearly.submitNew);

        //Store Manager click;
        js.executeScript("arguments[0].click();", pearly.store);

        //Emirler cilck;
        js.executeScript("arguments[0].click();", pearly.ordersNew);

        //Refund Reguest click;
        js.executeScript("arguments[0].click();", pearly.refundRequest);

        //Qty sec;
        //Refund Requests Reason yaz;
        ArrayList<WebElement> qty = new ArrayList<>(Driver.getDriver().findElements
                (By.xpath("(//td[@class='item_quantity wcfm_item_qty_heading sortable'])[1]")));
        qty.get(1).click();
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.TAB)
                .sendKeys("I do not like it");

        //Submit click;
        pearly.submitNewButton.click();

        //Geri Ödeme Click;
        pearly.refundButton.click();

        //WebTable daki elementleri consola yazdır
        //RequestID'nin value görüldüğünü test et
        //Order ID 'nin value  görüldüğünün test et
        //Amount value görüldüğünü test et
        //Type and Reason value görüldüğünü test et
        ArrayList<WebElement> refRegTable = new ArrayList<>(Driver.getDriver().findElements
                (By.xpath("//div[@id='wcfm-refund-requests_wrapper']")));
        SoftAssert sf = new SoftAssert();
        for (WebElement w : refRegTable
        ) {
            System.out.println(w.getText());
            sf.assertTrue(w.isDisplayed());
        }

        sf.assertAll();

    }
}