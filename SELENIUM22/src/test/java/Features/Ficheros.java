package Features;

import Common.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ficheros
{
    WebDriver driver;

    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("C:\\Users\\old_s\\eclipse-workspace\\SeleniumJavaProject\\archivos\\upload_file.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Test
    public void UploadFile() throws InterruptedException {
        WebElement uploadFile = driver.findElement(By.name("myFile"));
        uploadFile.sendKeys("C:\\Users\\old_s\\OneDrive\\Escritorio\\Automatización\\java_curso\\SELENIUM22\\archivo_prueba.docx");
        Thread.sleep(4000);

        WebElement bottonEnviar = driver.findElement(By.id("uploadFile"));
        bottonEnviar.click();

    }

    @AfterTest
    public void TearDown()
    {
        driver.quit();
    }



}
