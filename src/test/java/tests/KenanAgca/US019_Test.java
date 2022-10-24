package tests.KenanAgca;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US019_Test {


    PearlyMarketPage pearly = new PearlyMarketPage();

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC01() {

        ReusableMethods.storeManager();
        js.executeScript("arguments[0].click();", pearly.followerss);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.followerssName.isDisplayed());
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.followerssEmail.isDisplayed());

        //TC002

        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.followersActions.isDisplayed());

        //sayfayı kapat

        Driver.closeDriver();
    }
}