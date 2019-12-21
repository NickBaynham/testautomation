package context;

import basetest.ParallelTests;
import org.testng.annotations.Test;
import pages.ContextPage;

import static org.testng.Assert.assertEquals;

public class ContextTests extends ParallelTests {

    @Test
    public void testContextMenu() {
        ContextPage contextPage = homePage.clickContextMenu();
        contextPage.rightClickHotSpot();
        String alertText = contextPage.getAlertText();
        contextPage.dismissAlert();
        assertEquals(alertText, "You selected a context menu");
    }
}
