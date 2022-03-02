package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    public static final String URL_FORGOT_PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";

    // Кнопка "Войти"
    @FindBy(how = How.XPATH,using = "//a[@href=\"/login\"]")
    private SelenideElement enterBtn;

    @Step("Кликнуть на кнопку 'Вход'.")
    public SignInPage goToSignInPageThroughEnterBtn(){
        enterBtn.click();
        return page(SignInPage.class);
    }

}
