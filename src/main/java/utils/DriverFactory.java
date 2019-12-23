package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    private RemoteWebDriver driver;
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public RemoteWebDriver getDriver() {
        if (null == driver) {
            System.out.println(" ");
            System.out.println("Current Operating System: " + operatingSystem);
            System.out.println("Current Architecture: " + systemArchitecture);
            System.out.println("Current Browser Selection: Firefox");
            System.out.println(" ");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void quit() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
