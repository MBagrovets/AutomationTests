package com.itacademy.testNgexample;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestNgTest {
    int count = 0;

    @Test()
    public void retryTest() {
        count++;
        assertEquals(3, count);
    }
}
