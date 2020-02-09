package org.wikipedia.app.browsers;


import org.openqa.selenium.WebDriver;

import org.wikipedia.app.utilities.Settings;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        throw new IllegalAccessError("Browser has not been initialised");
    }

    public void initialiseBrowser()  {
        String placeOfExec = Settings.getTestConfig("place.of.execution");
        if(placeOfExec.equalsIgnoreCase("local"))
        {
            LocalBrowserManager lbm = new LocalBrowserManager();
            driver = lbm.createLocalBrowser();
        }else if(placeOfExec.equalsIgnoreCase("remote"))
        {

//            this.decideMachine();
        }


    }

    public void decideMachine()
    {
        if (Settings.getTestConfig("remote.machine").contains("vm"))
        {
            RemoteBrowserManager rbm = new RemoteBrowserManager();
            rbm.createRemoteBrowser();
            driver = rbm.createRemoteBrowser();
        }
        else
        {
            BrowserStackManager bsm = new BrowserStackManager();
            driver = bsm.createRemoteBrowser();
        }
    }


    public void deInitialiseBrowser()
    {
        // if(driver != null) driver.quit();
    }
}
