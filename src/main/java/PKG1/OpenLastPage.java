package PKG1;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import javax.annotation.concurrent.Immutable;

public class OpenLastPage extends BaseClass{

    @Test
    public void openLastPageTest()
    {
        //[Example: io.appium.android.apis/io.appium.android.apis.view.Controls4]
//If we want to test the last page - how to go their directly, without going step by step
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.view.Controls4");

        ((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent","io.appium.android.apis/io.appium.android.apis.view.Controls4"

        ));
        driver.findElement(AppiumBy.accessibilityId("Checkbox 1")).click();
    }
}
