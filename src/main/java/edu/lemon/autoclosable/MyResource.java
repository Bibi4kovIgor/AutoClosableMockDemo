package edu.lemon.autoclosable;

public class MyResource implements AutoCloseable {

    private static final String RESOURCE_IS_OPEN_TO_USE = "Resource is open to use";
    private static final String RESOURCE_IS_BEING_USED = "Resource is being used";
    private static final String RESOURCE_CLOSED = "Resource closed";

    private final Logger logger;
    private String statusMessage;

    public MyResource(Logger logger) {
        this.statusMessage = "";
        this.logger = logger;
    }

    public void open(){
        statusMessage = RESOURCE_IS_OPEN_TO_USE;
        logger.log(statusMessage);
    }

    // Method to simulate resource usage
    public void doSomething() {
        statusMessage = RESOURCE_IS_BEING_USED;
        logger.log(statusMessage);

    }

    // Close the resource
    @Override
    public void close() {
        statusMessage = RESOURCE_CLOSED;
        logger.log(statusMessage);
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
