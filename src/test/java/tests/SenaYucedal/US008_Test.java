package tests.SenaYucedal;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;



public class US008_Test {

    PearlyMarketPage pearly = new PearlyMarketPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



    @Test
    public void US008_Test() throws Exception {


        //TC001

        ReusableMethods.storeManager();
        pearly.productSena.click();
        pearly.addNewButtonSena.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


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

        //TC002

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

        //Sayfayi kapat
        Driver.closeDriver();



    }
}
