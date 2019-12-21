package basetest;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.CapabilityFactory;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParallelTests {
    protected static ThreadLocal<EventFiringWebDriver> driver = new ThreadLocal<>();
    protected CapabilityFactory capabilityFactory = new CapabilityFactory();
    protected HomePage homePage;

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        System.out.println("Browser: " + browser);
        RemoteWebDriver remote = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser));
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(remote);
        eventFiringWebDriver.register(new EventReporter());
        driver.set(eventFiringWebDriver);
        driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get().get("https://the-internet.herokuapp.com/");
        //driver.get().manage().window().setSize(new Dimension(375, 812));
        //driver.get().manage().window().maximize();
        System.out.println(driver.get().getTitle());
        homePage = new HomePage(driver.get());
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver.get());
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
