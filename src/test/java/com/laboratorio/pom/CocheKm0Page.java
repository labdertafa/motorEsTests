package com.laboratorio.pom;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.laboratorio.stepdefinitions.Hooks;
import com.laboratorio.utils.ReadJsonHelper;

public class CocheKm0Page {
	private BasePage basePage;
	private ReadJsonHelper jsonHelper;
	
	private String tituloIdentificativo = "Coches de Km 0";
	private String tituloPagina = "titulo";
	private String botonFiltrar = "BotonFiltrar";
	private String selectorMarca = "SelectorMarca";
	private String listaMarcas = "ListaMarcas";
	private String selectorModelo = "SelectorModelo";
	private String listaModelos = "ListaModelos";
	private String precioMinimo = "PrecioMinimo";
	private String precioMaximo = "PrecioMaximo";
	private String anioMinimo = "AnioMinimo";
	private String anioMaximo = "AnioMaximo";
	private String kilometroMinimo = "KilometroMinimo";
	private String kilometroMaximo = "KilometroMaximo";
	private String tipoCombustible = "TipoCombustible";
	
	public CocheKm0Page(BasePage basePage, String filename) {
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
	
	public void desplegarFiltros() throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.botonFiltrar);
		this.basePage.click(entity);
		Thread.sleep(2000);
	}
	
	public void seleccionarMarca(String marca) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.selectorMarca);
		this.basePage.click(entity);
		entity = this.jsonHelper.getEntity(this.listaMarcas);
		if (!this.basePage.clickEnElementoDeLista(entity, marca)) {
			throw new Exception("El elemento indicado no existe en la lista de marcas");
		}
	}
	
	public void seleccionarModelo(String modelo) throws Exception {
		Thread.sleep(2000);
		JSONObject entity = this.jsonHelper.getEntity(this.selectorModelo);
		this.basePage.click(entity);
		entity = this.jsonHelper.getEntity(this.listaModelos);
		if (!this.basePage.clickEnElementoDeLista(entity, modelo)) {
			throw new Exception("El elemento indicado no existe en la lista de modelos");
		}
	}
	
	public void hacerScroll(int n) throws Exception {
		this.basePage.waitPageLoading();
		this.basePage.scrollDown(n);
	}
	
	public void seleccionarPrecioMinimo(Integer precio) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.precioMinimo);
		this.basePage.seleccionarEnCombo(entity, precio.toString());
	}
	
	public void seleccionarPrecioMaximo(Integer precio) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.precioMaximo);
		this.basePage.seleccionarEnCombo(entity, precio.toString());
	}
	
	public void seleccionarAnioMinimo(Integer anio) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.anioMinimo);
		this.basePage.seleccionarEnCombo(entity, anio.toString());
	}
	
	public void seleccionarAnioMaximo(Integer anio) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.anioMaximo);
		this.basePage.seleccionarEnCombo(entity, anio.toString());
	}
	
	public void seleccionarKilometrajeMinimo(Integer kilometro) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.kilometroMinimo);
		this.basePage.seleccionarEnCombo(entity, kilometro.toString());
	}
	
	public void seleccionarKilometrajeMaximo(Integer kilometro) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.kilometroMaximo);
		this.basePage.seleccionarEnCombo(entity, kilometro.toString());
	}
	
	public void seleccionarTipoCombustible(String combustible) throws Exception {
		JSONObject entity = this.jsonHelper.getEntity(this.tipoCombustible);
		this.basePage.seleccionarEnComboPorTexto(entity, combustible);
	}
}