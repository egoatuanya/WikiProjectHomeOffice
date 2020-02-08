package org.wikipedia.app.browsers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.wikipedia.app.utilities.Settings;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackManager {
    public static final String USERNAME = Settings.getStackConfig("browserstack.username");
    public static final String AUTOMATE_KEY = Settings.getStackConfig("browserstack.automateKey");
    public static final String URL = "https://\"+USERNAME+ \":\"+AUTOMATE_KEY+\"@hub-cloud.browserstack.com/wd/hub";

    public WebDriver createRemoteBrowser() {

        this.decideBrowser();
        DesiredCapabilities caps = this.decideBrowser();
        caps.setCapability("browser", Settings.getStackConfig("browserstack.browser"));
        caps.setCapability("browser_version", Settings.getStackConfig("browserstack.browser_version"));
        caps.setCapability("os", Settings.getStackConfig("browserstack.os"));
        caps.setCapability("os_version", Settings.getStackConfig("browserstack.os_version"));
        caps.setCapability("resolution", Settings.getStackConfig("browserstack.resolution"));

        caps.setCapability("build", "Build100");
        caps.setCapability("project", "B2M");

        caps.setCapability("browserstack.debug", true);//to enable visual logs
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("browserstack.console", "warnings");
        caps.setCapability("browserstack.video", "true");

        URL url = null;
        try {
            url = new URL(URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebDriver driver = new RemoteWebDriver(url, caps);
        return driver;

    }

    private DesiredCapabilities decideBrowser() {
        DesiredCapabilities caps = new DesiredCapabilities();
        String browser = Settings.getStackConfig("browserstack.browser").toLowerCase();
        return this.selectBrowser(caps, browser);


    }

    private DesiredCapabilities selectBrowser(DesiredCapabilities caps, String browser) {
        if(browser.contains("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-plugins");
            options.addArguments("--enable-javascript");
            options.addArguments("--headless");
            options.addArguments("--incognito");
            options.addArguments("--disable-websecurity");
            caps.setCapability(ChromeOptions.CAPABILITY, options);
        }
        else if(browser.contains("firefox"))
        {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("plugin.state.flash",0);
            caps.setCapability(FirefoxDriver.PROFILE, profile);
        }else if(browser.contains("ie")||browser.contains("internet"))
        {
            caps.setCapability("browserstack.ie.noFlash", "true");
        }
        else if (browser.contains("firefox"))
        {

        }
        else if (browser.contains("safari"))
        {
            caps.setCapability("browserstack.safari.enablePopups", "true");
        }
        return caps;
    }

    public void configChromeCaps()
    {

    }


}

