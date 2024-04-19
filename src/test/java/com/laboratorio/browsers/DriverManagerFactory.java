package com.laboratorio.browsers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.laboratorio.utils.LogHelper;

public class DriverManagerFactory {
	private static final Logger logger = LogHelper.getLogger(DriverManagerFactory.class);
	
	public static DriverManager getDriverManager(DriverType tipo) {
		DriverManager driverManager = null;
		
		switch (tipo) {
			case CHROME:
				driverManager = new ChromeDriverManager();
				logger.log(Level.INFO, "Se ha seleccionado el ChromeDriver existosamente");
				break;
			case FIREFOX:
				driverManager = new FirefoxDriverManager();
				logger.log(Level.INFO, "Se ha seleccionado el FirefoxDriver existosamente");
				break;
			case EDGE:
				driverManager = new EdgeDriverManager();
				logger.log(Level.INFO, "Se ha seleccionado el EdgeDriver existosamente");
				break;
			case MOVIL:
				driverManager = new MovilDriverManager();
				logger.log(Level.INFO, "Se ha seleccionado el MovilDriver existosamente");
				break;
			default:
				logger.log(Level.SEVERE, "Se ha seleccionado un browser inválido!");
				break;
		}
		
		return driverManager;
	}
}