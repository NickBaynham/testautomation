package utils;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;

public enum DriverType implements DriverSetup {
    FIREFOX {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(HEADLESS);
            options.merge(capabilities);

            return new FirefoxDriver(options);
        }
    },
    CHROME {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            HashMap<String, Object> chromePreferences = new
                    HashMap<>
                    ();

            chromePreferences.put("profile.password_manager_enabled"
                    ,false);

            ChromeOptions options = new ChromeOptions();
            options.setHeadless(HEADLESS);
            options.merge(capabilities);
            options.addArguments("--no-default-browser-check");
            options.setExperimentalOption("prefs",
                    chromePreferences);

            return new ChromeDriver(options);
        }
    },
    IE {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            EdgeOptions options = new
                    EdgeOptions();
            options.merge(capabilities);
            options.setCapability(CapabilityType.ForSeleniumServer.
                    ENSURING_CLEAN_SESSION, true);
            return new EdgeDriver(options);
        }
    },
    EDGE {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            EdgeOptions options = new EdgeOptions();
            options.merge(capabilities);

            return new EdgeDriver(options);
        }
    },
    SAFARI {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            SafariOptions options = new SafariOptions();
            options.merge(capabilities);

            return new SafariDriver(options);
        }
    },
    OPERA {
        public RemoteWebDriver
        getWebDriverObject(DesiredCapabilities
                                   capabilities) {
            OperaOptions options = new OperaOptions();
            options.merge(capabilities);

            return new OperaDriver(options);
        }
    };
    public final static boolean HEADLESS = Boolean.getBoolean("headless");
}
