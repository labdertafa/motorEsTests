package com.laboratorio.pom;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.laboratorio.stepdefinitions.Hooks;
import com.laboratorio.utils.LogHelper;
import com.laboratorio.utils.ReadJsonHelper;

public class RentingPage {
	private static final Logger logger = LogHelper.getLogger(RentingPage.class);

	private BasePage basePage;
	private ReadJsonHelper jsonHelper;

	private String tituloIdentificativo = "Renting de coches nuevos";
	private String tituloPagina = "Titulo";
	private String opcionCompacto = "TipoCompacto";
	private String opcionSedan = "TipoSedan";
	private String opcionFamiliar = "TipoFamiliar";
	private String opcionMonovolumen = "TipoMonovolumen";
	private String opcionSuv = "TipoSuv";
	private String opcionDeportivo = "TipoDeportivo";
	private String opcionCabrio = "TipoCabrio";
	// private String botonEscogerOpcion = "EscogerOpcion";
	private String labelBotonEscogerOpcion = "SIGUIENTE";
	private String slideCouta = "SlideCouta";
	private String slideMeses = "SlideMeses";
	private String slideKilometros = "SlideKilometros";
	public String botonVerOfertas = "VerOfertas";
	public String botonVerOfertasMovil = "VerOfertasMovil";
	private String tituloIdentificativoOfertas = "Ofertas de renting";
	private String tituloPaginaOfertas = "TituloOfertas";
	private String botonNoAceptar = "NoAceptar";

	public RentingPage(BasePage basePage, String filename) {
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
		logger.log(Level.INFO, "Título de la página: [" + textoMostrado + "]");
		return textoMostrado.equals(tituloIdentificativo);
	}

	public boolean isOfertasDisplayed() throws Exception {
		Thread.sleep(1000);
		JSONObject entity = this.jsonHelper.getEntity(this.tituloPaginaOfertas);
		String textoMostrado = this.basePage.getText(entity);
		logger.log(Level.INFO, "Título de la página: [" + textoMostrado + "]");
		return textoMostrado.equals(tituloIdentificativoOfertas);
	}

	public void seleccionarOpcionRenting(String opcion) throws Exception {
		// Esto eJSONObject entity;
		String id;

		switch (opcion) {
		case "Pequeño o compacto":
			// entity = this.jsonHelper.getEntity(this.opcionCompacto);
			id = this.jsonHelper.getValue(this.opcionCompacto);
			break;
		case "Sedán / Berlina":
			// entity = this.jsonHelper.getEntity(this.opcionSedan);
			id = this.jsonHelper.getValue(this.opcionSedan);
			break;
		case "Familiar":
			// entity = this.jsonHelper.getEntity(this.opcionFamiliar);
			id = this.jsonHelper.getValue(this.opcionFamiliar);
			break;
		case "Monovolumen":
			// entity = this.jsonHelper.getEntity(this.opcionMonovolumen);
			id = this.jsonHelper.getValue(this.opcionMonovolumen);
			break;
		case "Suv y 4x4":
			// entity = this.jsonHelper.getEntity(this.opcionSuv);
			id = this.jsonHelper.getValue(this.opcionSuv);
			break;
		case "Deportivo o coupe":
			// entity = this.jsonHelper.getEntity(this.opcionDeportivo);
			id = this.jsonHelper.getValue(this.opcionDeportivo);
			break;
		case "Cabrio":
			// entity = this.jsonHelper.getEntity(this.opcionCabrio);
			id = this.jsonHelper.getValue(this.opcionCabrio);
			break;
		default:
			throw new Exception("Opción de renting inexistente");
		}
		// this.basePage.click(entity);
		this.basePage.marcarTipoCoche(id);
	}

	public void confirmarOpcion() throws Exception {
		if (Hooks.isApliMovil()) {
			this.basePage.scrollDown(2);
			JSONObject entity = this.jsonHelper.getEntity(this.botonNoAceptar);
			this.basePage.click(entity);
		}
		this.basePage.clickButtonByLabel(labelBotonEscogerOpcion);
	}

	public void indicarCouta(int couta) throws Exception {
		this.basePage.waitPageLoading();

		// int posicion = (int)((couta / 1600.0) * 16);
		JSONObject entity = this.jsonHelper.getEntity(this.slideCouta);
		this.basePage.posicionarSlider(entity, couta);
	}

	public void indicarMeses(int meses) throws Exception {
		// int posicion = (int)((meses / 60.0) * 7);
		JSONObject entity = this.jsonHelper.getEntity(this.slideMeses);
		this.basePage.posicionarSlider(entity, meses);
	}

	public void indicarKilomemtros(int kilometros) throws Exception {
		// int posicion = (int)((kilometros/65000.0) * 13 - 1);
		JSONObject entity = this.jsonHelper.getEntity(this.slideKilometros);
		this.basePage.posicionarSlider(entity, kilometros);
	}

	public void verOfertas() throws Exception {
		JSONObject entity;

		if (!Hooks.isApliMovil()) {
			this.basePage.scrollDown(1);
			entity = this.jsonHelper.getEntity(this.botonVerOfertas);
		} else {
			entity = this.jsonHelper.getEntity(this.botonVerOfertasMovil);
		}
		this.basePage.click(entity);
	}
}