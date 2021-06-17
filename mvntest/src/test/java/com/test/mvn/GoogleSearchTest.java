package com.test.mvn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleSearchTest {
  //  private WebDriver webDriver;
//libreria de https://junit.org/junit5/docs/current/user-guide/
    //@BeforeEach analogo de JUnit 4 @Before
    //@BeforeAll analogo de Junit 4 @BeforeClass

    /*
    Denota que el método anotado debe ser ejecutado antes de cada @Test
    , @RepeatedTest, @ParameterizedTest, o @TestFactorymétodo en la clase actual; análogo a JUnit 4 @Before.
     Estos métodos se heredan a menos que se anulen .
     */
    private WebDriver webDriver;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");
    }

    @Test
    public void testGooglePage(){
        WebElement searchBox=webDriver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("quality-stream Introducción a la automatización de Pruebas de Software");
        searchBox.submit();
        //ahora bien chicos pongamos un tiempo de espera para poder esperar valga la redundancia
        // a que los elementos de busqueda sean obtenidos en la pagina en este caso una espera implicita
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//ahora llamemos un metodito como le dice zulu en los tutoriales un metodito statico, solo escribamos
        //assertEquals demos control espacio y veamos la opcion de importar metodo estatico
       assertEquals("quality-stream Introducción a la automatización de Pruebas de Software - Google Search", webDriver.getTitle());
      //fallo o que igual es por nuestro lenguaje en el navegador obviamente si miramos el resultado vemos que el actual
        //es buscar con google pues esta in spanish chicos
       //  assertEquals("quality-stream Introducción a la automatización de Pruebas de Software - Buscar con Google", webDriver.getTitle());
    }
    //ahora cerremos por favor chicos metodo de cierre para que cerremos el navegador una vez complete el test
    //tearDown traduce como demoler pero si quiere lo llaman closed o cerrar como lo prefieran, aunque no es
    //bueno combinar ingles con español
    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
