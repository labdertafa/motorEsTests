package com.laboratorio.stepdefinitions;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

import com.laboratorio.utils.LogHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RentingTest extends TestBase {
	private static final Logger logger = LogHelper.getLogger(RentingTest.class);
	
	private void irALaPaginaRenting() throws Exception {
		Assert.assertTrue(inicioPage.isDisplayed());
		inicioPage.aceptarCookies();
		inicioPage.mostrarMenuLateral();
		inicioPage.clickMenuRentingLateral();
	}
	
	@Given("que el usuario esta en la pagina de renting")
	public void queElUsuarioEstaEnLaPaginaDeRenting() throws Exception {
		logger.log(Level.INFO, "Situarse en la página de renting");
		irALaPaginaRenting();
		Assert.assertTrue(rentingPage.isDisplayed());
	}

	@When("el usuario hace click en la opcion {string}")
	public void elUsuarioHaceClickEnLaOpcion(String opcion) throws Exception {
		logger.log(Level.INFO, "El usuario escoge la opción de renting: " + opcion);
		rentingPage.seleccionarOpcionRenting(opcion);
		rentingPage.confirmarOpcion();
	}

	@When("el usuario indica la couto máxima {int}, les meses de renting {int} y los kilometros por anio {int}")
	public void elUsuarioIndicaLaCoutoMáximaLesMesesDeRentingYLosKilometrosPorAnio(Integer cuota, Integer meses, Integer kilometros) throws Exception {
		logger.log(Level.INFO, "El usuario indica la couta, los meses y el kilometraje");
		rentingPage.indicarCouta(cuota);
		rentingPage.indicarMeses(meses);
		rentingPage.indicarKilomemtros(kilometros);
		rentingPage.verOfertas();
	}

	@Then("se muestran las ofertas disponibles con los filtros indicados")
	public void seMuestranLasOfertasDisponiblesConLosFiltrosIndicados() throws Exception {
		logger.log(Level.INFO, "Se muestra la página con las ofertas disponibles para las opciones indicadas");
		Assert.assertTrue(rentingPage.isOfertasDisplayed());
	}
}