package PKG1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Miscellineous extends BaseClass {

    //1. Alert Concept - copying text and accept alert
    //@Test
    public void AppiumTestAlertMessage() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

        driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert Message::" + alertMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
        String alertMessage1 = driver.switchTo().alert().getText();
        System.out.println("Alert Message1::" + alertMessage1);
        driver.switchTo().alert().accept();

    }

    //2. Radio Button Concept
    //@Test
    public void AppiumTestRadioButton() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        List<WebElement> items = driver.findElements(AppiumBy.className("android.widget.CheckedTextView"));
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getText());
            if(items.get(i).getText().contains("Traffic"))
            {
                items.get(i).click();
            }
        }
    }

    //3. 90 degree ratation Concept
    //@Test
    public void AppiumTestRotation() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        DeviceRotation deviceRotation = new DeviceRotation(0,0,90);
        driver.rotate(deviceRotation);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"OK Cancel dialog with Holo Light theme\"));"));

    }

    //4. Clipboard Concept - copying text from clipkboard and paste somewhere else
   // @Test
    public void AppiumTestClipboard() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
        //clipboard
        driver.setClipboardText("Shree Ram");
        driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys(driver.getClipboardText());
        driver.setClipboardText("Hanuman");
        driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys(driver.getClipboardText());
        driver.switchTo().alert().accept();

    }

    //5. KeyEvent Concept - we can press all keys preset in the phone like: HOME button, BACK button, ENTER button press, A to Z, Special chars etc
    @Test
    public void AppiumKeyEventTest() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
        driver.setClipboardText("Shree Ram");
        driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Hanuman");
        driver.switchTo().alert().accept();
        //keypress event
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }

}