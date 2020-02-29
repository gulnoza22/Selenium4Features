import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RelativeLocators {
    WebDriver driver;
    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("https://automationbookstore.dev/");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test(description = "Test Book5 is left of Book6 & below Book1")
    public void test1(){
      WebElement book5 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
      String id = book5.getAttribute("id");
        System.out.println(id);
        Assert.assertEquals("pid5", id);

    }

    @Test(description = "Test Book2 is wright of Book1 & above Book6")
    public void test2(){
        WebElement book2 = driver.findElement(RelativeLocator.withTagName("li").toRightOf(By.id("pid1")).above(By.id("pid6")));
        String id = book2.getAttribute("id");
        System.out.println(id);
        Assert.assertEquals("pid2", id);

    }
}
