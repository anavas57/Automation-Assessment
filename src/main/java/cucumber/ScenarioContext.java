package cucumber;

import enums.Context;
import java.util.HashMap;
import java.util.Map;

/**
 * ScenarioContext - It holds the test data information explicitly.
 *                   It helps store values in a key-value pair between the steps.
 *                   Moreover, it helps in organizing step definitions better rather than using private variables in step definition classes.
 */
public class ScenarioContext {
    private Map<String, Object> scenarioContext;
    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }
    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }
    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }
    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
}
