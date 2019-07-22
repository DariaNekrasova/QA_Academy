package unitTests;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUnitTest {

    @Test
    public void simpleTest(){
        assertEquals(12, 6 + 6);
    }

    @Test
    public void simpleFailedTest(){
        assertEquals(11, 6 + 6);
    }

    @Test
    public void testtrr(){
            }
}
