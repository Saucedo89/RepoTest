package Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators
{

    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
    }

    @Test
    public void xpaths() throws InterruptedException
    {

        //Thread.sleep(6000);


        //*************    X P H A T S   ****************

        //Existen dos tipos de xpaths; que son, absoluto y el relativo.
        //El xpath absoluto por buenas practicas no se debe utilizar o no abusar de el.
        //Diferencias entre los xpaths
        //El absoluto es toda la ruta del elemento, es decir la ubicacion del mismo y su sintaxis inicia con una diagonal

         //*************       Este es el xpath absoluto           ****************************
        //WebElement inputBusqueda = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
        //inputBusqueda.sendKeys("CALZONES PARA PLAYITA");
        //Thread.sleep(6000);

        //***************        Estas son las diferentes tecnicas de uso de xpath relativo         ***********************************
        //Los xpaths relativos inician con doble diagonal
        //1.- Uso de xpath relativo con tag y atributos, entiendase que tags son: "span, img, button, input etc..."
        //WebElement inputBusqueda = driver.findElement(By.xpath("//input[@autocomplete='off']"));
        //WebElement inputBusqueda = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        //Thread.sleep(4000);
        //inputBusqueda.sendKeys("CALZONES");
        //inputBusqueda.submit();
        //Thread.sleep(4000);

        //2.- Uso de xpath relativo con tag y multiples atributos
        //WebElement inputBusqueda = driver.findElement(By.xpath("//input[@name='field-keywords' and @id='twotabsearchtextbox']"));
        //Thread.sleep(4000);
        //inputBusqueda.sendKeys("celulares");
        //inputBusqueda.submit();
        //Thread.sleep(4000);

        //3.- Uso de xpath relativo usando contains, con: "*" o "tag", cabe mencionar que el asterisco se puede reemplazar por el tag
       /* WebElement bottonIdentificate = driver.findElement(By.xpath("//span[contains(text(), 'Hola, Identifícate')]"));
        bottonIdentificate.click();*/

        //4.- Uso de xpath por relationship, esto es en funcion de el manejo de las etiquetas o tags, padre e hijo
        /*WebElement inputBusqueda = driver.findElement(By.xpath("//div/input[@id='twotabsearchtextbox' and @type='text']"));
        inputBusqueda.sendKeys("Como ser un tester");
        inputBusqueda.submit();
        Thread.sleep(4000);*/

        //************************** X P H A T S *********************************************


    }


    @Test
    public void parthialLinkText() throws InterruptedException
    {
        //****************   Parthial link Text ***************************************
       /* Thread.sleep(5000);
        WebElement bottonContinuar = driver.findElement(By.xpath("//input[@class='a-button-input' and @data-action-type='DISMISS']"));
        bottonContinuar.click();

        WebElement offersDayButton = driver.findElement(By.partialLinkText("Ofertas"));
        offersDayButton.click();
        Thread.sleep(4000);*/
    }

    @Test
    public void linkText() throws InterruptedException
    {
        //****************   Link Text ***************************************
       /* Thread.sleep(5000);
        WebElement bottonContinuar = driver.findElement(By.xpath("//input[@class='a-button-input' and @data-action-type='DISMISS']"));
        bottonContinuar.click();

        WebElement offersDayButton = driver.findElement(By.linkText("Ofertas del Día"));
        offersDayButton.click();
        Thread.sleep(4000);*/

    }

    @Test
    public void name() throws InterruptedException
    {
        //****************   NAME  ***************************************
       /* WebElement inputSearch = driver.findElement(By.name("field-keywords"));
        inputSearch.sendKeys("IPHONE");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);*/

    }

    @Test
    public void id() throws InterruptedException
    {
        //****************   ID  ***************************************
       /* WebElement inputSearch = driver.findElement(By.id("twotabsearchtextbox"));
        inputSearch.sendKeys("IPHONE");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);*/

    }


    @Test
    public void className () throws InterruptedException
    {

     /*   WebElement inputSearch = driver.findElement(By.className("nav-input nav-progressive-attribute"));
        inputSearch.sendKeys("IPHONE");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);*/
    }
    @Test
    public void cssSelector () throws InterruptedException
    {
        //WebElement inputSearch = driver.findElement(By.cssSelector("input[name='field-keywords']"));
        //WebElement inputSearch = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        //WebElement inputSearch = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement inputSearch = driver.findElement(By.cssSelector("input[name='field-keywords'][id='twotabsearchtextbox']"));
        inputSearch.sendKeys("IPHONE");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);

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
