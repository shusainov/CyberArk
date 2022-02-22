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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authItem")));
        List<WebElement> elements = driver.findElements(By.id("authItem"));
        elements.get(1).click();

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clipboardenabled\"]/div/pv-accounts-actions-manager/pv-accounts/pv-accounts-splitter/cyb-splitter/div/div[1]/pv-accounts-grid/cyb-server-data-table/div[1]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[3]/div/div/div/div/cyb-actions-col/div/cyb-more-items-trigger-action-menu/cyb-floating-container/div/span/span/cyb-more-items-trigger/button")));
        driver.findElement(By.xpath("//*[@id=\"clipboardenabled\"]/div/pv-accounts-actions-manager/pv-accounts/pv-accounts-splitter/cyb-splitter/div/div[1]/pv-accounts-grid/cyb-server-data-table/div[1]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[3]/div/div/div/div/cyb-actions-col/div/cyb-more-items-trigger-action-menu/cyb-floating-container/div/span/span/cyb-more-items-trigger/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clipboardenabled\"]/div/router-outlet/div/div/span/cyb-action-menu/div/div/div/cyb-action-menu-item[1]/div/span")));
        driver.findElement(By.xpath("//*[@id=\"clipboardenabled\"]/div/router-outlet/div/div/span/cyb-action-menu/div/div/div/cyb-action-menu-item[1]/div/span")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"clipboardenabled\"]/div/pv-accounts-actions-manager/pv-accounts-show-dialog/cyb-modal/div/div/section/div[2]/div/pv-accounts-show-dialog-content/div/cyb-input-field/div/div[2]/div/div/input")).getAttribute("value"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clipboardenabled\"]/div/pv-accounts-actions-manager/pv-accounts-show-dialog/cyb-modal/div/div/section/div[2]/div/pv-accounts-show-dialog-content/div/div/button/span")));
        driver.findElement(By.xpath("//*[@id=\"clipboardenabled\"]/div/pv-accounts-actions-manager/pv-accounts-show-dialog/cyb-modal/div/div/section/div[2]/div/pv-accounts-show-dialog-content/div/div/button/span")).click();
    }
}


