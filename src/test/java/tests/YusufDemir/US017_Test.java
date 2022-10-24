package tests.YusufDemir;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US017_Test {
    PearlyMarketPage pearlyMarket = new PearlyMarketPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Test
    public void TC001() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        pearlyMarket.signIn.click();
        pearlyMarket.username.sendKeys("testngteam06@hotmail.com");
        pearlyMarket.signPass.sendKeys("Batch81");
        pearlyMarket.signlog.click();
        Thread.sleep(4000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.enAltaInme).perform();
        Thread.sleep(1000);
        pearlyMarket.myAccount2.click();
        Thread.sleep(1000);
        pearlyMarket.storeManager.click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.customers).click().perform();
        Thread.sleep(2000);
        pearlyMarket.addNew.click();
        Thread.sleep(3000);
        pearlyMarket.userNameCustomer.sendKeys(faker.name().username());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Sweden", Keys.ENTER).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode(), Keys.ENTER).perform();
        Assert.assertTrue(pearlyMarket.kaydedildiYazisi.isDisplayed());
        Thread.sleep(2000);
        System.out.println("TC001 : Billing address; isim, soy isim, şirket ismi, tel, adres1 ve adres iki (optional),ülke, sehir, posta kodu girildigi dogrulandi");
    }

    @Test
    public void TC002() throws InterruptedException {
        PearlyMarketPage pearlyMarket = new PearlyMarketPage();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        pearlyMarket.signIn.click();
        pearlyMarket.username.sendKeys("testngteam06@hotmail.com");
        pearlyMarket.signPass.sendKeys("Batch81");
        pearlyMarket.signlog.click();
        Thread.sleep(4000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.enAltaInme).perform();
        Thread.sleep(1000);
        pearlyMarket.myAccount2.click();
        Thread.sleep(1000);
        pearlyMarket.storeManager.click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.customers).click().perform();
        Thread.sleep(2000);
        pearlyMarket.addNew.click();
        Thread.sleep(3000);
        pearlyMarket.userNameCustomer.sendKeys(faker.name().username());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Sweden", Keys.ENTER).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode(), Keys.ENTER).perform();
        Thread.sleep(2000);
        // Shipping address; yukaridaki adresleri ayni olarak ekleyebilirler seceneginin aktifligi kontrol edilmeli
        Assert.assertTrue(pearlyMarket.sameAsBilling.isSelected());
        System.out.println("TC002 : Shipping address; yukaridaki adresleri ayni olarak ekleyebilir secenegi aktifligi dorulandi");
    }

    @Test
    public void TC003() throws InterruptedException {
        PearlyMarketPage pearlyMarket = new PearlyMarketPage();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        // Veya yeniden yukarıdaki tum adres bilgilerini farklı olarak ekleyebilirler
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        pearlyMarket.signIn.click();
        pearlyMarket.username.sendKeys("testngteam06@hotmail.com");
        pearlyMarket.signPass.sendKeys("Batch81");
        pearlyMarket.signlog.click();
        Thread.sleep(4000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.enAltaInme).perform();
        Thread.sleep(1000);
        pearlyMarket.myAccount2.click();
        Thread.sleep(1000);
        pearlyMarket.storeManager.click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.moveToElement(pearlyMarket.customers).click().perform();
        Thread.sleep(3000);
        pearlyMarket.addNew.click();
        Thread.sleep(3000);
        pearlyMarket.userNameCustomer.sendKeys(faker.name().username());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Sweden", Keys.ENTER).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).perform();
        Thread.sleep(4000);
        actions.moveToElement(pearlyMarket.sameAsBilling).click().perform();
        Assert.assertFalse(pearlyMarket.sameAsBilling.isSelected());
        Thread.sleep(2000);
        pearlyMarket.shippingFirstName.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("France", Keys.ENTER).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).
                sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(pearlyMarket.kaydedildiYazisi.isDisplayed());
        System.out.println("TC003 : Veya yeniden yukarıdaki tum adres bilgilerini farklı olarak ekleme islemi yapilmali secenegi onaylandi");
    }

    @AfterMethod
    public void tearDown() {

        ReusableMethods.waitFor(2);
        Driver.closeDriver();

    }
}

