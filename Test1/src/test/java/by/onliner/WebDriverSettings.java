package by.onliner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.Configuration;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public WebDriver driver;

    @Before
    public void SetUp() {

        switch (Configuration.getProperty("browser")) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                WebDriverManager.chromedriver().version("80.0.3987.16").setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.ie.driver","src/main/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                this.driver.manage().deleteAllCookies();
        }

        driver.manage().window().maximize();
        driver.get(Configuration.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Configuration.getProperty("timeOutImplicitly")), TimeUnit.SECONDS);
    }

    @After
    public void Close(){
        driver.quit();
    }
}

