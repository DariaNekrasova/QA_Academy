package unitTests;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUnitTest {

    @Test
    public void simpleTest() {
        assertEquals(12, 6 + 6);
    }

    @Test
    public void simpleFailedTest() {
        assertEquals(11, 6 + 6);
    }

    @Test
    public void firstUITest() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resourсes/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        driver.close();
    }

    @Test
    public void SecondUITest() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resourсes/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement keyBoard = driver.findElement(By.xpath("//span[@class='MiYK0e']"));
        keyBoard.click();

        WebElement field = driver.findElement(By.name("q"));

        WebElement keyA = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='K70']")));

        keyA.click();

        field.submit();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

//        WebElement dynamicElement = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='vk-t']")));
        driver.close();
    }
}
