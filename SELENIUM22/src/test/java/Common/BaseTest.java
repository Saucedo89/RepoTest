package Common;

import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import Features.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest
{
    //****** INSTANCIAS ******

    protected static WebDriver driver = null;
    Login login = new Login();
    private DriverManager driverManager;
    private static int numberOfCase = 0;

    @BeforeTest
    public void setup() throws InterruptedException
    {

        numberOfCase ++;
        System.out.println("Se esta ejecutando el escenario Numero:" + numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_QA);
        //Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Se realiza el login
        login.miLogin(driver);



    }

    @AfterTest
    public void TearDown ()
    {

        System.out.println("El escenario Numero:  " + numberOfCase + " Se ejecuto correctamente");
        driver.close();
        driverManager.quitDriver();
    }


}
