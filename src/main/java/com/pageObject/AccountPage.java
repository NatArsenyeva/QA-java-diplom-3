package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

@Data
public class AccountPage extends HeaderPage{

    public static final String URL_ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";

    // Раздел "Профиль"
    @FindBy(how = How.XPATH,using = "//a[@href='/account/profile']")
    private SelenideElement profileTab;

    // Кнопка "Выход"
    @FindBy(how = How.XPATH,using = "//button[text()=\"Выход\"]")
    private SelenideElement signOutBtn;

    @Step("Кликнуть на кнопку 'Конструктор' из 'Главной страницы'.")
    public MainPage goToMainPageThroughConstructorBtn(){
        constructorBtn.click();
        return page(MainPage.class);
    }

    @Step("Кликнуть на иконку 'stellar burgers' из 'Главной страницы'.")
    public MainPage goToMainPageThroughStellarBurgersBtn(){
        stellarBurgersIcon.click();
        return page(MainPage.class);
    }

    @Step("Кликнуть на кнопку 'Выйти'.")
    public SignInPage signOut(){
        signOutBtn.click();
        return page(SignInPage.class);
    }

}
