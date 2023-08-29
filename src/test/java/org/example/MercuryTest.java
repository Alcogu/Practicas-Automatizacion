//Prueba de inicio de sesión

package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MercuryTest {

    //Se crea objeto WebDriver
    private WebDriver driver;

    //Localizador mediante link de tipo texto
    By linkRegistro = By.linkText("REGISTER");
    By pagRegistro = By.xpath("//img[@src='images/mast_register.gif']");
    By userName = By.id("email");
    By password = By.name("password");
    By confirmarPassword = By.name("confirmPassword");
    By enviarRegistro = By.name("submit");
    By usuario = By.name("userName");
    By contraseña = By.name("password");
    By login = By.name("submit");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        //Declarar objeto driver de tipo chromeDriver
        driver = new ChromeDriver();
        //maximizar ventana
        driver.manage().window().maximize();
        //envia la URL al navegador
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @After
    public void tearDown(){
        //Cierra el navegador una vez que completa la prueba
        //driver.quit();
    }

    @Test
    //Registro de usuario exitoso
    public void registroUsuario() throws InterruptedException{
        driver.findElement(linkRegistro).click();
        //Temporizador, 2 segundos de espera para cargar la página
        Thread.sleep(2000);
        //Si encuentra el localizador (la imagen) comprueba que esta en la pantalla correcta
        if(driver.findElement(pagRegistro).isDisplayed()){
            driver.findElement(userName).sendKeys("test");
            driver.findElement(password).sendKeys("test");
            driver.findElement(confirmarPassword).sendKeys("test");
            driver.findElement(enviarRegistro).click();
        }
        else{
            System.out.print("Pagina de registro no encontrada");
        }
        //Se confirma que el registro a sido exitoso mediante mensaje de confirmación
        //Lista de elementos web tipo Fond
        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        //El mensaje es el font #5 de la página, se compara el msj
        assertEquals("Note: Your user name is test.", fonts.get(5).getText());
    }
    //Nuevo metodo Test
    @Test
    //Loguin exitoso
    public void inicioSesion() throws InterruptedException {
        //Si encuentra el localizador (input de usuario) comprueba que esta en la pantalla correcta
        if (driver.findElement(usuario).isDisplayed()){
            driver.findElement(usuario).sendKeys("test");
            driver.findElement(contraseña).sendKeys("test");
            driver.findElement(login).click();
            //Temporizador, 2 segundos de espera para cargar la página
            Thread.sleep(2000);
        }
        //Se confirma que el registro a sido exitoso mediante mensaje de confirmación
        //Lista de elementos web tipo Fond
        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        //El mensaje es el font #5 de la página, se compara el msj
        assertEquals("Thank you for Loggin.", fonts.get(3).getText());
    }
}
