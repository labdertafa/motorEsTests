package com.laboratorio.browsers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MovilDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
		this.setDriverOptions();
	}

	@Override
	protected void createDriver(String propiedad, String ruta) {
		System.setProperty(propiedad, ruta);
		this.setDriverOptions();
	}
	
	private void setDriverOptions() {
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", 412);
		deviceMetrics.put("height", 915);
		deviceMetrics.put("pixelRatio", 3.0);
		deviceMetrics.put("mobile", true);
		
		Map<String, Object> clientHints = new HashMap<>();
		clientHints.put("platform", "Android");
		clientHints.put("mobile", true);
		
		Map<String, Object> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceMetrics", deviceMetrics);
		mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
		mobileEmulation.put("clientHints", clientHints);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		this.driver = new ChromeDriver(chromeOptions);
	}

}
