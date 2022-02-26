package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

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

    // Кнопка "Булки"
    @FindBy(how = How.XPATH,using = "//span[text()='Булки']/parent::div")
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

    // Кнопка "Начинки"
    @FindBy(how = How.XPATH,using = "//span[text()='Начинки']")
    private SelenideElement fillingsBtn;

    // Заголовок "Начинки"
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Начинки')]")
    private SelenideElement headerFillingsBtn;


    public SignInPage goToSignInPageThroughEnterInAccountBtn(){
        enterInAccountBtn.click();
        return page(SignInPage.class);
    }

    public SignInPage goToSignInPageThroughAccountBtn(){
        accountBtn.click();
        return page(SignInPage.class);
    }

    public void checkSignIn() {
        webdriver().shouldHave(url(URL_MAIN_PAGE));
        toOrderBtn.shouldHave(visible);
        enterInAccountBtn.shouldHave(not(visible));
    }

    public AccountPage goToAccountPageThroughAccountBtn(){
        accountBtn.click();
        return page(AccountPage.class);
    }

    public void checkGoToMainPage() {
        webdriver().shouldHave(url(URL_MAIN_PAGE));
    }

    public MainPage goToBunsConstructor(){
        bunsBtn.click();
        return this;
    }

    public MainPage goToSaucesConstructor(){
        saucesBtn.click();
        return this;
    }

    public MainPage goToFillingsConstructor(){
        fillingsBtn.click();
        return this;
    }

    public void checkGoToBunsConstructor(){
        bunsBtnSelected.shouldHave(visible);
        headerBunsBtn.hover().is(visible);
    }

    public void checkGoToSaucesConstructor(){
        $(saucesBtn).find(By.xpath("./parent::div[contains(@class,'current')]")).shouldHave(visible);
        saucesBtn.hover().is(visible);
    }

    public void checkGoToFillingsConstructor(){
        $(fillingsBtn).find(By.xpath("./parent::div[contains(@class,'current')]")).shouldHave(visible);
        fillingsBtn.hover().is(visible);
    }

}
