package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract class BreadcrumbsMenu extends TopMenu{
    @FindBy(xpath = "//ul[@class='items']")
    private WebElement breadcrumbsMenu;

    protected BreadcrumbsMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Collect Breadcrumps Menu Text")
    public String getBreadcrumpsMenuText() {

        return getWait().until(ExpectedConditions.visibilityOf(breadcrumbsMenu)).getText();

    }
}
