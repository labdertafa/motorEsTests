package com.laboratorio.browsers;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
		this.driver = new EdgeDriver();
	}
	
	@Override
	protected void createDriver(String propiedad, String ruta) {
		System.setProperty(propiedad, ruta);
		this.driver = new EdgeDriver();
	}
}