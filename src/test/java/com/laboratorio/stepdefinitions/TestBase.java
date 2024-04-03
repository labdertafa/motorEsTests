package com.laboratorio.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.laboratorio.pom.CocheKm0Page;
import com.laboratorio.pom.InicioPage;
import com.laboratorio.pom.NoticiasF1Page;

public class TestBase {
	protected WebDriver driver;
	protected InicioPage inicioPage;
	protected NoticiasF1Page noticiasF1Page;
	protected CocheKm0Page cocheKm0Page;

	public TestBase() {
		this.driver = Hooks.getDriver();
		this.inicioPage = new InicioPage(driver, "inicio.json");
		this.noticiasF1Page = new NoticiasF1Page(driver, "noticiasf1.json");
		this.cocheKm0Page = new CocheKm0Page(driver, "cochekm0.json");
	}
}
