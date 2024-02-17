package PKG1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    AndroidDriver driver;

    @BeforeClass
    public void BaseTest() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("AviPhone");
        options.setApp("C:\\Users\\Avinash\\IdeaProjects\\AppiumProject\\src\\main\\java\\APKFileRresource\\ApiDemos.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
