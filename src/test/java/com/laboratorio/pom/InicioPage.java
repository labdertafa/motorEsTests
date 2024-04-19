package com.laboratorio.pom;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.laboratorio.stepdefinitions.Hooks;
import com.laboratorio.utils.LogHelper;
import com.laboratorio.utils.ReadJsonHelper;

public class InicioPage {
	private BasePage basePage;
	private ReadJsonHelper jsonHelper;
	
	private static final Logger logger = LogHelper.getLogger(InicioPage.class);
	/*private String tituloIdentificativo = "No busques, encuentra tu coche.";
	private String tituloBusqueda = "tituloBusqueda"; */
	private String tituloPagina = "Motor.es / Coches nuevos / Coches segunda mano / Actualidad motor / F1";
	private String botonAceptarCookies = "aceptar_cookies";
	private String menuNoticias = "MenuNoticias";
	private String menuFormula1 = "MenuFormula1";
	private String menuKm0 = "MenuKm0";
	private String menuLateral = "MenuLateral";
	private String menuNoticiasLateral = "NoticiasLateral";
	private String menuF1Lateral = "F1Lateral"; 
	private String menuKm0Lateral = "Km0Lateral";
	
	public InicioPage(BasePage basePage, String filename) {
		this.basePage = basePage;
		
		String pagesFilePath = Hooks.rutaDefinicionPaginas() + filename;
		try {
			this.jsonHelper = new ReadJsonHelper(pagesFilePath);
		} catch (Exception e) {
			this.jsonHelper = null;
		}
	}

	public boolean isDisplayed() throws Exception {
		/* this.waitForElement(tituloBusqueda);
		String textoMostrado = this.getText(tituloBusqueda);
		return tituloIdentificativo.equals(textoMostrado); */

		String tituloCapturado = this.basePage.getTitle().trim();
		logger.log(Level.INFO, "Título de la página: [" + tituloCapturado + "]");
		return tituloCapturado.equalsIgnoreCase(this.tituloPagina);
	}
	
	public void aceptarCookies() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.botonAceptarCookies);
		this.basePage.click(entity);
	}
	
	public void clickMenuNoticias() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuNoticias);
		this.basePage.click(entity);
	}
	
	public void clickMenuFormula1() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuFormula1);
		this.basePage.click(entity);
	}
	
	public void clicMenuKm0() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuKm0);
		this.basePage.click(entity);
	}
	
	public void mostrarMenuLateral() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuLateral);
		this.basePage.click(entity);
	}
	
	public void clickMenuNoticiasLateral() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuNoticiasLateral);
		this.basePage.click(entity);
	}
	
	public void clickMenuF1Lateral() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuF1Lateral);
		this.basePage.click(entity);
	}
	
	public void clickMenuKm0Lateral() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuKm0Lateral);
		this.basePage.click(entity);
	}
}