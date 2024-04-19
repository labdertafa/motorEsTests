package com.laboratorio.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.laboratorio.pom.BasePage;
import com.laboratorio.pom.CocheKm0Page;
import com.laboratorio.pom.InicioPage;
import com.laboratorio.pom.NoticiasF1Page;
import com.laboratorio.pom.NoticiasPage;

public class TestBase {
	protected WebDriver driver;
	private BasePage basePage;
	
	protected InicioPage inicioPage;
	protected NoticiasPage noticiasPage;
	protected NoticiasF1Page noticiasF1Page;
	protected CocheKm0Page cocheKm0Page;

	public TestBase() {
		this.driver = Hooks.getDriver();
		
		this.basePage = new BasePage();
		this.basePage.setDriver(driver);
		
		this.inicioPage = new InicioPage(basePage, "inicio.json");
		this.noticiasPage = new NoticiasPage(basePage, "noticias.json");
		this.noticiasF1Page = new NoticiasF1Page(basePage, "noticiasf1.json");
		this.cocheKm0Page = new CocheKm0Page(basePage, "cochekm0.json");
	}
}
