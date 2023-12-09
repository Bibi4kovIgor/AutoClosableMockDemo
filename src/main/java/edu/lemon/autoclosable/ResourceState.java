package edu.lemon.autoclosable;

public enum ResourceState {
    RESOURCE_IS_OPEN_TO_USE("Resource is open to use"),
    RESOURCE_IS_BEING_USED("Resource is being used"),
    RESOURCE_CLOSED ("Resource closed");

    private final String resourceState;
    ResourceState(String resourceState) {
        this.resourceState = resourceState;
    }


    public String getResourceState() {
        return resourceState;
    }
}
