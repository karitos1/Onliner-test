package by.onliner;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import jdk.nashorn.internal.ir.SwitchNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSettings {
    public  FirefoxDriver driver;
    public ChromeDriver chromeDriver;
    public InternetExplorerDriver IEDriver;
    String browser;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();

        System.setProperty("webdriver.chromedriver", "src/main/resources/drivers/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @After
    public void Close(){
       // driver.quit();
    }

}

