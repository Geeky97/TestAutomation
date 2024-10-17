package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = "src/main/resources/features",
                glue = "org.example.stepDefs",
                tags = "@test",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "json: target/cucumber.json",
                        "junit: target/cucumber.html",
                        "rerun: target/cucumber.html"
                }

        )
public class runners extends AbstractTestNGCucumberTests {
}
