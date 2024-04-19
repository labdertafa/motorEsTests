package com.laboratorio.pom;

import org.json.simple.JSONObject;

import com.laboratorio.stepdefinitions.Hooks;
import com.laboratorio.utils.ReadJsonHelper;

public class NoticiasPage {
	private BasePage basePage;
	private ReadJsonHelper jsonHelper;
	
	private String tituloIdentificativo = "Noticias y novedades de motor";
	private String tituloPagina = "Titulo";
	
	public NoticiasPage(BasePage basePage, String filename) {
		this.basePage = basePage;
		
		String pagesFilePath = Hooks.rutaDefinicionPaginas() + filename;
		try {
			this.jsonHelper = new ReadJsonHelper(pagesFilePath);
		} catch (Exception e) {
			this.jsonHelper = null;
		}
	}
	
	public boolean isDisplayed() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.tituloPagina);
		String textoMostrado = this.basePage.getText(entity);
		return tituloIdentificativo.equals(textoMostrado);
	}
}