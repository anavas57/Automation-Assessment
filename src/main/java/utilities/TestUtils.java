package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {
    /**
     * Logging() Method
     * @return
     */
    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }

    /**
     *  Throws a RuntimeException with specific reason as to why test failed
     * Sets the global variable to halt all tests to true
     * @param failReason
     * @throws RuntimeException
     */
    public void failAndExitTests(String failReason) {
        Settings.haltRemainingTests = true;
        log().info("Failed for the following reason: " + "\"" + failReason + "\"");
        throw new RuntimeException("Failed for the following reason: " + "\"" + failReason + "\"");
    }
}
