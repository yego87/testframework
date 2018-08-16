package com.epam.framework.utils;

import com.github.javafaker.Faker;

/**
 * Util class for generation
 * fake data
 */
public class FakerGenerator {

    //instance of Faker class
    private static Faker faker = new Faker();

    /**
     * Method generate fake
     * job title
     * @return String
     */
    public static String generateJobTitle() {
        return faker.job().title();
    }

    /**
     * Method generate fake city
     * @return String
     */
    public static String generateCity () {
        return faker.address().country();
    }

    /**
     * Method generate fake name
     * of team
     * @return String
     */
    public static String generateTeam () {
        return faker.job().field();
    }
}
