package com.joantolos.kata.mars.rover.acceptance;

import com.joantolos.kata.mars.rover.ui.Console;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleSteps {

    private Console console;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Given("^The console from the Mars Rover$")
    public void theConsoleFromTheMarsRover() {
        this.console = new Console();
    }

    @When("^I perform the exit operation$")
    public void iPerformTheExitOperation() {
        System.setOut(new PrintStream(outContent));
        this.console.exit();
    }

    @When("^I perform the prompt operation$")
    public void iPerformThePromptOperation() {
        System.setOut(new PrintStream(outContent));
        this.console.prompt();
    }

    @When("^I perform the print operation with the text \"([^\"]*)\"$")
    public void iPerformThePrintOperationWithTheText(String textToPrint) {
        System.setOut(new PrintStream(outContent));
        this.console.print(textToPrint);
    }

    @Then("^the system prints \"([^\"]*)\"$")
    public void theSystemPrints(String expectedPrint) {
        Assert.assertTrue(outContent.toString().contains(expectedPrint));
    }
}
