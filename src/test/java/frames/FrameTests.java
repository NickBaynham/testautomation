package frames;

import basetest.BaseTests;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();
        wysiwygEditorPage.clearTextArea();
        wysiwygEditorPage.setTextArea("Hello");
        wysiwygEditorPage.decreaseIndentation();
        wysiwygEditorPage.setTextArea(" World");
        assertEquals(wysiwygEditorPage.getTextFromEditor(), "Hello World");
    }
}
