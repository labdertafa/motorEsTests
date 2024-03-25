package com.laboratorio.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected void createDriver(String propiedad, String ruta) {
		System.setProperty(propiedad, ruta);
		this.driver = new FirefoxDriver();
	}
}