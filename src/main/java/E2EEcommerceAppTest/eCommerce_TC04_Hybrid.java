package E2EEcommerceAppTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class eCommerce_TC04_Hybrid extends BaseTest{

    //Hybrid app handle using getContexthandles() method
    @Test
    public void addProductToCart() throws InterruptedException {

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ram");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();

        //scrolling to particular country
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        String title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(title,"Products");

        //Added first 2 products, here putted get(0) 2 times because once product added- text got changed
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);

        //handle hybrid app
        Set<String> contexts = driver.getContextHandles();
        for(String contextName:contexts)
        {
            System.out.println("contextname::"+contextName);
        }
        //optput: contextname::NATIVE_APP
        //contextname::WEBVIEW_com.androidsample.generalstore
        Thread.sleep(2000);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        //now perform any operation on webpage
        driver.findElement(By.name("q")).sendKeys("chatgpt");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        //press back button
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //back to default-or native app
        driver.context("NATIVE_APP");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shyam");

    }
}
