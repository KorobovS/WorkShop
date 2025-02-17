import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseTest;

import static constants.CommonConstants.UI_BASE_URL;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UiTest extends BaseTest {

    @Test
    void submitWebFormTest() {
        driver.get(UI_BASE_URL);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Text");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement title = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", title.getText());
    }

    @Test
    void testLoadingImageImplicit() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement compass = driver.findElement(By.id("compass"));
        WebElement calendar = driver.findElement(By.id("calendar"));
        WebElement award = driver.findElement(By.id("award"));
        WebElement landscape = driver.findElement(By.id("landscape"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(compass.getAttribute("src")).as("Error in search compass").containsIgnoringCase("compass");
        softly.assertThat(calendar.getAttribute("src")).as("Error in search calendar").containsIgnoringCase("calendar");
        softly.assertThat(award.getAttribute("src")).as("Error in search award").containsIgnoringCase("award");
        softly.assertThat(landscape.getAttribute("src")).as("Error in search landscape").containsIgnoringCase("landscape");
    }

    @Test
    void testLoadingImagesExplicit() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement landscape = longWait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }
}
