import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetSizeOfTheElementInSelenium {

    @Test
    public void LocationAndSize() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.get("https://opensource-demo.orangehrmlive.com");

        //this locator takes picture of logo
        WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
        //Printing Hight of the Element
        System.out.println("Height: " + logo.getRect().getDimension().getHeight());
        //Printing Width of the Element
        System.out.println("Width: " + logo.getRect().getDimension().getWidth());
        //Printing X Location
        System.out.println("X Location: " + logo.getRect().getX());
        //Printing Y Location
        System.out.println("Y Location: " + logo.getRect().getY());
    }
}