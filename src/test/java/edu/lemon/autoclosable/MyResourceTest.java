package edu.lemon.autoclosable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyResourceTest {
    private static final String RESOURCE_IS_OPEN_TO_USE = "Resource is open to use";
    private static final String RESOURCE_IS_BEING_USED = "Resource is being used";
    private static final String RESOURCE_CLOSED = "Resource closed";

    private static MyResource resource;
    private static Logger loggerMocked;

    @BeforeAll
    static void setUp() {
        loggerMocked = mock(Logger.class);
        resource = new MyResource(loggerMocked);
    }

    @Test
    void open_setResourceStateToOpened_changesResourceState() {
         resource.open();

         assertEquals(RESOURCE_IS_OPEN_TO_USE, resource.getStatusMessage());
         verify(loggerMocked, atLeastOnce()).log(RESOURCE_IS_OPEN_TO_USE);
    }

    @Test
    void doSomething_changeResourceStateToDoSomeAction_changesResourceState() {
        resource.doSomething();

        assertEquals(RESOURCE_IS_BEING_USED, resource.getStatusMessage());
        verify(loggerMocked, atLeastOnce()).log(RESOURCE_IS_BEING_USED);
    }

    @Test
    void close_setResourceStateToClosed_changesResourceState() {
        resource.close();

        assertEquals(RESOURCE_CLOSED, resource.getStatusMessage());
        verify(loggerMocked, atLeastOnce()).log(RESOURCE_CLOSED);
    }

}