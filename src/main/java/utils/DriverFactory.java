package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static utils.DriverType.valueOf;
import static utils.DriverType.FIREFOX;

public class DriverFactory {
    private RemoteWebDriver driver;
    private DriverType driverType;
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public DriverFactory() {
        DriverType driverType = FIREFOX;
        String browser = System.getProperty("browser", driverType.toString().toUpperCase());
        try {
            driverType = valueOf(browser);
        } catch (IllegalArgumentException e) {
            System.err.println("Unknown Driver specified. Defaulting to: " + driverType.toString());
        } catch (NullPointerException e) {
            System.err.println("No Driver specified, defaulting to: " + driverType.toString());
        }
        this.driverType = driverType;
    }

    public RemoteWebDriver getDriver() {
        if (null == driver) {
            instantiateWebDriver(driverType);
        }
        return driver;
    }

    private void instantiateWebDriver(DriverType driverType) {
        System.out.println(" ");
        System.out.println("Local Operating System: " +
                operatingSystem);
        System.out.println("Local Architecture: " +
                systemArchitecture);
        System.out.println("Selected Browser: " +
                driverType);
        System.out.println(" ");
        DesiredCapabilities desiredCapabilities = new
                DesiredCapabilities();
        driver = driverType.getWebDriverObject(desiredCapabilities);
    }

    public void quit() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
