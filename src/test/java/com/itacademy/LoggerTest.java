package com.itacademy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {

    private static final Logger LOGGER = LogManager.getLogger(LoggerTest.class);

    @Test
    public void logerTest() {
        LOGGER.info("info");
        LOGGER.error("error");
    }
}
