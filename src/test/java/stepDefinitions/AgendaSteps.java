package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class AgendaSteps {
	private WebDriver driver;

	
	@Before 
	public void driver() {
	    System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
	    driver = new EdgeDriver();
	    // Agrega un tiempo de espera después de cargar la página
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
    @Given("el usuario accede a la pagina de agendar citas")
    public void el_usuario_accede_a_la_pagina_de_agendar_citas() {
        driver.get("http://localhost:8081/ReservaHora/register.jsp");
    }

    /* WHEN'S */
    
    @When("ingresa ID de mascota {string}")
    public void ingresa_ID_de_mascota(String idMascota) {
        driver.findElement(By.id("idMascota")).sendKeys(idMascota);
    }

    @When("ingresa rut del dueno {string}")
    public void ingresa_rut_del_dueno (String rutDueno) {
        driver.findElement(By.id("rutDueno")).sendKeys(rutDueno);
    }

    @When("ingresa nombre de mascota {string}")
    public void ingresa_el_nombre_de_mascota(String nombreMascota) {
        driver.findElement(By.id("nombreMascota")).sendKeys(nombreMascota);
    }

    @When("ingresa hora {string}")
    public void ingresa_hora(String hora) {
        driver.findElement(By.id("hora")).sendKeys(hora);
    }

    @When("ingresa fecha {string}")
    public void ingresa_fecha(String fecha) {
        esperarElementoPresente(By.id("fecha"));

        WebElement fechaInput = driver.findElement(By.id("fecha"));
        fechaInput.clear();
        fechaInput.sendKeys(fecha);
        driver.findElement(By.name("submit")).click();
    }

    @Then("se muestra un mensaje de éxito {string}")
    public void se_muestra_un_mensaje_de_exito(String expectedMessage) {
        WebElement mensajeExito = driver.findElement(By.cssSelector("h1"));
        assertEquals(expectedMessage, mensajeExito.getText());
    }
    
    /*
     * 
     * @Then("se muestra un mensaje de error {string}")
		public void se_muestra_un_mensaje_de_error(String expectedMessage) {
		    WebElement mensajeError = driver.findElement(By.cssSelector("h1")); // Ajusta el selector CSS según tu aplicación
		    assertEquals(expectedMessage, mensajeError.getText());
		}
		
     */
    
    
    private void esperarElementoPresente(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).toSeconds());
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
