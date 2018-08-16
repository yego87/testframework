package com.epam.framework.data;

import com.epam.framework.utils.FakerGenerator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

/**
 * Class for data in tests
 */
public class SearchJobData {

    private static final String CORRECT_TITLE = "Java Developer";
    private static final String CORRECT_COUNTRY = "all_Belarus";
    private static final String CORRECT_FILTER = "Разработка";

    private String jobTitle;
    private String city;
    private String filter;

    private SearchJobData(String jobTitle, String city, String filter) {
        super();
        this.jobTitle = jobTitle;
        this.city = city;
        this.filter = filter;
    }

    @DataProvider(name = "SearchData")
    public static Object[][] dataProvider() {
        return new Object[][]{
            {CORRECT_TITLE, CORRECT_COUNTRY, CORRECT_FILTER},
            {FakerGenerator.generateJobTitle(), FakerGenerator.generateCity(), FakerGenerator.generateTeam()}
    };
}

    @Factory(dataProvider="SearchData")
    public Object[] createInstances(String jobTitle, String country, String filter) {
        return new Object[] {new SearchJobData(jobTitle, country, filter)};
    }
}
