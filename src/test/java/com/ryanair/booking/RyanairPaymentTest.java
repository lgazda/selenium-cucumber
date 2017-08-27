package com.ryanair.booking;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "json:target/cucumber/ryanair.json",
                "html:target/cucumber/ryanair.html",
                "pretty"
        },
        features = {"src/test/resources/features/ryanairpayment.feature"}
)
public class RyanairPaymentTest {
}
