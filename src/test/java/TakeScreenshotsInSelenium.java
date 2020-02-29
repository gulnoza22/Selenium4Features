import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenshotsInSelenium {

@Test
    public void takeScreenshot() throws IOException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    driver.get("https://opensource-demo.orangehrmlive.com");

    //this locator takes picture of logo
    WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
    //it gets the screenshot and puts in the file
   File file = logo.getScreenshotAs(OutputType.FILE);
   //we need to create an object from File and path our file name parameter
   File locationFile = new File("logo.png");

    FileUtils.copyFile(file, locationFile);

   driver.quit();


}
}
