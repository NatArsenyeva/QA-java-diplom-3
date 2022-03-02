package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

@Data
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

    // Текст "Вход"
    @FindBy(how = How.XPATH,using = "//h2[text()='Вход']")
    private SelenideElement LoginHeader;


    @Step("Авторизовать пользователя.")
    public MainPage signIn(Map<String,String> userCredentials){
        this.email.setValue(userCredentials.get("email"));
        this.password.setValue(userCredentials.get("password"));
        enterBtn.click();
        return page(MainPage.class);
    }

}
