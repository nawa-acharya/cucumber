package com.marathon.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Nawa
 *         Created on: 10/4/2018.
 *         Modified on: 10/4/2018
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"})
public class LoginScenarioOutlineRunTest {
}
