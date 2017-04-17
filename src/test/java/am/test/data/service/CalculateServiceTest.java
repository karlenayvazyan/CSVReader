package am.test.data.service;

import am.test.data.BaseTest;
import am.test.data.model.CSVKeys;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;


/**
 * Created by karlen on 4/16/17.
 */
public class CalculateServiceTest extends BaseTest {

    private CalculateService calculateService;

    @Before
    public void setUpClass() {
        calculateService = applicationContext.getBean("calculateService", CalculateService.class);
    }

    @Test
    public void testAmountOfDifferentValues() {
        Map<CSVKeys, Integer> result = calculateService.amountOfDifferentValues();
        assertNotNull(result);
    }

    @Test
    public void testAppearTimes() {
        List<Map<String, Long>> maps = calculateService.appearTimes();
        assertNotNull(maps);
    }
}