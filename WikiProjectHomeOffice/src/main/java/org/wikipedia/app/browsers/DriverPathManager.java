package org.wikipedia.app.browsers;



import org.wikipedia.app.utilities.Settings;

import java.util.NoSuchElementException;

public class DriverPathManager {

    private static String systemPath = System.getProperty("user.dir");
    private static String osName = System.getProperty("os.name").toLowerCase();
    private static String browserName = Settings.getTestConfig("browser.name");

    public static String getChromePath()
    {
        if (osName.contains("linux") && browserName.contains("chrome"))
        {
            return systemPath + "/Drivers/Linux/chromedriver";

        }else if (osName.contains("unix") && browserName.contains("chrome"))
        {
            return systemPath + "/Drivers/MacOsx/chromedriver";
        }else if(osName.contains("window") && browserName.contains("chrome"))
        {
            return systemPath + "\\Drivers\\Windows\\chromedriver.exe";

        }else
        {
            throw new NoSuchElementException("no such os");
        }


    }

    public static String getFirefoxPath()
    {
        if (osName.contains("linux") && browserName.contains("firefox"))
        {
            return systemPath + "/Drivers/Linux/geckodriver";

        }else if (osName.contains("unix") && browserName.contains("firefox"))
        {
            return systemPath + "/Drivers/MacOsx/geckodriver";
        }else if(osName.contains("window") && browserName.contains("firefox"))
        {
            return systemPath + "\\Drivers\\Windows\\geckodriver.exe";

        }else
        {
            throw new NoSuchElementException("no such os");
        }


    }

    public static String getIePath()
    {

        if(osName.contains("window") && browserName.contains("ie"))
        {
            return systemPath + "\\Drivers\\Windows\\IEDriverServer.exe";

        }else
        {
            throw new NoSuchElementException("no such os");
        }


    }

    public static String getEdgePath()
    {

        if(osName.contains("window") && browserName.contains("edge"))
        {
            return systemPath + "\\Drivers\\Windows\\MicrosoftWebDriver.exe";

        }else
        {
            throw new NoSuchElementException("no such os");
        }


    }
}


