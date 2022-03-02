import com.UserOperations;
import com.model.Login;
import com.model.Tokens;
import com.model.User;
import com.pageObject.SignUpPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SignUpTest {

    private SignUpPage signUpPage;
    private UserOperations userOperations;
    private User user;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        signUpPage = open(SignUpPage.URL_SIGN_UP_PAGE, SignUpPage.class);
        userOperations = new UserOperations();
    }

    @DisplayName("Успешная регистрация")
    @Test
    public void signUpTest(){
        user = User.getRandomUser();
        signUpPage.signUp(user);
        assertThat("Не найдена кнопка 'Вход'. Пользователь не был зарегистрирован.",
                signUpPage.getEnterBtn().shouldHave(visible).isDisplayed(),is(true));
    }

    @DisplayName("Проверка требования «Минимальный пароль» — 6 символов. Указано 5 символов")
    @Test
    public void doNotSignUpWithPasswordSmallerSixCharactersTest(){
        user = User.getRandomUserWithPassword("12345");
        signUpPage.signUp(user);
        assertThat("Не отработала валидация на количество символов. " +
                        "Не отображается текст 'Некорректный пароль'.",
                signUpPage.getIncorrectPassword().shouldHave(visible).isDisplayed(),is(true));
        assertThat("Не отработала валидация на количество символов. " +
                        "Произошел переход на экран авторизации созданного пользователя.",
                signUpPage.getSingUpBtn().shouldHave(visible).isDisplayed(),is(true));
    }

    @DisplayName("Проверка требования «Минимальный пароль» — 6 символов. Указано 6 символов")
    @Test
    public void signUpWithPasswordOfSixCharactersTest(){
        user = User.getRandomUserWithPassword("123456");
        signUpPage.signUp(user);
        assertThat("Не найдена кнопка 'Вход'. Пользователь не был зарегистрирован.",
                signUpPage.getEnterBtn().shouldHave(visible).isDisplayed(),is(true));
    }

    @DisplayName("Проверка требования «Минимальный пароль» — 6 символов. Указано 7 символов")
    @Test
    public void signUpWithPasswordBiggerSixCharactersTest(){
        user = User.getRandomUserWithPassword("1234567");
        signUpPage.signUp(user);
        assertThat("Не найдена кнопка 'Вход'. Пользователь не был зарегистрирован.",
                signUpPage.getEnterBtn().shouldHave(visible).isDisplayed(),is(true));
    }

    @After
    public void tearDown(){
        webdriver().driver().close();
        //авторизуемся для получения токена, чтобы удалить пользователя
        if (Tokens.getAccessToken() != null) {
            userOperations.login(Login.getUserCredentials(user));
        }
        userOperations.delete();
    }



}
