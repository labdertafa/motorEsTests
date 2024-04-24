package com.laboratorio.motortesting;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = false,
		features = "src/test/resources/features",
		glue = {"com.laboratorio.stepdefinitions"},
		plugin = {"pretty", "summary", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		snippets = SnippetType.CAMELCASE,
		tags = "@movil"
)
public class MotorTest {
}