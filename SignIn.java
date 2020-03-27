package by.onliner;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SignIn extends WebDriverSettings{

    @Test
    public void signIn() {
        driver.manage().window().maximize();
        driver.get("https://people.onliner.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement entry = driver.findElement(By.xpath("//div[contains(text(), 'Вход')]"));
        entry.click();

      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type ='password'] ")));
//        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//                .withTimeout(30, SECONDS)
//                .pollingEvery(5, SECONDS)
//                .ignoring(NoSuchElementException.class);

        driver.findElement(By.xpath("//form//input[@placeholder ='Ник или e-mail']")).sendKeys("karinagoncharik123@gmail.com");
        driver.findElement(By.xpath("//input[@type ='password'] ")).sendKeys("karinaz211");
        driver.findElement(By.cssSelector("button[class ='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full'")).click();

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weather-informer")));

        driver.findElement(By.linkText("Каталог")).click();
        List <WebElement> popularCategories = driver.findElements(By.xpath("//div[@class ='catalog-bar-main']/div/ul/li"));
        int i = (int)(Math.random()*popularCategories.size());
        String popularCategoryName = popularCategories.get(i).getText();
        popularCategories.get(i).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class = 'schema-header__title']")));
        WebElement CategoryNameExpected = driver.findElement(By.xpath("//h1[@class = 'schema-header__title']"));
        Assert.assertEquals(CategoryNameExpected.getText(),(popularCategoryName));
        driver.findElement(By.xpath("//div[@class = 'b-top-profile__item b-top-profile__item_arrow']")).click();
        driver.findElement(By.xpath("//div[@class='b-top-profile__logout']/a[@class='b-top-profile__link b-top-profile__link_secondary']")).click();
    }

    @Test
    public void signInFailure() {
        driver.manage().window().maximize();
        driver.get("https://people.onliner.by/");

        // WebElement header = driver.findElement(By.className("g-top"));
        WebElement vhod = driver.findElement(By.xpath("//div[contains(text(), 'Вход')]"));
        vhod.click();

        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type ='password'] ")));


        driver.findElement(By.cssSelector("button[class ='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full'")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class ='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']")));

        WebElement errorMes = driver.findElement(By.xpath("//text() 'Укажите ник или e-mail'"));
      // WebElement er = driver.findElement(By.xpath("//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other'][1]"));
        //er.getText();

        Assert.assertTrue(errorMes.equals("Укажите ник или e-mail"));
    }
}
