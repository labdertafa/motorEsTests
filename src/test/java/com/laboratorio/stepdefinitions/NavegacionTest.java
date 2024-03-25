package com.laboratorio.stepdefinitions;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

import com.laboratorio.utils.LogHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NavegacionTest extends TestBase {
	private static final Logger logger = LogHelper.getLogger(NavegacionTest.class);
	
	@Given("que el usuario esta en la pagina de inicio")
	public void queElUsuarioEstaEnLaPaginaDeInicio() throws Exception {
		logger.log(Level.INFO, "El usuario está en la página de inicio");
		Assert.assertTrue(inicioPage.isDisplayed());
	}

	@When("el usuario hace click en la opcion formula1 del menu")
	public void elUsuarioHaceClickEnLaOpcionFormula1DelMenu() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opción fórmula 1 del menú");
		inicioPage.aceptarCookies();
		inicioPage.clickMenuFormula1();
	}

	@Then("se muestra la pagina de noticias de la formula1")
	public void seMuestraLaPaginaDeNoticiasDeLaFormula1() throws Exception {
		logger.log(Level.INFO, "Se muestra la página de noticias de la fórmula 1");
		Assert.assertTrue(noticiasF1Page.isDisplayed());
	}
	
	@When("el usuario despliega el menu lateral")
	public void elUsuarioDespliegaElMenuLateral() throws Exception {
		logger.log(Level.INFO, "El usuario despliega el menú lateral");
		inicioPage.aceptarCookies();
		inicioPage.mostrarMenuLateral();
	}

	@When("el usuario hace click en la opcion formula1 del menu lateral")
	public void elUsuarioHaceClickEnLaOpcionFormula1DelMenuLateral() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opcion fórmula 1 del menú lateral");
		inicioPage.clickMenuF1Lateral();
	}
}