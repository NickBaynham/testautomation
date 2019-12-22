package tables;

import basetest.W3SchoolsTests;
import org.testng.annotations.Test;
import pages.TablesPage;

import static org.testng.Assert.assertEquals;

public class TablesTests extends W3SchoolsTests {
    @Test
    public void verifyEmailForPerson() {
        assertEquals(tablesPage.getEmail("John", "Doe"), "john@example.com");
    }
}
