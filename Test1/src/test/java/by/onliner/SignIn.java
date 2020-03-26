package by.onliner;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

public class SignIn extends WebDriverSettings{

    @Test
    public void signIn() {
        driver.get("https://people.onliner.by/");
        WebElement vhod = driver.findElement(By.xpath("//div[contains(text(), 'Вход')]"));
        vhod.click();

      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type ='password'] ")));

        driver.findElement(By.xpath("//form//input[@placeholder ='Ник или e-mail']")).sendKeys("karinagoncharik123@gmail.com");
        driver.findElement(By.xpath("//input[@type ='password'] ")).sendKeys("karinaz211");
        driver.findElement(By.cssSelector("button[class ='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full'")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weather-informer")));

        driver.findElementByLinkText("Каталог").click();
        driver.findElement(By.xpath("//div[@class ='catalog-bar-main']/div/ul/li[1]")).click();
        WebElement CategoryName = driver.findElement(By.xpath("//h1[@class = 'schema-header__title']"));
        Assert.assertTrue(CategoryName.getText().equals("Велосипеды"));
        driver.findElement(By.xpath("//div[@class = 'b-top-profile__item b-top-profile__item_arrow']")).click();
        driver.findElement(By.xpath("//div[@class='b-top-profile__logout']/a[@class='b-top-profile__link b-top-profile__link_secondary']")).click();
    }

    @Test
    public void signInFailure() {
        //driver.manage().window().setSize(new Dimension(500,500));
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
