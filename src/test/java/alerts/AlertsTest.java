package alerts;

import basetest.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertsTest extends BaseTests {

    @Test
    public void testAlerts() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickButtonJSAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResultText(), "You successfuly clicked an alert");
    }

    @Test
    public void testConfirm() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickButtonJSConfirm();
        String text = alertsPage.getAlertText();
        assertEquals(text, "I am a JS Confirm");
        alertsPage.dismissAlert();
        assertEquals(alertsPage.getResultText(), "You clicked: Cancel");
    }

    @Test
    public void testPrompt() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickButtonJSPrompt();
        alertsPage.enterAlertText("hello Scott!");
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResultText(), "You entered: hello Scott!");
    }
}
