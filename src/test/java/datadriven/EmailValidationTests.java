package datadriven;

import basetest.W3SchoolsTests;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EmailValidationTests extends W3SchoolsTests {

    @Test
    public void emailValidation(
            @Optional("John") String firstName,
            @Optional("Doe") String lastName,
            @Optional("john@example.com") String email) {
        assertEquals(tablesPage.getEmail(firstName, lastName), email);
    }
}
