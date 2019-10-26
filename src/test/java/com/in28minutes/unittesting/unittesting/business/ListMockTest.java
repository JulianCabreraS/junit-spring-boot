package com.in28minutes.unittesting.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

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

    @Test
    //Using verification
    public void verificationBasics(){
        //SUT
        String value = mock.get(0);
        //Verify
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(2)).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    //Argument capture
    public void argumentCapturing(){
        //SUT
        mock.add("SomeString");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    //Argument capture with multiple times
    public void multipleArgumentCapturing(){
        //SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    //Using spy in a class
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test 0");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());

        //Once you stub, size is always 5
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());

    }
}


