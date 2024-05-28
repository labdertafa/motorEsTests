package com.laboratorio.browsers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
		this.driver = new ChromeDriver();
	}
	
	@Override
	protected void createDriver(String propiedad, String ruta) {
		System.setProperty(propiedad, ruta);
		this.driver = new ChromeDriver();
	}
}