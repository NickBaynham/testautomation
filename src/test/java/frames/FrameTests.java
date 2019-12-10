package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        var wysiwygEditorPage = homePage.clickWysiwygEditor();
        wysiwygEditorPage.clearTextArea();
        wysiwygEditorPage.setTextArea("Hello");
        wysiwygEditorPage.decreaseIndentation();
        wysiwygEditorPage.setTextArea(" World");
        assertEquals(wysiwygEditorPage.getTextFromEditor(), "Hello World");
    }
}
