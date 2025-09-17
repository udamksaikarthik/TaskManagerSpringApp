package com.karthik.taskmanager.cucumbertestrunner;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")  // folder containing .feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.karthik.taskmanager.stepdefinitions")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, json:target/cucumber-report/cucumber.json")
public class CucumberTestRunner {
}
