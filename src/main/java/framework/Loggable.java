package framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 20.05.14.
 */
public interface Loggable {
    public static Logger LOG_TEST_SUITE = LoggerFactory.getLogger("TEST SUITE: ");
    public static Logger LOG_ENVIRONMENT = LoggerFactory.getLogger("ENVIRONMENT: ");
    public static Logger LOG_PRECONDITIONS = LoggerFactory.getLogger("PRECONDITIONS: ");
    public static Logger LOG_EXPECTED_RESULT = LoggerFactory.getLogger("EXPECTED RESULT: ");
    public static Logger LOG_TEST = LoggerFactory.getLogger("TEST CASE: ");
    public static Logger LOG_STEP = LoggerFactory.getLogger("STEP: ");
    public static Logger LOG_ERROR = LoggerFactory.getLogger("ERROR: ");
}
