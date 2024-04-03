package com.laboratorio.pom;

import org.openqa.selenium.WebDriver;

public class CocheKm0Page extends BasePage {
	private String tituloIdentificativo = "Coches de Km 0";
	private String tituloPagina = "titulo";
	
	public CocheKm0Page(WebDriver driver, String filename) {
		super(driver, filename);
	}
	
	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloPagina);
		String textoMostrado = this.getText(tituloPagina);
		return tituloIdentificativo.equals(textoMostrado);
	}
}