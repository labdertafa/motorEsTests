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

/* *****************************************************************
	Pasos asociados a navegar a la página de F1 con menú principal
   ***************************************************************** */
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
	
/* *****************************************************************
	Pasos asociados a navegar a la página de F1 con menú lateral
   ***************************************************************** */
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
	
/* *****************************************************************
	Pasos asociados a navegar a la página Km 0 con menú principal
   ***************************************************************** */
	@When("el usuario hace click en la opcion coche Km0 del menu")
	public void el_usuario_hace_click_en_la_opcion_coche_km0_del_menu() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opción coches Km 0 del menú");
		inicioPage.aceptarCookies();
		inicioPage.clicMenuKm0();
	}

	@Then("se muestra la pagina de busqueda de coches Km0")
	public void se_muestra_la_pagina_de_busqueda_de_coches_km0() throws Exception {
		logger.log(Level.INFO, "Se muestra la página de búsqueda de coches de Km 0");
		Assert.assertTrue(cocheKm0Page.isDisplayed());
	}

/* *****************************************************************
   Pasos asociados a navegar a la página Km 0 con menú lateral
   ***************************************************************** */
	@When("el usuario hace click en la opcion coche Km0 del menu lateral")
	public void el_usuario_hace_click_en_la_opcion_coche_km0_del_menu_lateral() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opcion Coches Km 0 del menú lateral");
		inicioPage.clickMenuKm0Lateral();
	}

/* *****************************************************************
	Pasos asociados a navegar a la página de noticias con menú principal
   ***************************************************************** */
	@When("el usuario hace click en la opcion Noticias del menu")
	public void el_usuario_hace_click_en_la_opcion_noticias_del_menu() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opción Noticias del menú");
		inicioPage.aceptarCookies();
		inicioPage.clickMenuNoticias();
	}

	@Then("se muestra la pagina de Noticias")
	public void se_muestra_la_pagina_de_noticias() throws Exception {
		logger.log(Level.INFO, "Se muestra la página de noticias");
		Assert.assertTrue(noticiasPage.isDisplayed());
	}

/* *****************************************************************
	Pasos asociados a navegar a la página de noticias con menú lateral
   ***************************************************************** */
	@When("el usuario hace click en la opcion Noticias del menu lateral")
	public void el_usuario_hace_click_en_la_opcion_noticias_del_menu_lateral() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opcion Noticias del menú lateral");
		inicioPage.clickMenuNoticiasLateral();
	}

/* *****************************************************************
	Pasos asociados a navegar a la página de clasificación del campeonato
	de fórmula usando el menú lateral
   ***************************************************************** */
	@When("el usuario despliega el submenu formula1")
	public void el_usuario_despliega_el_submenu_formula1() throws Exception {
		logger.log(Level.INFO, "El usuario despliega el submenú lateral Fórmula 1");
	    inicioPage.clickSubMenuF1Lateral();
	}

	@When("el usuario hace click en la opcion que contiene la palabra clasificacion")
	public void el_usuario_hace_click_en_la_opcion_que_contiene_la_palabra_clasificacion() throws Exception {
	    logger.log(Level.INFO, "El usuario hace click en la opción que contiene la palabra clasificación");
	    inicioPage.clickMenuClasificacionF1();
	}

	@Then("se muestra la pagina con la clasificacion del campeonato de formula1")
	public void se_muestra_la_pagina_con_la_clasificacion_del_campeonato_de_formula() throws Exception {
		logger.log(Level.INFO, "Se muestra la página de clasificación del campeonato de fórmula 1");
		Assert.assertTrue(clasificacionPage.isDisplayed());
	}

/* *****************************************************************
	Pasos asociados a navegar a la página del calendario del campeonato
	de fórmula usando el menú lateral
   ***************************************************************** */
	@When("el usuario hace click en la opcion que contiene la palabra calendario")
	public void el_usuario_hace_click_en_la_opcion_que_contiene_la_palabra_calendario() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opción que contiene la palabra calendario");
	    inicioPage.clickMenuCalendarioF1();
	}

	@Then("se muestra la pagina con el calendario del campeonato de formula1")
	public void se_muestra_la_pagina_con_el_calendario_del_campeonato_de_formula() throws Exception {
		logger.log(Level.INFO, "Se muestra la página del calendario del campeonato de fórmula 1");
		Assert.assertTrue(calendarioPage.isDisplayed());
	}

/* *****************************************************************
	Pasos asociados a navegar a la página de los pilotos del campeonato
	de fórmula usando el menú lateral
   ***************************************************************** */
	@When("el usuario hace click en la opcion pilotos")
	public void el_usuario_hace_click_en_la_opcion_pilotos() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opción Pilotos");
	    inicioPage.clickMenuPilotosF1();
	}

	@Then("se muestra la pagina con los pilotos del campeonato de formula1")
	public void se_muestra_la_pagina_con_los_pilotos_del_campeonato_de_formula() throws Exception {
		logger.log(Level.INFO, "Se muestra la página de los pilotos del campeonato de fórmula 1");
		Assert.assertTrue(pilotosF1Page.isDisplayed());
	}

/* *****************************************************************
	Pasos asociados a navegar a la página de las escuderías del campeonato
	de fórmula usando el menú lateral
   ***************************************************************** */
	@When("el usuario hace click en la opcion escuderias")
	public void el_usuario_hace_click_en_la_opcion_escuderias() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opción Escuderías");
	    inicioPage.clickMenuEscuderiasF1();
	}

	@Then("se muestra la pagina con las escuderias del campeonato de formula1")
	public void se_muestra_la_pagina_con_las_escuderias_del_campeonato_de_formula() throws Exception {
		logger.log(Level.INFO, "Se muestra la página de las escuderías del campeonato de fórmula 1");
		Assert.assertTrue(escuderiasF1Page.isDisplayed());
	}
	
/* *****************************************************************
	Pasos asociados a navegar a la página de renting con menú principal
   ***************************************************************** */
	@When("el usuario hace click en la opcion renting del menu")
	public void el_usuario_hace_click_en_la_opcion_renting_del_menu() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opción renting del menú");
		inicioPage.aceptarCookies();
		inicioPage.clicMenuRenting();
	}

	@Then("se muestra la pagina de principal de renting")
	public void se_muestra_la_pagina_de_principal_de_renting() throws Exception {
		logger.log(Level.INFO, "Se muestra la página de principal de renting");
		Assert.assertTrue(rentingPage.isDisplayed());
	}

/* *****************************************************************
	   Pasos asociados a navegar a la página de renting con menú lateral
	   ***************************************************************** */
	@When("el usuario hace click en la opcion renting del menu lateral")
	public void el_usuario_hace_click_en_la_opcion_renting_del_menu_lateral() throws Exception {
		logger.log(Level.INFO, "El usuario hace click en la opcion Renting del menú lateral");
		inicioPage.clickMenuRentingLateral();
	}
}