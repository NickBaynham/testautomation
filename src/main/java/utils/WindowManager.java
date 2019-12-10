package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refresh() {
        navigate.refresh();
    }

    public void goTo(String URL) {
        navigate.to(URL);
    }

    public void switchToTab(String titleOfTab) {
        var windows = driver.getWindowHandles();
        System.out.println("Open Windows: " + windows.size());
        System.out.println("Windows handles: ");
        windows.forEach(System.out::println);
        for (String window : windows) {
            System.out.println("Switching to Window: " + window);
            driver.switchTo().window(window);
            System.out.println("Current window title: " + driver.getTitle());
            if (titleOfTab.equals(driver.getTitle())) break;
        }
    }
}
