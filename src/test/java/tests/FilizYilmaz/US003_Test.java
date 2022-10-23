package tests.FilizYilmaz;


import com.github.javafaker.Faker;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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

public class US003_Test{


    PearlyMarketPage pearly = new PearlyMarketPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void T00() throws InterruptedException {
        ReusableMethods.signIn();
        ReusableMethods.waitFor(3);
        ReusableMethods.waitFor(3);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        WebElement myAccount=Driver.getDriver().findElement(By.xpath("//a[contains(text(),'My Account')]"));
        js.executeScript("arguments[0].click();", myAccount);
        ReusableMethods.waitFor(5);
        WebElement orders= Driver.getDriver().findElement(By.xpath("(//p[@class='text-uppercase text-center mb-0'])[1]"));
        js.executeScript("arguments[0].click();", orders);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pearly.goShop.click();
        Faker faker = new Faker();

        for (int i = 0; i < pearly.conList.size(); i++) {
            Thread.sleep(2000);
            js.executeScript("arguments[0].click();", pearly.conList.get(i));
            // ReusableMethods.jsScrollClick(pearly.conList.get(i));
            Thread.sleep(1000);
            try {
                if (pearly.sepeteEkle.isDisplayed()) {
                    pearly.sepeteEkle.click();
                    Thread.sleep(2000);
                    Driver.getDriver().navigate().back();
                    Driver.getDriver().navigate().back();
                } else
                    Driver.getDriver().navigate().back();
            } catch (Exception e) {
                Driver.getDriver().navigate().back();
            }

            int count = Integer.parseInt(pearly.sepetCount.getText());
            if (count == 5) {
                break;
            }
        }
        js.executeScript("arguments[0].click();", pearly.cart);
        pearly.viewCart.click();
        Thread.sleep(1000);
        pearly.checkout.click();
        pearly.firstName.sendKeys(Keys.CLEAR);
        Thread.sleep(1000);
        actions.sendKeys(Keys.CLEAR).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys("codeTest").
                sendKeys(Keys.TAB).sendKeys("Turkey", Keys.ENTER).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).
                sendKeys(faker.address().streetAddress()).
                sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).
                sendKeys(faker.address().buildingNumber()).
                sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).
                sendKeys("Merkez", Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys("Tokat", Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("Tesekkur ederim").
                sendKeys(Keys.ENTER).perform();

        WebElement placeOrder=Driver.getDriver().findElement(By.xpath("//button[@id='place_order']"));
        js.executeScript("arguments[0].click();", placeOrder);
        ReusableMethods.waitFor(5);
        WebElement message=Driver.getDriver().findElement(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']"));
        Assert.assertTrue(message.isDisplayed());

    }

}
