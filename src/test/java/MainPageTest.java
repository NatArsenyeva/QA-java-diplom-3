import com.UserOperations;
import com.model.Tokens;
import com.pageObject.MainPage;
import com.pageObject.SignInPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    private MainPage mainPage;
    private SignInPage signInPage;
    private UserOperations userOperations;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        userOperations = new UserOperations();
    }

    @DisplayName("Переход в Личный кабинет")
    @Test
    public void goToAccountPageTest() {
        Map<String,String> user = userOperations.register();
        signInPage =  open(SignInPage.URL_SIGN_IN_PAGE,SignInPage.class);
        signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn()
                .checkGoToAccountPage();
    }

    @DisplayName("Переход к разделу 'Булки'")
    @Test
    public void goToBunsConstructorTest() {
        mainPage =  open(MainPage.URL_MAIN_PAGE,MainPage.class);
        mainPage.goToSaucesConstructor()
                .goToBunsConstructor()
                .checkGoToBunsConstructor();
    }

    @DisplayName("Переход к разделу 'Соусы'")
    @Test
    public void goToSaucesConstructorTest() {
        mainPage =  open(MainPage.URL_MAIN_PAGE,MainPage.class);
        mainPage.goToSaucesConstructor()
                .checkGoToSaucesConstructor();
        System.out.println(Tokens.getAccessToken());
    }

    @DisplayName("Переход к разделу 'Начинки'")
    @Test
    public void goToFillingsConstructorTest() {
        mainPage =  open(MainPage.URL_MAIN_PAGE,MainPage.class);
        mainPage.goToFillingsConstructor()
                .checkGoToFillingsConstructor();
    }

    @After
    public void tearDown(){
        userOperations.delete();
        webdriver().driver().close();
    }


}