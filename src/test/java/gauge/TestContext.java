package gauge;

import com.thoughtworks.gauge.*;

public class TestContext {
    @BeforeSuite
    public void setupSuite() {}

    @BeforeScenario
    public void setupScenario() {}

    @BeforeStep
    public void setupStep(ExecutionContext context) {}

    @AfterStep
    public void teardownStep(ExecutionContext context) {}

    @AfterScenario
    public void teardownScenario(ExecutionContext context) {}

    @AfterScenario
    public void teardownSuite() {}
}
