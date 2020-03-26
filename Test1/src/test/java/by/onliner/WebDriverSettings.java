package by.onliner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSettings {
    public  FirefoxDriver driver;
    @Before
    public void SetUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void Close(){
       // driver.quit();
    }
}
