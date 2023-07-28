//Test de búsqueda en Google mediante nombre de la página

package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleTest {

    //Se crea objeto WebDriver
    private WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        //Declarar objeto driver de tipo chromeDriver
        driver = new ChromeDriver();
        //maximizar ventana
        driver.manage().window().maximize();
        //envia la URL al navegador
        driver.get("https://www.google.com/");
    }

    @Test
    //se crea metodo testGooglePage
    public void testGooglePage(){
        //encontrar elemento en la pagina, By es un seleccionador, q es el nombre de la caja de busqueda
        WebElement searchbox = driver.findElement(By.name("q"));
        //Limpia texto en la caja de busqueda
        searchbox.clear();
        //Se envia el texto que queremos a la caja de texto
        searchbox.sendKeys("quality-stream introducción a la automatización de pruebas de software");
        //Envia la información
        searchbox.submit();
        //El tiempo que se espera después del submit, si no se pone espera se puede dar un falso positivo
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //chequear los resultados de la busqueda revisando que el retorno sea igual a quality... y que eso este en el titulo de la pagina de resultados
        assertEquals("quality-stream introducción a la automatización de pruebas de software - Buscar con Google", driver.getTitle());

    }

    @After
    public void tearDown(){
        //Cierra el navegador una vez que completa la prueba
        driver.quit();
    }
}