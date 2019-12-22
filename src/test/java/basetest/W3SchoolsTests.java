package basetest;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.TablesPage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class W3SchoolsTests {
    private EventFiringWebDriver driver;
    public TablesPage tablesPage;

    @BeforeClass
    public void setUp() {
        setupDriver(false);
        tablesPage = new TablesPage(driver);
    }

    @BeforeMethod
    public void reset() {
        driver.get("https://www.w3schools.com/bootstrap/bootstrap_tables.asp");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
        driver = null;
    }

    public static void main(String[] args) {
        W3SchoolsTests baseTests = new W3SchoolsTests();
        baseTests.findingElements();
    }

    private void findingElements() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.get("https://www.w3schools.com/bootstrap/bootstrap_tables.asp");
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(375, 812));
        System.out.println(driver.getTitle());
    }

    public void setupDriver(boolean mobile) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.get("https://the-internet.herokuapp.com/");
        if (mobile) driver.manage().window().setSize(new Dimension(375, 812));
        else driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }


    public WindowManager getWindowManager() {
        return new WindowManager(driver);
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

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("disable-infobars");
        return chromeOptions;
    }
}
