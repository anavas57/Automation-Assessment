package cucumber;

import enums.Context;

/**
 * TestContext - Used to refactor the step definitions separated under different classes.
 */
public class TestContext {
    private ScenarioContext scenarioContext;

    public TestContext() {
        scenarioContext = new ScenarioContext();
        scenarioContext.setContext(Context.RETRIEVE_MERCHANT_SETTINGS_RESPONSE, scenarioContext);
    }

    /**
     * getScenarioContext() - Returns Scenario Context.
     * @return
     */
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
