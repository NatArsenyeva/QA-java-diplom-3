package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import com.model.User;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

@Data
public class SignUpPage {

    public static final String URL_SIGN_UP_PAGE = "https://stellarburgers.nomoreparties.site/register";

    // Поле "Имя"
    @FindBy(how = How.XPATH,using = "//label[text()='Имя']/following-sibling::input")
    private SelenideElement name;

    // Поле "Email"
    @FindBy(how = How.XPATH,using = "//label[text()='Email']/following-sibling::input")
    private SelenideElement email;

    // Поле "Пароль"
    @FindBy(how = How.XPATH,using = "//label[text()='Пароль']/following-sibling::input")
    private SelenideElement password;

    // Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = "//button[text()='Зарегистрироваться']")
    private SelenideElement singUpBtn;

    // Текст "Некорректный пароль"
    @FindBy(how = How.XPATH,using = "//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPassword;

    // Кнопка "Войти"
    @FindBy(how = How.XPATH,using = "//a[@href=\"/login\"]")
    private SelenideElement enterBtn;

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }


    @Step("Зарегистрировать пользователя.")
    public SignUpPage signUp(User user){
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        singUpBtn.click();
        return this;
    }

    @Step("Нажать на кнопку 'Войти'.")
    public SignInPage goToSignInPageThroughEnterBtn(){
        enterBtn.click();
        return page(SignInPage.class);
    }

}
