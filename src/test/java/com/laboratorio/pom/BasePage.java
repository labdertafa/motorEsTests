package com.laboratorio.pom;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.laboratorio.utils.LogHelper;

public class BasePage {
	private static final Logger logger = LogHelper.getLogger(BasePage.class);
	private WebDriver driver;

	public BasePage() {
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private By getElement(JSONObject entity) throws Exception {
		By result = null;
		String getFieldBy = (String) entity.get("GetFieldBy");
		String valueToFind = (String) entity.get("ValueToFind");

		switch (getFieldBy) {
		case "className":
			result = By.className(valueToFind);
			break;
		case "cssSelector":
			result = By.cssSelector(valueToFind);
			break;
		case "id":
			result = By.id(valueToFind);
			break;
		case "linkText":
			result = By.linkText(valueToFind);
			break;
		case "name":
			result = By.name(valueToFind);
			break;
		case "partialLinkText":
			result = By.partialLinkText(valueToFind);
			break;
		case "tagName":
			result = By.tagName(valueToFind);
			break;
		case "xpath":
			result = By.xpath(valueToFind);
			break;
		}

		logger.log(Level.INFO, String.format("Le localisateur %s a été trouvé!", entity.toString()));

		return result;
	}

	// // Rechercher un composant Web à partir d nom
	private WebElement findElement(JSONObject entity) throws Exception {
		try {
			By locator = this.getElement(entity);

			// Attendre la présence de l'élément
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

			return driver.findElement(locator);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception(
					String.format("Le composant Web %s est introuvable avec le localisateur : ", entity.toString()));
		}
	}

	// Esperar a que una página carque por completo
	public void waitPageLoading() throws Exception {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript("return document.readyState").equals("complete"));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Error intentando consultar el status actual de la página!");
		}
	}

	// Cliquer sur un élément Web
	public void click(JSONObject element) throws Exception {
		try {
			WebElement webElement = this.findElement(element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			webElement.click();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible de cliquer sur l'élément : " + element);
		}
	}

	public void clickButtonByLabel(String label) throws Exception {
		try {
			List<WebElement> elements = driver.findElements(By.tagName("button"));
			for (WebElement elem : elements) {
				logger.log(Level.INFO, "Analizando botón con texto: [" + elem.getText() + "]");
				if (elem.getText().equals(label)) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					wait.until(ExpectedConditions.elementToBeClickable(elem));
					elem.click();
					return;
				}
			}

			throw new Exception(String.format("El botón con etiqueta % no se encontró en la página", label));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible de cliquer sur l'élément avec l'étiquete : " + label);
		}
	}

	public void scrollDown(int n) throws Exception {
		try {
			String comando = String.format("scroll(0, %d);", n * 250);
			logger.log(Level.INFO, "Comando scroll: " + comando);
			((JavascriptExecutor) driver).executeScript(comando);

			// Esperar un breve momento para que la página se ajuste
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible de hacer scroll down");
		}
	}

	public void ensureVisible(WebElement element) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible de hacer scroll hasta el elemento: " + element.toString());
		}
	}

	// Vérifier si un élément s'affiche
	public boolean isDisplayed(JSONObject element) throws Exception {
		try {
			return this.findElement(element).isDisplayed();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Pas d'affichage de l'élément : " + element);
		}
	}

	// Récupérer le texte d'un élément
	public String getText(JSONObject element) throws Exception {
		try {
			return this.findElement(element).getText();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible d'obtenir le texte de l'élément : " + element);
		}
	}

	// Ajouter du texte à un élément
	public void typeText(JSONObject element, String text) throws Exception {
		try {
			this.findElement(element).sendKeys(text);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible d'écrire du texte dans l'élément : " + element);
		}
	}

	// Attendre la présence d'un élément
	public void waitForElement(JSONObject element) throws Exception {
		try {
			By locator = this.getElement(element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Le délai d'attente est terminé pour l'élément : " + element);
		}
	}

	// Attendre la présence d'un text dans un élément
	public void waitForTextInElement(JSONObject element, String elementText) throws Exception {
		try {
			WebElement webElement = this.findElement(element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.textToBePresentInElement(webElement, elementText));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Le délai de localisation a expiré pour l'élément : " + element);
		}
	}

	// Récupère le titre de la fenêtre du navigateur
	public String getTitle() throws Exception {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible d'obtenir le titre de la page à partir du navigateur");
		}
	}

	// Accéder à la page définie par le paramètre URL
	public void navigate(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erreur: " + e.getMessage());
			throw new Exception("Impossible d'ouvrir la page : " + url);
		}
	}

	// Seleccionar elemento en combo
	public void seleccionarEnCombo(JSONObject element, String valor) throws Exception {
		try {
			WebElement webElement = this.findElement(element);
			try {
				this.ensureVisible(webElement);
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error: " + e.getMessage());
				throw new Exception("Problemas con el ensureVisible");
			}
			logger.log(Level.INFO, "EnsureVisible ejecutado con éxito!");
			Thread.sleep(10000);

			Select select = new Select(webElement);
			select.selectByValue(valor);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error en COMBO: " + e.getMessage());
			throw new Exception("Combo: No se pudo seleccionar el elemento con valor: " + valor);
		}
	}

	// Seleccionar elemento en combo
	public void seleccionarEnComboPorTexto(JSONObject element, String valor) throws Exception {
		try {
			WebElement webElement = this.findElement(element);
			try {
				this.ensureVisible(webElement);
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error: " + e.getMessage());
				throw new Exception("Problemas con el ensureVisible");
			}
			Select select = new Select(webElement);
			select.selectByVisibleText(valor);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("Combo: No se pudo seleccionar el elemento con valor: " + valor);
		}
	}

	// Seleccionar elemento en lista
	public boolean clickEnElementoDeLista(JSONObject elemento, String valor) throws Exception {
		try {
			WebElement lista = findElement(elemento);
			List<WebElement> elements = lista.findElements(By.tagName("li"));
			for (WebElement elem : elements) {
				if (elem.getText().equals(valor)) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					wait.until(ExpectedConditions.elementToBeClickable(elem));
					elem.click();
					return true;
				}
			}

			return false;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("Lista: No se pudo seleccionar el elemento con valor: " + valor);
		}
	}

	public void posicionarSlider(JSONObject elemento, int valor) throws Exception {
		try {
			WebElement slider = findElement(elemento);
			((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", slider, valor);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("Lista: No se pudo posicionar el slider en el valor: " + valor);
		}
	}

	public void marcarTipoCoche(String id) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').checked = true;");
	}
}