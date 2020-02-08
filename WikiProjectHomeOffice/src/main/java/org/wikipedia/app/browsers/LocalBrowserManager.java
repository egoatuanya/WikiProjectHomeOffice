package org.wikipedia.app.browsers;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.wikipedia.app.utilities.Settings;

public class LocalBrowserManager {

    private WebDriver driver;

    public  WebDriver createLocalBrowser()
    {
        String browserName = Settings.getTestConfig("browser.name").toLowerCase();
        if (browserName.contains("chrome"))
        {
            createChromeBrowser();
        }else if (browserName.contains("firefox"))
        {
            createFirefoxBrowser();
        }
        else if (browserName.contains("ie"))
        {
            createIEBrowser();
        }
        else if (browserName.contains("safari"))
        {
            createSafariBrowser();
        }
        else if (browserName.contains("edge"))
        {
            createEdgeBrowser();
        }
        return driver;
    }

    private void createEdgeBrowser() {

        //System.setProperty("webdriver.edge.driver", DriverPathManager.getEdgePath());
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();

        driver = new EdgeDriver(options);

    }

    private void createSafariBrowser() {

        SafariOptions options = new SafariOptions();

        driver = new SafariDriver(options);
    }

    private void createIEBrowser() {
        //System.setProperty("webdriver.ie.driver", DriverPathManager.getIePath());
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.destructivelyEnsureCleanSession();
        options.ignoreZoomSettings();
        options.introduceFlakinessByIgnoringSecurityDomains();
        driver = new InternetExplorerDriver(options);
    }

    private void createFirefoxBrowser() {
        //System.setProperty("webdriver.gecko.driver", DriverPathManager.getFirefoxPath());
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--marionette");
        driver = new FirefoxDriver(options);

    }

    private void createChromeBrowser() {
        //System.setProperty("webdriver.chrome.driver",DriverPathManager.getChromePath());
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--incognito");
        options.addArguments("--enable-javascript");
        options.addArguments("--disable-websecurity");
        driver = new ChromeDriver(options);
    }
}
