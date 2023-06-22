

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertovanjeBoje {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.shoppster.rs/p/3687356");
        Thread.sleep(2000);

        String blueColor = "(0, 0, 255)";
        String whiteColor = "(255, 255, 255)";

        //Naredni deo je klik na belu boju samo da vidim hoce li test proci ili pasti ako se promeni boja
        /*driver.findElement(By.xpath("/html/body/ung-root/ung-storefront/main/cx-page-layout/cx-page-slot[2]/ung-product-details/div/div/div[2]/div/div[2]/ung-product-summary/div/ung-product-variants/div/ung-variant-color-selector/div/div[2]/div[1]/ung-variant-color-item/span"))
                .click();
        Thread.sleep(2000);*/

        //Nalazim element koji je selektovan (po defaultu je to plava boja
        WebElement selectedColor = driver.findElement(By.cssSelector(".variant-selector__color-outer.variant-selector__color-outer--active"));
        //Unutar tog elementa trazim njegov child element jer zelim da pristupim elementu koji ima u sebi rgb
        WebElement focusedColor = selectedColor.findElement(By.className("variant-selector__color"));
        //Kreiram boolean da proverim da li prethodni child element ima atribut 'style' i da li on sadrzi vrednost boje koju prosledjujem
        boolean a = focusedColor.getAttribute("style").contains(blueColor);
        Assert.assertTrue(a);


        //WebElement element = driver.findElement(By.cssSelector("tag[atribut='vrednost atributa']"));
        WebElement element2 = driver.findElement(By.cssSelector("span[style='background:  0% 0% / cover rgb(0, 0, 255);']"));
    }
}