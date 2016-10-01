package com.microservicesteam.nutaxi.route;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true, 
    features = { "classpath:features/route" }, 
    glue = { "com.microservicesteam.nutaxi.route.steps" }, 
    plugin = { "pretty",
        "html:target/test-report",
        "json:target/test-report.json",
        "junit:target/test-report.xml" }
)
public class RouteTest {
    
}
