package by.onliner;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;


public class SignIn extends WebDriverSettings {

    @Test
    public void signIn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//div[contains(text(), 'Вход')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type ='password']")));
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver -> driver.findElement(By.xpath("//input[contains(@placeholder,'e-mail')]"))).sendKeys("karinagoncharik123@gmail.com");
        driver.findElement(By.xpath("//input[@type ='password']")).sendKeys("karinaz211");
        driver.findElement(By.xpath("//button[@type='submit'][contains(@class,'auth-form')]")).click();
        fluentWait.until(driver -> driver.findElement(By.linkText("Каталог"))).click();
        List<WebElement> popularCategories = driver.findElements(By.xpath("//ul[contains(@class,'catalog-bar')]/li"));
        int numberOfTopic = (int) (Math.random() * popularCategories.size());
        String popularCategoryName = popularCategories.get(numberOfTopic).getText();
        popularCategories.get(numberOfTopic).click();
        WebElement CategoryNameExpected = driver.findElement(By.xpath("//h1[contains(@class,'header')]"));
        wait.until(ExpectedConditions.visibilityOf(CategoryNameExpected));
        Assert.assertEquals(CategoryNameExpected.getText(), popularCategoryName);
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
