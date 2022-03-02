import com.UserOperations;
import com.pageObject.SignInPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.pageObject.MainPage.URL_MAIN_PAGE;
import static com.pageObject.SignInPage.URL_SIGN_IN_PAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AccountTest {

    private SignInPage signInPage;
    private UserOperations userOperations;
    private Map<String,String> user;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        userOperations = new UserOperations();
        signInPage = new SignInPage();
        user = userOperations.register();
        signInPage = open(URL_SIGN_IN_PAGE, SignInPage.class);
    }

    @DisplayName("Переход из Личного кабинета на Главную страницу по клику на «Конструктор»")
    @Test
    public void goToMainPageFromAccountPageThroughConstructorBtnTest(){
        signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn()
                .goToMainPageThroughConstructorBtn();
        assertThat("Текущий url != url Главной страницы.",webdriver().driver().url(),is(URL_MAIN_PAGE));
    }

    @DisplayName("Переход из Личного кабинета на Главную страницу по клику на логотип Stellar Burgers")
    @Test
    public void goToMainPageFromAccountPageThroughStellarBurgersBtnTest(){
        signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn()
                .goToMainPageThroughStellarBurgersBtn();
        assertThat("Текущий url != url Главной страницы.",webdriver().driver().url(),is(URL_MAIN_PAGE));
    }


    @DisplayName("Выход из аккаунта")
    @Test
    public void signOutTest(){
        signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn()
                .signOut();
        assertThat("Не произошел переход на страницу авторизации.",
                signInPage.getLoginHeader().shouldHave(visible).isDisplayed(),is(true));
        assertThat("Не произошел переход на страницу авторизации.",
                signInPage.getLoginHeader().shouldHave(visible).isDisplayed(),is(true));
    }

    @After
    public void tearDown(){
        userOperations.delete();
        webdriver().driver().close();
    }

}
