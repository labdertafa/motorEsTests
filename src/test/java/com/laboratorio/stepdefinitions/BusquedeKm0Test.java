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

/* *****************************************************************
	Pasos asociados a la búsqueda de coches por marca y modelo
   ***************************************************************** */
	@Given("que el usuario esta en la pagina de busqueda de coches Km0")
	public void queElUsuarioEstaEnLaPaginaDeBusquedaDeCochesKm0() throws Exception {
		logger.log(Level.INFO, "Situarse en la página de búsqueda de coches Km 0");
	    this.irALaPaginaBusquedaKm0();
	    Assert.assertTrue(cocheKm0Page.isDisplayed());
	}

	@When("el usuario seleciona la marca {string} y el modelo {string} del coche que quiere buscar")
	public void elUsuarioSelecionaLaMarcaYElModeloDelCocheQueQuiereBuscar(String marca, String nodelo) throws Exception {
	    logger.log(Level.INFO, "El usuario selecciona la marca, el modelo y ejecuta la búsqueda");
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

/* *****************************************************************
	Pasos asociados a la búsqueda de coches por precio y año
   ***************************************************************** */
	@When("el usuario seleciona el precio minimo {int} y el precio maximo {int} del coche")
	public void elUsuarioSelecionaElPrecioMinimoYElPrecioMaximoDelCoche(Integer precioMinimo, Integer precioMaximo) throws Exception {
		logger.log(Level.INFO, "El usuario selecciona el precio mínimo y el precio máximo del coche");
		if (Hooks.isApliMovil()) {
	    	cocheKm0Page.desplegarFiltros();
	    	cocheKm0Page.hacerScroll(2);
	    } else {
	    	cocheKm0Page.hacerScroll(1);
	    }
		cocheKm0Page.seleccionarPrecioMinimo(precioMinimo);
		cocheKm0Page.seleccionarPrecioMaximo(precioMaximo);
	}

	@When("el usuario seleciona el anio minimo {int} y el anio maximo {int} del coche")
	public void elUsuarioSelecionaElAnioMinimoYElAnioMaximoAniiMaxDelCoche(Integer anioMinimo, Integer anioMaximo) throws Exception {
		logger.log(Level.INFO, "El usuario selecciona el año mínimo y el año máximo del coche");
		cocheKm0Page.seleccionarAnioMinimo(anioMinimo);
		cocheKm0Page.seleccionarAnioMaximo(anioMaximo);
	}
	
/* *****************************************************************
	Pasos asociados a la búsqueda de coches por kilometraje y combustible
   ***************************************************************** */
	@When("el usuario seleciona el kilometraje minimo {int} y el kilometraje maximo {int} del coche")
	public void el_usuario_seleciona_el_kilometraje_minimo_y_el_kilometraje_maximo_del_coche(Integer kmMinimo, Integer kmMaximo) throws Exception {
		logger.log(Level.INFO, "El usuario selecciona el kilometraje mínimo y el kilometraje máximo del coche");
		if (Hooks.isApliMovil()) {
	    	cocheKm0Page.desplegarFiltros();
	    	cocheKm0Page.hacerScroll(3);
	    } else {
	    	// cocheKm0Page.hacerScroll(2);
	    }
		cocheKm0Page.seleccionarKilometrajeMinimo(kmMinimo);
		cocheKm0Page.seleccionarKilometrajeMaximo(kmMaximo);
	}

	@When("el usuario seleciona el tipo de combustible {string}")
	public void el_usuario_seleciona_el_tipo_de_combustible(String combustible) throws Exception {
		logger.log(Level.INFO, "El usuario selecciona el tipo de combustible del coche");
		cocheKm0Page.seleccionarTipoCombustible(combustible);
	}
}