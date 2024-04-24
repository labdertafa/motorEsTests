package com.laboratorio.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.laboratorio.pom.BasePage;
import com.laboratorio.pom.CalendarioPage;
import com.laboratorio.pom.ClasificacionPage;
import com.laboratorio.pom.CocheKm0Page;
import com.laboratorio.pom.EscuderiasF1Page;
import com.laboratorio.pom.InicioPage;
import com.laboratorio.pom.NoticiasF1Page;
import com.laboratorio.pom.NoticiasPage;
import com.laboratorio.pom.PilotosF1Page;
import com.laboratorio.pom.RentingPage;

public class TestBase {
	protected WebDriver driver;
	private BasePage basePage;
	
	protected InicioPage inicioPage;
	protected NoticiasPage noticiasPage;
	protected NoticiasF1Page noticiasF1Page;
	protected CocheKm0Page cocheKm0Page;
	protected ClasificacionPage clasificacionPage;
	protected CalendarioPage calendarioPage;
	protected PilotosF1Page pilotosF1Page;
	protected EscuderiasF1Page escuderiasF1Page;
	protected RentingPage rentingPage;

	public TestBase() {
		this.driver = Hooks.getDriver();
		
		this.basePage = new BasePage();
		this.basePage.setDriver(driver);
		
		this.inicioPage = new InicioPage(basePage, "inicio.json");
		this.noticiasPage = new NoticiasPage(basePage, "noticias.json");
		this.noticiasF1Page = new NoticiasF1Page(basePage, "noticiasf1.json");
		this.cocheKm0Page = new CocheKm0Page(basePage, "cochekm0.json");
		this.clasificacionPage = new ClasificacionPage(basePage, "clasificacion.json");
		this.calendarioPage = new CalendarioPage(basePage, "calendario.json");
		this.pilotosF1Page = new PilotosF1Page(basePage, "pilotosf1.json");
		this.escuderiasF1Page = new EscuderiasF1Page(basePage, "escuderiasf1.json");
		this.rentingPage = new RentingPage(basePage, "renting.json");
	}
}
