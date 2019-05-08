package com.joantolos.kata.mars.rover.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldPrintExit() {
        new Console().exit();
        Assert.assertEquals("\nDisconnected from Mars rover\n\n", outContent.toString());
    }

    @Test
    public void shouldPrintRandomText() {
        new Console().print("Random Text");
        Assert.assertEquals("Random Text\n", outContent.toString());
    }

    @Test
    public void shouldPrompt() {
        new Console().prompt();
        Assert.assertTrue(outContent.toString().contains("Your rover is located by default at the 0, 0 position and it's facing North."));
    }
}
