package com.laboratorio.pom;

import org.openqa.selenium.WebDriver;

public class InicioPage extends BasePage {
	private String tituloIdentificativo = "No busques, encuentra tu coche.";
	private String tituloBusqueda = "tituloBusqueda";
	private String botonAceptarCookies = "aceptar_cookies"; 
	private String menuFormula1 = "menuFormula1";
	private String menuKm0 = "menuKm0";
	private String menuLateral = "menuLateral";
	private String menuF1Lateral = "f1Lateral"; 
	private String menuKm0Lateral = "km0Lateral";

	public InicioPage(WebDriver driver, String filename) {
		super(driver, filename);
	}

	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloBusqueda);
		String textoMostrado = this.getText(tituloBusqueda);
		return tituloIdentificativo.equals(textoMostrado);
	}
	
	public void aceptarCookies() throws Exception {
		this.click(botonAceptarCookies);
	}
	
	public void clickMenuFormula1() throws Exception {
		this.click(menuFormula1);
	}
	
	public void clicMenuKm0() throws Exception {
		this.click(menuKm0);
	}
	
	public void mostrarMenuLateral() throws Exception {
		this.click(menuLateral);
	}
	
	public void clickMenuF1Lateral() throws Exception {
		this.click(menuF1Lateral);
	}
	
	public void clickMenuKm0Lateral() throws Exception {
		this.click(menuKm0Lateral);
	}
}