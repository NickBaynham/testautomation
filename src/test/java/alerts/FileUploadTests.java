package alerts;

import basetest.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\nbaynham\\Documents\\testautomation\\resources\\chromedriver.exe");
        assertEquals(fileUploadPage.getUploadedFiles(), "chromedriver.exe");
    }
}
