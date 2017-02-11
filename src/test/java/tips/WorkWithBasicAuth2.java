package tips;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkWithBasicAuth2 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @After
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