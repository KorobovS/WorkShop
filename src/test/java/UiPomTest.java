import io.qameta.allure.Story;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import utils.BaseTest;

@Story("UI POM tests")
@Tag("UI")
public class UiPomTest extends BaseTest {
    @Test
    void testLoginPom() {
        LoginPage loginPage = new LoginPage(driver, longWait);
        loginPage.login();

        AssertionsForClassTypes.assertThat(driver.getCurrentUrl()).contains("login-sucess123");
    }
}
