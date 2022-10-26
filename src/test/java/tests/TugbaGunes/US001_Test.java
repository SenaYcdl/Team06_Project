package tests.TugbaGunes;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class US001_Test {

    PearlyMarketPage pearly = new PearlyMarketPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void US001_TC_001() {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //Register butonunu navigate et ve tıkla
        pearly.registerr.click();
        //Become a Vendor butonunu navigate et ve tıkla
        pearly.becomeVendor.click();
        Assert.assertTrue(pearly.becomeAVendor.isDisplayed());
        ReusableMethods.waitFor(3);
        String marketHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW).get("https://www.fakemail.net");
        //Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("https://www.fakemail.net"));
        ReusableMethods.waitFor(10);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        ReusableMethods.waitFor(3);
        String mailHandle = Driver.getDriver().getWindowHandle();
        ReusableMethods.getActions().moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@class='color cetc'])[1]"))).click().perform(); // maili kopyalar
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().window(marketHandle);
        ReusableMethods.waitFor(3);
        WebElement emailBox = Driver.getDriver().findElement(By.cssSelector("[id='user_email']"));
        ReusableMethods.getActions().moveToElement(emailBox).click().perform();
        emailBox.sendKeys(Keys.CONTROL + "v");
        ReusableMethods.waitFor(3);

        Driver.getDriver().switchTo().window(mailHandle);
        ReusableMethods.waitFor(15);

        Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[1]")).click();
        ReusableMethods.waitFor(5);

        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);

        List<WebElement> code = Driver.getDriver().findElements(By.xpath("//span[@id='predmet']"));

        String num = code.get(0).getText();
        System.out.println(code);

        String[] sayi = num.split(" ");
        System.out.println(sayi[6]);


        Driver.getDriver().switchTo().window(marketHandle);
        WebElement vercode = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Verification Code'])[1]"));
        vercode.sendKeys(sayi[6]);
        WebElement pass1 = Driver.getDriver().findElement(By.xpath("//input[@id='passoword']"));
        pass1.sendKeys("Batch81.");
        WebElement pass2 = Driver.getDriver().findElement(By.xpath("//input[@id='confirm_pwd']"));
        pass2.sendKeys("Batch81.");
        WebElement reg = Driver.getDriver().findElement(By.xpath("//input[@id='wcfm_membership_register_button']"));
        js.executeScript("arguments[0].click();", reg);

        WebElement notnow = Driver.getDriver().findElement(By.xpath("//a[@class='button button-large']"));
        js.executeScript("arguments[0].click();", notnow);
    }
    @Test
    public void US001_TC_002(){ //smokeTest

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));


        Assert.assertTrue(pearly.pearlyRegister.isDisplayed());
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        Assert.assertTrue(pearly.userEmail.isEnabled());
        Assert.assertTrue(pearly.userEmail.isDisplayed());
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.passwordd.isEnabled());
        Assert.assertTrue(pearly.password.isDisplayed());
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.confirmPass.isEnabled());
        Assert.assertTrue(pearly.confirmPass.isDisplayed());


    }

    @Test
    public void US001_TC_003(){ //smokeTest

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys(" ");
        pearly.passwordd.sendKeys(ConfigReader.getProperty("pearlyPassword"));
        ReusableMethods.waitFor(3);
        pearly.confirmPass.sendKeys(ConfigReader.getProperty("pearlyPassword"));
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.errorMessage.isDisplayed());


    }

    @Test //negatifSmokeTest
    public void US001_TC_004(){

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys("shYUISHJDKMJh");
        pearly.passwordd.sendKeys(ConfigReader.getProperty("pearlyPassword"));
        ReusableMethods.waitFor(3);
        pearly.confirmPass.sendKeys(ConfigReader.getProperty("pearlyPassword"));
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.wrongEmail.isDisplayed());

    }

    @Test
    public void US001_TC_005(){ //smokeTest

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys(ConfigReader.getProperty("pearlyEmail"));
        pearly.passwordd.sendKeys(ConfigReader.getProperty("pearlyPassword"));
        pearly.confirmPass.sendKeys(ConfigReader.getProperty("pearlyPassword"));
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.errorEmail.isDisplayed());
        ////*[contains(text(),'çıkan mesaj')]


    }

    @Test
    public void US001_TC_008(){ //kucukharf olmadan

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys("sena.ycdl61@gmail.com");
        pearly.passwordd.sendKeys("123G");
        pearly.confirmPass.sendKeys("123G");
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.atleastGood.isDisplayed());




    }

    @Test
    public void strongPassControl2() { //buyukharf olmadan

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys("sena.ycdl61@gmail.com");
        pearly.passwordd.sendKeys("123a*");
        pearly.confirmPass.sendKeys("123a*");
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.atleastGood.isDisplayed());




    }

    @Test
    public void strongPassControl3(){ //rakam olmadan

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys("sena.ycdl61@gmail.com");
        pearly.passwordd.sendKeys("Hello");
        pearly.confirmPass.sendKeys("Hello");
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.atleastGood.isDisplayed());



    }

    @Test
    public void strongPassControl4(){ //specialcarakter olmadan

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys("sena.ycdl61@gmail.com");
        pearly.passwordd.sendKeys("123aA");
        pearly.confirmPass.sendKeys("123Aa");
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.atleastGood.isDisplayed());



    }

    @Test
    public void strongPassControl5() {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys("sena.ycdl61@gmail.com");
        pearly.passwordd.sendKeys("Hello01");
        pearly.confirmPass.sendKeys("Hello01");
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.goodPassword.isDisplayed());


    }

    @Test
    public void samePassControl(){

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        js.executeScript("arguments[0].click();", pearly.pearlyRegister);
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", pearly.becomeAVendor);
        pearly.userEmail.sendKeys(ConfigReader.getProperty("pearlyEmail"));
        pearly.passwordd.sendKeys(ConfigReader.getProperty("pearlyPassword"));
        pearly.confirmPass.sendKeys("123456");
        ReusableMethods.waitFor(3);
        js.executeScript("arguments[0].click();", pearly.registerButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearly.NotSamePass.isDisplayed());


    }
}

