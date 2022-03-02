package com.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Data
public class MainPage extends HeaderPage {

    public static final String URL_MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";

    // Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = "//button[text()='Войти в аккаунт']")
    private SelenideElement enterInAccountBtn;

    // Кнопка "Оформить заказ"
    @FindBy(how = How.XPATH,using = "//button[text()='Оформить заказ']")
    private SelenideElement toOrderBtn;

    // Кнопка "Булки"
    @FindBy(how = How.XPATH,using = "//span[text()='Булки']")
    private SelenideElement bunsBtn;

    // Выделенная "Булки"
    @FindBy(how = How.XPATH,using = "//span[text()='Булки']/parent::div[contains(@class,'current')]")
    private SelenideElement bunsBtnSelected;

    // Заголовок "Булки"
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Булки')]")
    private SelenideElement headerBunsBtn;

    // Кнопка "Соусы"
    @FindBy(how = How.XPATH,using = "//span[text()='Соусы']")
    private SelenideElement saucesBtn;

    // Заголовок "Соусы"
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Соусы')]")
    private SelenideElement headerSaucesBtn;

    // Выделенная кнопка "Соусы"
    @FindBy(how = How.XPATH,using = "//span[text()='Соусы']/parent::div[contains(@class,'current')]")
    private SelenideElement saucesBtnSelected;

    // Кнопка "Начинки"
    @FindBy(how = How.XPATH,using = "//span[text()='Начинки']")
    private SelenideElement fillingsBtn;

    // Заголовок "Начинки"
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Начинки')]")
    private SelenideElement headerFillingsBtn;

    // Выделенная кнопка "Начинки"
    @FindBy(how = How.XPATH,using = "//span[text()='Начинки']/parent::div[contains(@class,'current')]")
    private SelenideElement fillingsBtnSelected;

    @Step("Кликнуть на кнопку 'Войти в аккаунт'.")
    public SignInPage goToSignInPageThroughEnterInAccountBtn(){
        enterInAccountBtn.click();
        return page(SignInPage.class);
    }

    @Step("Кликнуть на кнопку 'Личный кабинет'.")
    public SignInPage goToSignInPageThroughAccountBtn(){
        accountBtn.click();
        return page(SignInPage.class);
    }

    @Step("Кликнуть на кнопку 'Личный кабинет'.")
    public AccountPage goToAccountPageThroughAccountBtn(){
        accountBtn.click();
        return page(AccountPage.class);
    }

    @Step("Кликнуть на кнопку 'Булки'.")
    public MainPage goToBunsConstructor(){
        bunsBtn.shouldBe(enabled).click();
        return this;
    }

    @Step("Кликнуть на кнопку 'Соусы'.")
    public MainPage goToSaucesConstructor(){
        saucesBtn.click();
        return this;
    }

    @Step("Кликнуть на кнопку 'Начинки'.")
    public MainPage goToFillingsConstructor(){
        fillingsBtn.click();
        return this;
    }

}
