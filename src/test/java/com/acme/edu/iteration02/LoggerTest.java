package com.acme.edu.iteration02;

import com.acme.edu.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException, LogException {
        //region when
        //Saver consoleSaver = message -> System.out.println(message);
        Saver consoleSaver = new ConsoleSaver();
        Logger logger = new Logger(new Decorator(" ", " "), consoleSaver);
        logger.log("str 1");
        logger.log(1);
        logger.log(2);
        logger.terminate();
        logger.log("str 2");
        logger.log(0);
        logger.terminate();
        //endregion

        //region then
        assertSysoutContains(
            "str 1" + System.lineSeparator());
        assertSysoutContains(
            "3" + System.lineSeparator());
        assertSysoutContains(
            "str 2" + System.lineSeparator());
        assertSysoutContains(
            "0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws LogException {
        //region when
        //Saver consoleSaver = message -> System.out.println(message);
        Saver consoleSaver = new ConsoleSaver();
        Logger logger = new Logger(new Decorator(" ", " "), consoleSaver);
        logger.log("str 1");
        logger.log(10);
        logger.log(Integer.MAX_VALUE);
        logger.terminate();
        logger.log("str 2");
        logger.log(0);
        logger.terminate();
        //endregion

        //region then
        assertSysoutContains(
            "str 1" + System.lineSeparator());
        assertSysoutContains("10");
        assertSysoutContains(
            Integer.MAX_VALUE + System.lineSeparator());
        assertSysoutContains(
            "str 2" + System.lineSeparator());
        assertSysoutContains(
            "0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws LogException {
        //region when
        //Saver consoleSaver = message -> System.out.println(message);
        Saver consoleSaver = new ConsoleSaver();
        Logger logger = new Logger(new Decorator(" ", " "), consoleSaver);
        logger.log("str 1");
        logger.log((byte)10);
        logger.log(Byte.MAX_VALUE);
        logger.terminate();
        logger.log("str 2");
        logger.log(0);
        logger.terminate();
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("10");
        assertSysoutContains(Byte.MAX_VALUE + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        //endregion
    }


    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException, LogException {
        //region when
        //Saver consoleSaver = message -> System.out.println(message);
        Saver consoleSaver = new ConsoleSaver();
        Logger logger = new Logger(new Decorator(" ", " "), consoleSaver);
        logger.log("str 1");
        logger.log("str 2");
        logger.log("str 2");
        logger.log(0);
        logger.terminate();
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.terminate();
        //endregion

        //region then
        assertSysoutContains("str 1" + System.lineSeparator());
        assertSysoutContains("str 2 (x2)" + System.lineSeparator());
        assertSysoutContains("0" + System.lineSeparator());
        assertSysoutContains("str 2" + System.lineSeparator());
        assertSysoutContains("str 3 (x3)" + System.lineSeparator());
        //endregion
    }
}