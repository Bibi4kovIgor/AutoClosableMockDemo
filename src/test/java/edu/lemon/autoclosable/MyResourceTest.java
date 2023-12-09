package edu.lemon.autoclosable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static edu.lemon.autoclosable.ResourceState.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MyResourceTest {
    private static MyResource resource;
    private static Logger loggerMocked;

    @BeforeAll
    static void setUp() {
        loggerMocked = mock(Logger.class);
        resource = new MyResource(loggerMocked);
    }

    @Test
    void open_setResourceStateToOpened_changesResourceState() {
        String expected = RESOURCE_IS_OPEN_TO_USE.getResourceState();
        resource.open();
        String actual = resource.getStatusMessage();

         assertEquals(expected, actual);
         verify(loggerMocked, atLeastOnce()).log(RESOURCE_IS_OPEN_TO_USE.getResourceState());
    }

    @Test
    void doSomething_changeResourceStateToDoSomeAction_changesResourceState() {
        resource.doSomething();

        assertEquals(RESOURCE_IS_BEING_USED.getResourceState(), resource.getStatusMessage());
        verify(loggerMocked, atLeastOnce()).log(RESOURCE_IS_BEING_USED.getResourceState());
    }

    @Test
    void close_setResourceStateToClosed_changesResourceState() {
        resource.close();

        assertEquals(RESOURCE_CLOSED.getResourceState(), resource.getStatusMessage());
        verify(loggerMocked, atLeastOnce()).log(RESOURCE_CLOSED.getResourceState());
    }

}