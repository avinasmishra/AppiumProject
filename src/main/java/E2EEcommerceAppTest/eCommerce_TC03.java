package E2EEcommerceAppTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class eCommerce_TC03 extends BaseTest{

    //Adding Multiple Product to the Cart and verifying the total sum of product added in the cart
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
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);

        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        double totalSum=0;
        for(int i=0;i<productPrices.size();i++)
        {
            String productPrice = productPrices.get(i).getText();
            //$160.97
            String price = productPrice.substring(1);
            double sum = Double.parseDouble(price);
            totalSum = totalSum+sum;
        }
        System.out.println("totalSum::"+totalSum);
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        String displayPrice = displaySum.substring(1);
        double formattedSum = Double.parseDouble(displayPrice);
        Assert.assertEquals(formattedSum,totalSum);

        //longPress on element
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();

    }
}
