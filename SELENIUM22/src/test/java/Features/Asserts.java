package Features;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Asserts
{
    private WebDriver driver;

    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void AssertTrue()
    {
        //El Assert True se utiliza para realizar validaciones para scripts positivos

        WebElement user = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passContainer"));

        //Se valida que los elementos esten presentes, lo cual nos dara como resultado que los scripts sean pasados

        Assert.assertTrue(user.isDisplayed());
        Assert.assertTrue(password.isDisplayed());

    }

    @Test
    public void AssertFalse() throws InterruptedException {
        //El Assert False se utiliza para realizar validaciones para scripts negativos

        WebElement user = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));

       user.sendKeys("victor.sacv89@gmail.com");
       Thread.sleep(1000);
       password.sendKeys("@@@@@11122233334");
       Thread.sleep(1000);
       password.submit();
       Thread.sleep(5000);
       WebElement mensaje = driver.findElement(By.xpath("//div[contains(text(), 'La contraseña que ingresaste es incorrecta')]"));
       Assert.assertFalse(mensaje.isDisplayed());


        //Se puede validar algun boton, mensaje de error, etiquetas para que nuestro test sea fallido
        //Assert.assertFalse(user.isDisplayed());

    }

    @Test
    public void AssertEquals() throws InterruptedException
    {
        //El Assert Equals realiza validaciones de igualdad
        //Validacion
        String expetedTitle = "Facebook - Inicia sesión o regístrate";
        Thread.sleep(1000);
        Assert.assertEquals(expetedTitle, driver.getTitle());


    }

    @Test
    public void GetText() throws InterruptedException
    {
        //Con los metodos Get, podemos recuperar informacion y guardarlo en una variable

         String createAccount = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).getText();
         System.out.println(createAccount);
         Assert.assertEquals(createAccount,"Crear cuenta nueva");
         Thread.sleep(3000);
         Assert.assertEquals(createAccount.length(),17);


    }



    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();
    }


}
