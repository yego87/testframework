package com.epam.framework.ui.pages;

import com.epam.framework.utils.TestProperties;

/**
 * Class describe elements
 * on Main Career Page
 */
public class MainCareerPage extends BasePage {

    //instance of career page
    private CareerPage careerPage = new CareerPage();

    /**
     * Method open career page
     * @return careerPage
     */
    public CareerPage openCareerPage() {
        careerLink.click();

        return careerPage;
    }

    @Override
    public void open() {
        driver.get(TestProperties.getTestProperty("main.career.page.url"));
    }
}
