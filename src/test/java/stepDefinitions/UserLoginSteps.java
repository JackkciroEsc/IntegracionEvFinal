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
import static org.junit.Assert.*;

import java.time.Duration;


public class UserLoginSteps {
	private WebDriver driver;

	@Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
        driver = new EdgeDriver();
    }
	
	@Given("el usuario accede a la pagina de inicio de sesion")
	public void el_usuario_accede_a_la_pagina_de_inicio_de_sesion() {
	    driver.get("http://localhost:8081/ReservaHora/");
	}

	 @When("ingresa {string} como nombre de usuario y {string} como contrasena")
	    public void ingresa_como_nombre_de_usuario_y_como_contrasena(String nombreUsuario, String password) {
	        driver.findElement(By.name("nombreUsuario")).sendKeys(nombreUsuario);
	        driver.findElement(By.name("password")).sendKeys(password);
	        driver.findElement(By.name("submit")).click();
	    }

	 @Then("se muestra un mensaje {string} para el usuario")
	 public void se_muestra_un_mensaje_para_el_usuario(String mensajeEsperado) {
	     // Esperar un momento para que el mensaje tenga tiempo de aparecer
	     esperarElementoPresente(By.tagName("p"));

	     // Encuentra el elemento que contiene el mensaje
	     WebElement mensaje = driver.findElement(By.tagName("p"));

	     // Imprime los mensajes actual y esperado para propósitos de depuración
	     System.out.println("Mensaje Esperado: " + mensajeEsperado);
	     System.out.println("Mensaje Actual: " + mensaje.getText());

	     // Compara el mensaje actual con el esperado
	     assertEquals(mensajeEsperado, mensaje.getText());
	 }

	 // Método de espera para manejar la asincronía
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
