package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowser extends BrowserBaseTest {

    //How to open chrome browser in mobile phone
    @Test
    public void mobileBrowserTest() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.cssSelector("li a[routerlink='/products']")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
        Thread.sleep(2000);
        String cource = driver.findElement(By.xpath("//a[text()='Devops']")).getText();
        Assert.assertEquals(cource,"Devops");

    }
}
