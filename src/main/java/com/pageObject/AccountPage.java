package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AccountPage extends HeaderPage{

    public static final String URL_ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";

    // Раздел "Профиль"
    @FindBy(how = How.XPATH,using = "//a[@href='/account/profile']")
    private SelenideElement profileTab;

    // Кнопка "Выход"
    @FindBy(how = How.XPATH,using = "//button[text()=\"Выход\"]")
    private SelenideElement signOutBtn;


    public AccountPage checkGoToAccountPage(){
        webdriver().shouldHave(url(URL_ACCOUNT_PAGE));
        profileTab.shouldHave(visible);
        return this;
    }

    public MainPage goToMainPageThroughConstructorBtn(){
        constructorBtn.click();
        return page(MainPage.class);
    }

    public MainPage goToMainPageThroughStellarBurgersBtn(){
        stellarBurgersIcon.click();
        return page(MainPage.class);
    }

    public SignInPage signOut(){
        signOutBtn.click();
        return page(SignInPage.class);
    }


}
