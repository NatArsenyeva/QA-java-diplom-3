import com.UserOperations;
import com.pageObject.SignInPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

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
        signInPage = open(SignInPage.URL_SIGN_IN_PAGE, SignInPage.class);
    }

    @DisplayName("Переход из Личного кабинета на Главную страницу по клику на «Конструктор»")
    @Test
    public void goToMainPageFromAccountPageThroughConstructorBtnTest(){
        signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn()
                .goToMainPageThroughConstructorBtn()
                .checkGoToMainPage();
    }

    @DisplayName("Переход из Личного кабинета на Главную страницу по клику на логотип Stellar Burgers")
    @Test
    public void goToMainPageFromAccountPageThroughStellarBurgersBtnTest(){
        signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn()
                .goToMainPageThroughStellarBurgersBtn()
                .checkGoToMainPage();
    }


    @DisplayName("Выход из аккаунта")
    @Test
    public void signOutTest(){
        signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn()
                .signOut()
                .checkGoToSignInPage();
    }

    @After
    public void tearDown(){
        userOperations.delete();
        webdriver().driver().close();
    }

}
