package tests.TugbaGunes;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseBeforeMethodAfterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US002_Test  {
    PearlyMarketPage pearly = new PearlyMarketPage();

    @Test
    public void US002_T00() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        pearly.signİn.click();
        pearly.signİnEmail.sendKeys("testngteam06@hotmail.com");
        pearly.signİnPassword.sendKeys("Batch81");
        Thread.sleep(2000);
        pearly.signİnButton.click();
        pearly.signOut.click();
        Assert.assertTrue(pearly.myAccount.isDisplayed());
        List<String> expectedList = new ArrayList<>(Arrays.asList("Store Manager", "Orders",
                "Downloads", "Addresses", "Account details", "Wishlist", "Support Tickets",
                "Followings", "Followings"));
        for (int i = 0; i < pearly.dashboardList.size(); i++) {

            Assert.assertTrue(pearly.dashboardList.get(i).getText().contains(expectedList.get(i)));
        }
    }}
