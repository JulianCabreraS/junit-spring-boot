package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatch() throws JSONException {
        String expectedResponse ="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        //Strict evaluation

        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
}
