package am.test.data.util;

import am.test.data.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by karlen on 4/17/17.
 */
public class FileCreatorTest extends BaseTest {

    private FileCreator fileCreator;

    @Before
    public void setUpClass() {
        fileCreator = applicationContext.getBean("fileCreator", FileCreator.class);
    }

    @Test
    public void testSaveAmountOfDifferentValues() {
        fileCreator.saveAmountOfDifferentValues();
    }

    @Test
    public void testAppearTimes() {
        fileCreator.saveAppearTimes();
    }
}