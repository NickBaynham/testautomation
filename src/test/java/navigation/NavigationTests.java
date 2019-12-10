package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigation() {
        homePage.clickDynamicLoading().clickLinkExample1();
        getWindowManager().goBack();
        getWindowManager().refresh();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testMultipleWindows() {
        homePage.clickMultipleWindows().clickLink();
        getWindowManager().switchToTab("New Window");
    }
}
