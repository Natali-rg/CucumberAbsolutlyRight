package appium.config;

import appium.BaseAppiumSteps;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverConfig {
    public static RemoteWebDriver initAndroidChrome(){
        RemoteWebDriver driver=null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability("chromedriverExecutable","D:\\Natali\\ChromeDriver\\chromedriver.exe");//подключение хромдрайвера через указания путя
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");//указываем версию Android
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//Сообщаем, что будет использоваться эмулятор
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1800);
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4724/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }


}
