package com.laboratorio.browsers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;
	
	public DriverManager() {
		this.driver = null;
	}
	
	protected abstract void createDriver();
	
	protected abstract void createDriver(String propiedad, String ruta);
	
	public void quitDriver() {
		if (this.driver != null) {
			this.driver.quit();
			this.driver = null;
		}
	}
	
	public WebDriver getDriver() {
		if (this.driver == null) {
			this.createDriver();
		}
		
		return driver;
	}
	
	public WebDriver getDriver(String propiedad, String ruta) {
		if (this.driver == null) {
			this.createDriver(propiedad, ruta);
		}
		
		return driver;
	}
}