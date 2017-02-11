package tips;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ABTestOptOut {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
//    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver.exe");
    	System.setProperty("webdriver.gecko.driver", "c:\\selenium\\webdriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void WithCookieAfterVisitingPage() {
        driver.get("http://the-internet.herokuapp.com/abtest");
        String headingText = driver.findElement(By.tagName("h3")).getText();
        assertThat(headingText, startsWith("A/B Test"));
        driver.manage().addCookie(new Cookie("optimizelyOptOut", "true"));
        driver.navigate().refresh();
        headingText = driver.findElement(By.cssSelector("h3")).getText();
        assertThat(headingText, is("No A/B Test"));
    }

    @Test
    public void WithCookieBeforeVisitingPage() {
        driver.get("http://the-internet.herokuapp.com");
        driver.manage().addCookie(new Cookie("optimizelyOptOut", "true"));
        driver.get("http://the-internet.herokuapp.com/abtest");
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("No A/B Test"));
    }

    @Test
    public void WithOptOutUrl() {
        driver.get("http://the-internet.herokuapp.com/abtest?optimizely_opt_out=true");
        driver.switchTo().alert().dismiss();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("No A/B Test"));
    }

}
