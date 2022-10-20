package tests.NidaYucedal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US006_Test extends TestBaseRapor {


    PearlyMarketPage pearly = new PearlyMarketPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void US006TC01() throws InterruptedException {

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

        ReusableMethods.storeManager();
        ReusableMethods.waitFor(10);
       // pearly.productsnida.click();
       // pearly.addnew.click();

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
        extentTest.info("Secilen ürünun categorisi belirlendi");
    }
}
