import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\artur\\OneDrive\\Escritorio\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://oficinavirtual.issste.gob.mx/Transparencia/Padr%C3%B3n-de-Pensionados#");

        LlenarFormulario(driver);
        DescargarArchivo(driver);
    }



    public static void LlenarFormulario(WebDriver driver) throws InterruptedException {
        WebElement element;
        //TIPO
        element = driver.findElement(By.id("dnn_ctr439_View_rcbTipoPensionado_Arrow"));
        element.click();
        List<WebElement> itemsdeULTIPO = driver.findElements(By.className("rcbItem"));
        for (WebElement ul : itemsdeULTIPO) {
           if (ul != null) {
               if (ul.getText().equals("DIRECTOS")) {
                //new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ul));}
                //System.out.println(ul.getTagName());
                ul.click();
                Thread.sleep(2000);
                System.out.println("Sí clickeé directos jaja");
                   break;
                }
            }
        }
        //AÑO
        List<WebElement> itemsANIO = driver.findElements(By.className("rcbItem"));
        for (WebElement ul : itemsANIO) {
                if (ul != null){
                    System.out.println(ul.getText());
                    if (ul.getText().equals("2021")) {
                    //Aquí va el waitdriverweb wait to be clickeable
                    //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ul));
                        ul.click();
                        Thread.sleep(2000);
                        System.out.println("Sí clickeé 2021 jaja");
                        break;
                    }
                }
            }
        //MES
        List<WebElement> itemsdeULMES = driver.findElements(By.cssSelector("ul.rcbList"));
        for (WebElement ul : itemsdeULMES) {
            if (ul != null) {
                System.out.println(ul.getText());
                if (ul.getText().equals("ENERO")) {
                    //Aquí va el waitdriverweb wait to be clickeable
                    //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ul));
                    ul.click();
                    Thread.sleep(2000);
                    System.out.println("Sí clickeé enero jaja");
                    break;
                }
            }
        }
        //DELEGACION
        List<WebElement> itemsdeULESTADO = driver.findElements(By.className("rcbItem"));
        for (WebElement ul : itemsdeULESTADO) {
            if (ul != null)
            {
                if (ul.getText().equals("DELEGACION ESTATAL EN SONORA")) {
                    //Aquí va el waitdriverweb wait to be clickeable
                    //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ul));
                    ul.click();
                    Thread.sleep(2000);
                    System.out.println("Sí clickeé Delegación en Sonora jaja");
                    break;
                }
            }
        }

    }
    public static void DescargarArchivo(WebDriver driver) {
        //*[@id="descargacompleta"]/a
        //tenemos que usar webdriverwait para esperar que aparezca el botón
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("descargacompleta")))).click();
        //driver.findElement(By.xpath("/html/body/form/div[8]/div/div[3]/div[1]/div[1]/div/div[2]/div/div[2]/div/div/div/div[1]/table/tbody/tr[6]/td/div/span/a")).click();
    }
}

//*[@id="dnn_ctr439_View_rcbTipoPensionado_ClientState"]