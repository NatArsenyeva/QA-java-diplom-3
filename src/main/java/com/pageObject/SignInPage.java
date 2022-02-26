package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SignInPage {

    public static final String URL_SIGN_IN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    // Поле "Email"
    @FindBy(how = How.XPATH,using = "//label[text()='Email']/following-sibling::input")
    private SelenideElement email;

    // Поле "Пароль"
    @FindBy(how = How.XPATH,using = "//label[text()='Пароль']/following-sibling::input")
    private SelenideElement password;

    // Кнопка "Войти"
    @FindBy(how = How.XPATH,using = "//button[text()='Войти']")
    private SelenideElement enterBtn;

    // Кнопка "Восстановить пароль"
    @FindBy(how = How.XPATH,using = "//a[@href=\"/forgot-password\"]")
    private SelenideElement restorePasswordBtn;

    public MainPage signIn(Map<String,String> userCredentials){
        this.email.setValue(userCredentials.get("email"));
        this.password.setValue(userCredentials.get("password"));
        enterBtn.click();
        return page(MainPage.class);
    }

    public SignInPage checkGoToSignInPage(){
        webdriver().shouldHave(url(URL_SIGN_IN_PAGE));
        return this;
    }


}
