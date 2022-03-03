import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CyberArkPassword {

    private static WebDriver driver;

    public static void main(String[] args){
        Config conf = new Config();
        OTP otp = new OTP();

        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(conf.getProperty("URL"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'LOGON')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
        driver.findElement(By.id("i0116")).sendKeys(conf.getProperty("email"));
        driver.findElement(By.id("idSIButton9")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
        driver.findElement(By.id("i0118")).sendKeys(conf.getProperty("password"));
        driver.findElement(By.id("idSIButton9")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idTxtBx_SAOTCC_OTC")));
        driver.findElement(By.id("idTxtBx_SAOTCC_OTC")).sendKeys(otp.now());
        driver.findElement(By.id("idSubmit_SAOTCC_Continue")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
        driver.findElement(By.id("idSIButton9")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame-epv")));
        driver.switchTo().frame("frame-epv");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'more-item')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='action-menu-item-1']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']//input[contains(@formcontrolname,'secret')]")));

        System.out.println(driver.findElement(By.xpath("//div[@role='dialog']//input[contains(@formcontrolname,'secret')]")).getAttribute("value"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']//button"))).click();
    }
}


