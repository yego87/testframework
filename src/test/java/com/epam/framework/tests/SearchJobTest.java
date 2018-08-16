package com.epam.framework.tests;

import com.epam.framework.data.SearchJobData;
import com.epam.framework.reports.TestLogger;
import com.epam.framework.ui.pages.*;
import com.epam.framework.reports.ReportListener;
import com.epam.framework.reports.TestListners;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This test case contain different tests for GitHub fiches
 */
@Listeners({TestListners.class, ReportListener.class})
public class SearchJobTest extends BasicTestCase {

    //pages
    private MainCareerPage mainCareerPage = new MainCareerPage();
    private CareerPage careerPage = new CareerPage();

    @BeforeTest(
            description = "Generate fake data and login in GitHub account",
            alwaysRun = true
    )
    public void setUp() {
        mainCareerPage.open();
    }

    @Test(
            description = "Test check that search of job work correct",
            dataProvider = "SearchData",
            dataProviderClass = SearchJobData.class
    )
    public void checkThatJobSearchWork(String jobTitle, String country, String filter) {
        mainCareerPage.openCareerPage();
        careerPage.fillJobData(jobTitle, country, filter);

        TestLogger.info("Assert that search function is work");
        Assert.assertTrue(careerPage.isSearchCorrect());
    }

}
