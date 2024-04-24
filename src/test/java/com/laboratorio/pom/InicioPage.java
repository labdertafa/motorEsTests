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
	private String menuRenting = "MenuRenting";
	private String menuLateral = "MenuLateral";
	private String submenuF1Lateral = "SubmenuF1Lateral";
	private String menuNoticiasLateral = "NoticiasLateral";
	private String menuF1Lateral = "F1Lateral"; 
	private String menuKm0Lateral = "Km0Lateral";
	private String menuRentingLateral = "RentingLateral";
	private String menuClasificacionF1 = "MenuClasificacionF1";
	private String menuCalendarioF1 = "MenuCalendarioF1";
	private String menuPilotosF1 = "MenuPilotosF1";
	private String menuEscuderiasF1 = "MenuEscuderiasF1";
	
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
	
	public void clickSubMenuF1Lateral() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.submenuF1Lateral);
		this.basePage.click(entity);
	}
	
	public void clicMenuKm0() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuKm0);
		this.basePage.click(entity);
	}
	
	public void clicMenuRenting() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuRenting);
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
	
	public void clickMenuRentingLateral() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuRentingLateral);
		this.basePage.click(entity);
	}
	
	public void clickMenuClasificacionF1() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuClasificacionF1);
		this.basePage.click(entity);
	}
	
	public void clickMenuCalendarioF1() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuCalendarioF1);
		this.basePage.click(entity);
	}
	
	public void clickMenuPilotosF1() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuPilotosF1);
		this.basePage.click(entity);
	}
	
	public void clickMenuEscuderiasF1() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.menuEscuderiasF1);
		this.basePage.click(entity);
	}
}