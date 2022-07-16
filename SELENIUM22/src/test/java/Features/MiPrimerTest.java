package Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MiPrimerTest
{

    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException
    {
         //Se coloca la direccion del driver, sea chrome, sea mozilla o sea edge, opera, safari
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

        //Se crea la instancia u objeto del Navegador
        driver = new ChromeDriver();

        //Maximisa el navegador
        driver.manage().window().maximize();

        //Enviamos la url al navegador
        driver.get("https://www.amazon.com.mx/");

        Thread.sleep(9000);


    }

    @Test
    public void testAmazon() throws InterruptedException
    {

        /*Primero identifico mi elemento, es de suma importancia, tener instanciado un elemento de tipo WebElement, de lo contrario no podremos buscar en DOM
        Ni tampoco interactuar con el, es decir, dar clic, enviar datos, desplegar*/
        WebElement inputBusqueda = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);
        //Se da clic en el elemento
        inputBusqueda.click();
        Thread.sleep(3000);


        //Se envia datos al input
        inputBusqueda.sendKeys("Alexa");

        //Entiendase que submit es similar a lanzar o dar un enter
        inputBusqueda.submit();

        Thread.sleep(6000);


    }


    @AfterTest
    public void tearDown()
    {
        //Cierra el navegador
        driver.close();

        //Matamos la instancia
        driver.quit();


    }






}
