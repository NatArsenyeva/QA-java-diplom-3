import com.UserOperations;

import com.pageObject.AccountPage;
import com.pageObject.MainPage;
import com.pageObject.SignInPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MainPageTest {

    private MainPage mainPage;
    private SignInPage signInPage;
    private AccountPage accountPage;
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
        accountPage = signInPage.signIn(user)
                .goToAccountPageThroughAccountBtn();
        assertThat("Не произошел переход на страницу Личный кабинет.",
                accountPage.getProfileTab().shouldHave(visible).isDisplayed(),is(true));
    }

    @DisplayName("Переход к разделу 'Булки'")
    @Test
    public void goToBunsConstructorTest() {
        mainPage =  open(MainPage.URL_MAIN_PAGE,MainPage.class);
        mainPage.goToSaucesConstructor()
                .goToBunsConstructor();
        assertThat("Не выбран раздел 'Булки'.",
                mainPage.getBunsBtnSelected().shouldHave(visible).isDisplayed(),is(true));
        assertThat("Не найден заголовок 'Булки'.",
                mainPage.getHeaderBunsBtn().hover().is((visible)),is(true));
    }

    @DisplayName("Переход к разделу 'Соусы'")
    @Test
    public void goToSaucesConstructorTest() {
        mainPage =  open(MainPage.URL_MAIN_PAGE,MainPage.class);
        mainPage.goToSaucesConstructor();
        assertThat("Не выбран раздел 'Соусы'.",
                (mainPage.getSaucesBtnSelected()).shouldHave(visible).isDisplayed(),is(true));
        assertThat("Не найден заголовок 'Соусы'.",
                mainPage.getHeaderSaucesBtn().hover().is((visible)),is(true));
    }

    @DisplayName("Переход к разделу 'Начинки'")
    @Test
    public void goToFillingsConstructorTest() {
        mainPage =  open(MainPage.URL_MAIN_PAGE,MainPage.class);
        mainPage.goToFillingsConstructor();
        assertThat("Не выбран раздел 'Начинки'.",
                (mainPage.getFillingsBtnSelected()).shouldHave(visible).isDisplayed(),is(true));
        assertThat("Не найден заголовок 'Начинки'.",
                mainPage.getHeaderFillingsBtn().hover().is((visible)),is(true));
    }

    @After
    public void tearDown(){
        userOperations.delete();
        webdriver().driver().close();
    }


}