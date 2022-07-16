package Features;

import Common.BaseTest;
import Utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Alertas extends BaseTest
{
    WebDriverWait wait;
    SeleniumUtils utils = new SeleniumUtils();

    @Test
    public void Alerts () throws InterruptedException {
        //INSTANCIA DE OBJETO JAVA SCRIPT
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //ACEPTAR ALERTAS
        js.executeScript("alert('EL EDHER ES GAY Y LE VA AL AMERICA');");
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
        utils.waiting(driver,3000);
         /*driver.switchTo().alert().accept();
        utils.waiting(driver, 3000);*/

        //DISMIS ALERTA --> Lo que hace esta funcion es cancelar una alerta
        String alert = driver.switchTo().alert().getText();
        System.out.println("Texto de alerta: " + alert );
        utils.waiting(driver,2000);
        driver.switchTo().alert().dismiss();

    }




}
