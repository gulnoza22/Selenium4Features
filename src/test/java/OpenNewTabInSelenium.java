import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenNewTabInSelenium {

    @Test
    public void openNewTab() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //opening 1st Tab
        driver.get("https://opensource-demo.orangehrmlive.com");

        //opening 2nd TAB
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("http://newtours.demoaut.com");
        Thread.sleep(3000);
        driver.quit();
    }

}
