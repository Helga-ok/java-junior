package com.acme.edu.iteration01;

import com.acme.edu.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
    public void
    shouldLogInteger() throws IOException {
        //region when
        Saver consoleSaver = message -> System.out.println(message);
        Logger logger = new Logger(new Decorator("", ""), consoleSaver);
        logger.log(1);
        logger.log(0);
        logger.log(-1);
        logger.terminate();
        //endregion

        //region then
        assertSysoutEquals("primitive: 0" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Saver consoleSaver = message -> System.out.println(message);
        Logger logger = new Logger(new Decorator("", ""), consoleSaver);
        logger.log((byte)1);
        logger.log((byte)0);
        logger.log((byte)-1);
        logger.terminate();
        //endregion

        //region then
        assertSysoutEquals("primitive: 0" + System.lineSeparator());
        //endregion
    }


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Saver consoleSaver = message -> System.out.println(message);
        Logger logger = new Logger(new Decorator("", ""), consoleSaver);
        logger.log('a');
        logger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Saver consoleSaver = message -> System.out.println(message);
        Logger logger = new Logger(new Decorator("", ""), consoleSaver);
        logger.log("test string 1");
        logger.log("other str");
        logger.terminate();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Saver consoleSaver = message -> System.out.println(message);
        Logger logger = new Logger(new Decorator("Prefix ", " Postfix"), consoleSaver, consoleSaver);
        logger.log(true);
        logger.log(false);
        //endregion

        //region then
        assertSysoutContains("Prefix primitive: true Postfix");
        assertSysoutContains("Prefix primitive: false Postfix");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Saver consoleSaver = message -> System.out.println(message);
        Logger logger = new Logger(new Decorator("", ""), consoleSaver);
        logger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}