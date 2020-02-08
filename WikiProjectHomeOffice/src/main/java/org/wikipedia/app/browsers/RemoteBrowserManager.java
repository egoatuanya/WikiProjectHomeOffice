package org.wikipedia.app.browsers;



import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RemoteBrowserManager {


    public WebDriver createRemoteBrowser()  {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setPlatform(Platform.ANY);
        //caps.setVersion("");
        URL url = null;
        try {
            url = new URL("http://192.168.184.139.4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebDriver driver = new RemoteWebDriver(url, caps);
        return driver;
    }
}
