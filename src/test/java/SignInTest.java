import com.UserOperations;
import com.pageObject.ForgotPasswordPage;
import com.pageObject.MainPage;
import com.pageObject.SignUpPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class SignInTest {

    private SignUpPage signUpPage;
    private MainPage mainPage;
    private ForgotPasswordPage forgotPasswordPage;
    private UserOperations userOperations;
    private Map<String,String> user;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        userOperations = new UserOperations();
        signUpPage = new SignUpPage();
        forgotPasswordPage = new ForgotPasswordPage();
        user = userOperations.register();
    }

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void signInThroughEnterInAccountBtnTest(){
        mainPage = open(MainPage.URL_MAIN_PAGE, MainPage.class);
        mainPage.goToSignInPageThroughEnterInAccountBtn()
                .checkGoToSignInPage()
                .signIn(user)
                .checkSignIn();
    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Test
    public void signInThroughAccountBtnTest(){
        mainPage = open(MainPage.URL_MAIN_PAGE, MainPage.class);
        mainPage.goToSignInPageThroughAccountBtn()
                .checkGoToSignInPage()
                .signIn(user)
                .checkSignIn();
    }

    @DisplayName("Вход через кнопку «Войти» в форме регистрации")
    @Test
    public void signInFromSignUpPageThroughEnterBtnTest(){
        signUpPage = open(SignUpPage.URL_SIGN_UP_PAGE, SignUpPage.class);
        signUpPage.goToSignInPageThroughEnterBtn()
                .checkGoToSignInPage()
                .signIn(user)
                .checkSignIn();
    }

    @DisplayName("Вход через кнопку «Войти» в форме восстановления пароля")
    @Test
    public void signInFromForgotPasswordPageThroughEnterBtnTest(){
        forgotPasswordPage = open(ForgotPasswordPage.URL_FORGOT_PASSWORD_PAGE, ForgotPasswordPage.class);
        forgotPasswordPage.goToSignInPageThroughEnterBtn()
                .checkGoToSignInPage()
                .signIn(user)
                .checkSignIn();
    }

    @After
    public void tearDown(){
        userOperations.delete();
        webdriver().driver().close();
    }

}
