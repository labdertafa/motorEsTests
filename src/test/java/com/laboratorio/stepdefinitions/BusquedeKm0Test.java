package com.laboratorio.stepdefinitions;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

import com.laboratorio.utils.LogHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusquedeKm0Test extends TestBase {
	private static final Logger logger = LogHelper.getLogger(BusquedeKm0Test.class);
	
	private void irALaPaginaBusquedaKm0() throws Exception {
		Assert.assertTrue(inicioPage.isDisplayed());
		inicioPage.aceptarCookies();
		inicioPage.mostrarMenuLateral();
		inicioPage.clickMenuKm0Lateral();
	}
	
	@Given("que el usuario esta en la pagina de busqueda de coches Km0")
	public void queElUsuarioEstaEnLaPaginaDeBusquedaDeCochesKm0() throws Exception {
		logger.log(Level.INFO, "Situarse en la página de búsqueda de coches Km 0");
	    this.irALaPaginaBusquedaKm0();
	    Assert.assertTrue(cocheKm0Page.isDisplayed());
	}

	@When("el usuario seleciona la marca {string} y el modelo {string} del coche que quiere buscar")
	public void elUsuarioSelecionaLaMarcaYElModeloDelCocheQueQuiereBuscar(String marca, String nodelo) throws Exception {
	    logger.log(Level.INFO, "Seleccionar la marca, el modelo y ejecutar la búsqueda");
	    if (Hooks.isApliMovil()) {
	    	cocheKm0Page.desplegarFiltros();
	    }
	    cocheKm0Page.seleccionarMarca(marca);
	    cocheKm0Page.seleccionarModelo(nodelo);
	}

	@Then("se muestra el resultado de la busqueda efectuada")
	public void seMuestraElResultadoDeLaBusquedaEfectuada() throws Exception {
		logger.log(Level.INFO, "Verificar que la búsqueda se efectuó correctamente");
	}
}