package com.laboratorio.pom;

import org.openqa.selenium.WebDriver;

public class NoticiasF1Page extends BasePage {
	private String tituloIdentificativo = "Fórmula 1";
	private String tituloPagina = "titulo";

	public NoticiasF1Page(WebDriver driver, String filename) {
		super(driver, filename);
	}
	
	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloPagina);
		String textoMostrado = this.getText(tituloPagina);
		return tituloIdentificativo.equals(textoMostrado);
	}
}