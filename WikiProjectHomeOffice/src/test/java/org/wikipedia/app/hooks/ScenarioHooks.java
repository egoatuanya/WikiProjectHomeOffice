package org.wikipedia.app.hooks;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.wikipedia.app.browsers.BrowserFactory;

public class ScenarioHooks {

    private BrowserFactory bf;

    //@Before(order = 1)
    @Before(order=1)
    public void startTest1()
    {
        bf = new BrowserFactory();
        bf.initialiseBrowser();
    }


    @Before(order = 2)
    public void startTest2()
    {
        bf.prepareBrowser();
    }

    @After
    public void stopTest()
    {
        bf.deInitialiseBrowser();
    }

}





