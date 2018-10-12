package com.marathon.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Nawa
 *         Created on: 10/4/2018.
 *         Modified on: 10/4/2018
 */
public class LoginScenarioOutline {
    private WebDriver driver = null;

    @BeforeClass
    public static void initDriverBeforeLoad() {
        System.out.println("Initializing driver before Given gives Run time error.");
    }

    @Given("^I navigate to Construction Website$")
    public void setUpDriver() {
        System
                .setProperty(
                        "webdriver.gecko.driver",
                        "C:\\Users\\Nawa\\Downloads\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://webapps.marathoncs.com:8080/webcon/");
    }

    @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void userInput(String arg1, String arg2) {
        // Our application is built inside a frame (may be the JSF builds it into one)
        // Tell selenium to find the frame
        // not adding this statement gives NoSuchElementException: Unable to locate element
        driver.switchTo().frame("bottomFrame");

        //get the component by id, it supports other CSS selectors as well
        driver.findElement(By.id("loginForm:username")).sendKeys(arg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(arg2);
    }

    @Then("^Login should be checked$")
    public void checkLogin() {
        //create a condition to check
        //if main menu is rendered,
        //.ca-menu is css class used in every menu option
        //if this is found, login is successful else fail
        //driver.switchTo().frame("bottomFrame");
        try {
            System.out.println(driver.getPageSource());
            driver.findElement(By.className("ca-menu"));
            System.out.println("Login successful: Showing main menu");
        } catch (NoSuchElementException ex) {
            System.out.println("Login unsuccessful: Showing error message");
            ex.printStackTrace();
        } finally {
            driver.close();
        }
    }
}
