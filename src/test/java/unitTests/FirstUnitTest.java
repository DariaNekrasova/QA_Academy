package unitTests;

import org.junit.Test;

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
}
