package ru.netology;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UiTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "./driver/linux/geckodriver");
        System.setProperty("java.awt.headless", "true");
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public  void should(){
        driver.get("http://localhost:9999/");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Сюзанна");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79788586822");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String text = driver.findElement(By.className("paragraph_theme_alfa-on-white")).getText().trim();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, text);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
