package tips;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithBasicAuth2 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver.exe");
    	FirefoxProfile profile = new FirefoxProfile();
    	profile.setPreference("network.http.phishy-userpass-length", 255);
    	driver = new FirefoxDriver(profile);
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void workWithBasicAuthTest2() {
        driver.get("http://the-internet.herokuapp.com/basic_auth");
        String pageMessage = driver.findElement(By.cssSelector("p")).getText();
        assertThat(pageMessage, containsString("Congratulations!"));
    }

}