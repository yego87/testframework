package com.epam.framework.ui.pages;

import com.epam.framework.core.driver.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Describe Base page
 */
public abstract class BasePage {

    /**
     * Web elements
     */
    @FindBy(xpath = "//span[@class='top-navigation__item-text']//a[@href='/careers']")
    protected WebElement careerLink;

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait webDriverWait;
    protected Select select;

    protected BasePage() {

        try {
            driver = Driver.getWebDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, 2);
    }

    protected abstract void open();

    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Write text to fields
     * @param webElement
     * @param text
     */
    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

}