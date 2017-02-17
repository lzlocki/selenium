package tips;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.protocol.ResponseContent;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class StatusCodes {

    WebDriver driver;
//    BrowserMobProxy proxy;

    @BeforeTest
    public void setUp() throws Exception {
    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver.exe");
        // start the proxy immediately
//        proxy = new BrowserMobProxyServer();
//        proxy.start(0);

        // create a proxy instance and configure Selenium to use it
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // create an instance of Selenium connected to the proxy
//        driver = new FirefoxDriver(capabilities);
        driver = new FirefoxDriver();

        // enable detailed HAR capture
//        proxy.enableHarCaptureTypes(
//                CaptureType.REQUEST_CONTENT,
//                CaptureType.RESPONSE_CONTENT);
    }

    @AfterTest
    public void tearDown() throws Exception {
//        proxy.stop();
        driver.quit();
    }

    @Test
    public void ResourceNotFound() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
//        proxy.newHar();
//        driver.navigate().to("http://the-internet.herokuapp.com/status_codes/404");
        int code = getStatusCode("http://the-internet.herokuapp.com/status_codes/404");
        System.out.println(code);
//        Har har = proxy.getHar();
//        int response = har.getLog().getEntries().get(0).getResponse().getStatus();
//        Assert.assertEquals(code, 404);
    }
    
    public int getStatusCode(String url) throws MalformedURLException, IOException {
    	WebClient web = new WebClient();
//    	int code = web.getPage(url).getWebResponse().getStatusCode();
    	System.out.println(web.getPage(url));
    	web.close();
    	return 1;
    }
    
    public int getStatusCode2(String url) {
//    	Response res = giv
    	return 1;
    }

}
