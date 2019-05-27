package first_steps;

import com.thoughtworks.gauge.Step;
import gauge.AbstractStep;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;

import static java.text.MessageFormat.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class FirstSteps extends AbstractStep {

    @Step("Is <first_value> + <second_value> = <result>")
    public void checkSum(int first_value, int second_value, int result){
        assertEquals(first_value + second_value, result);
    }

    @Step("Is <first_value> + <second_value> really = <result>")
    public void checkSum_2(int first_value, int second_value, int result){
            assertThat(format("{0} + {1} != {2}", first_value, second_value, result),(first_value + second_value) == result);
    }

    @Step("Is <str> contains <letter>")
    public void checkSum_3(String str, String letter){
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(str).contains(letter);
        softly.assertAll();
    }

}
