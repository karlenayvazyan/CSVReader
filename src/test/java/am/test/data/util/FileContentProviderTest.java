package am.test.data.util;

import am.test.data.BaseTest;
import am.test.data.model.FileContent;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by karlen on 4/16/17.
 */
public class FileContentProviderTest extends BaseTest {

    @Test
    public void testGetFileContents_2() {
        FileContentProvider fileContentProvider = applicationContext.getBean("fileContentProvider", FileContentProvider.class);
        FileContent fileContent = fileContentProvider.getFileContent();
        assertNotNull(fileContent);
    }
}