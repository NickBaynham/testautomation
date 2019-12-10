package context;

import base.BaseTests;
import base.ParallelTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextTests extends ParallelTests {

    @Test
    public void testContextMenu() {
        var contextPage = homePage.clickContextMenu();
        contextPage.rightClickHotSpot();
        String alertText = contextPage.getAlertText();
        contextPage.dismissAlert();
        assertEquals(alertText, "You selected a context menu");
    }
}
