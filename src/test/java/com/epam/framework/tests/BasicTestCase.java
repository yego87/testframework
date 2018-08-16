package com.epam.framework.tests;

import com.epam.framework.core.driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * Basic abstract class for all tests
 */
public abstract class BasicTestCase {

    @BeforeSuite(alwaysRun = true)
    public void setUpBeforeSuite() throws Exception {
    }

    @BeforeClass(alwaysRun = true)
    public void setUpBeforeClass() throws Exception {
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        Driver.killBrowser();
    }

}