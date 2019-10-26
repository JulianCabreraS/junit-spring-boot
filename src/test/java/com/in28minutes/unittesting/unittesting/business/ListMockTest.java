package com.in28minutes.unittesting.unittesting.business;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock = mock(List.class);

    @Test
    public void size_basic(){

        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    //Mocking 2 steps
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }
    @Test
    public void returnWithParameters(){
       when(mock.get(0)).thenReturn("in28Minutes");
       assertEquals("in28Minutes", mock.get(0));
    }

    @Test
    //Using argument matchers
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
    }
}
