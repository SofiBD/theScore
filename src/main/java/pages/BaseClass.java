package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static AppiumDriver driver;
    private AppiumDriverLocalService service;

    public Properties properties;
    InputStream inputStream;


    public void startAppiumService() {
        service = new AppiumServiceBuilder()
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .build();
        service.start();
    }

    public void beforeClass() throws Exception {
        try {
            properties = new Properties();
            String propertyFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
            properties.load(inputStream);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", properties.getProperty("platformName"));

            switch (properties.getProperty("platformName")) {
                case "android":

                    caps.setCapability("platformVersion", properties.getProperty("androidPlatformVersion"));
                    caps.setCapability("automationName", properties.getProperty("androidAutomationName"));
                    caps.setCapability("deviceName", properties.getProperty("androidDeviceName"));
                    caps.setCapability("appPackage", properties.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", properties.getProperty("androidAppActivity"));
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "app" + File.separator + "theScore.apk";
                    System.out.println("Android URL is: " + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "iOS":
                    caps.setCapability("automationName", properties.getProperty("iOSAutomationName"));
                    caps.setCapability("platformVersion", properties.getProperty("iOSPlatformVersion"));
                    caps.setCapability("deviceName", properties.getProperty("iOSDeviceName"));
                    caps.setCapability("app", getClass().getResource(properties.getProperty("iosAppLocation")).getFile());
                    driver = new IOSDriver(new URL(properties.getProperty("appiumURL")), caps);
                    break;
                default:
                    throw new Exception("Invalid Platform");
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public boolean isElementPresent(By by) {
        WebElement element;
        try {
            element = driver.findElement(by);
        } catch (NoSuchElementException exception) {
            return false;
        }
        return element.isDisplayed();
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public ArrayList<String> getSubTabs(By by) {
        List<WebElement> tabs = driver.findElements(by);
        ArrayList<String> subTabs = new ArrayList<String>();
        for (WebElement we : tabs) {
            subTabs.add(we.getText());
        }
        return subTabs;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }


}
