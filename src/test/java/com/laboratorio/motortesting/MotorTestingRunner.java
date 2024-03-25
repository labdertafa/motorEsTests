package com.laboratorio.motortesting;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.laboratorio.utils.LogHelper;

import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.laboratorio.stepdefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "summary", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		snippets = SnippetType.CAMELCASE
		
)
public class MotorTestingRunner {
	private static final Logger logger = LogHelper.getLogger(MotorTestingRunner.class);
	
	@BeforeClass
	public static void setUpTests() {
		logger.log(Level.INFO, "Ejecutando setUpTests()");
	}
	
	@AfterClass
	public static void tearDownTests() {
		logger.log(Level.INFO, "Ejecutando tearDownTests()");
	}
}