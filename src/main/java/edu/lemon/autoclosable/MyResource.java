package edu.lemon.autoclosable;

import static edu.lemon.autoclosable.ResourceState.*;

public class MyResource implements AutoCloseable {

    private final Logger logger;
    private String statusMessage;

    public MyResource(Logger logger) {
        this.statusMessage = "";
        this.logger = logger;
    }

    public void open(){
        statusMessage = RESOURCE_IS_OPEN_TO_USE.getResourceState();
        logger.log(statusMessage);
    }

    // Method to simulate resource usage
    public void doSomething() {
        statusMessage = RESOURCE_IS_BEING_USED.getResourceState();
        logger.log(statusMessage);

    }

    // Close the resource
    @Override
    public void close() {
        statusMessage = RESOURCE_CLOSED.getResourceState();
        logger.log(statusMessage);
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
