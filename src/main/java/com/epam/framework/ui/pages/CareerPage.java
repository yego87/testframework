package com.epam.framework.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Class describe Career Page
 */
public class CareerPage extends BasePage {

    @FindBy(id = "new_form_job_search-keyword")
    private WebElement searchJobField;

    @FindBy(className = "search-result__header")
    private WebElement searchResultElement;

    @FindBy(id = "new_form_job_search-location")
    private WebElement selectListCountry;

    @FindBy(xpath = "//div[@class='multi-select-dropdown']//ul/li//span[contains(text(), '')]")
    private List<WebElement> listFilters;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;


    /**
     * Method fill needed data
     * @param jobTitle
     * @param country
     * @param filter
     */
    public void fillJobData(String jobTitle, String country, String filter) {
        type(searchJobField, jobTitle);
        new Select(selectListCountry).selectByValue(country);
        listFilters.stream()
                .filter(checkBoxElement -> checkBoxElement.getText().equals(filter))
                .forEach(WebElement::click);
        buttonSearch.click();
    }

    /**
     * Assert that check correct search
     * @return
     */
    public boolean isSearchCorrect() {
        return isElementPresent(searchResultElement);
    }

    @Override
    public void open() {
    }
}