package com.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeaderPage {

    // Кнопка "Конструктор"
    @FindBy(how = How.XPATH,using = "//p[text()='Конструктор']")
    protected SelenideElement constructorBtn;

    // Иконка "stellar burgers"
    @FindBy(how = How.XPATH,using = "//div[contains(@class,\"header__logo\")]")
    protected SelenideElement stellarBurgersIcon;

    // Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH,using = "//p[text()='Личный Кабинет']")
    protected SelenideElement accountBtn;

}
