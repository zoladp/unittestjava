package pl.devfoundry.testing;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.util.logging.Logger;

public class IllegalArgExceptionIgnoreExtension implements TestExecutionExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(IllegalArgExceptionIgnoreExtension.class.getName());

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if(throwable instanceof IllegalArgumentException) {
            LOGGER.info("Just ignored IllegalArgumentException");
        } else {
            throw throwable;
        }
    }
}
