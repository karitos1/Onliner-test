package by.onliner;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import jdk.nashorn.internal.ir.SwitchNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSettings {
    public WebDriver driver;
    public ChromeDriver chromeDriver;
    public InternetExplorerDriver IEDriver;
    String browser = "ie";

    @Before
    public void SetUp() {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.ie.driver","src/main/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                this.driver.manage().deleteAllCookies();
        }
    }

    @After
    public void Close(){
       // driver.quit();
    }

}

