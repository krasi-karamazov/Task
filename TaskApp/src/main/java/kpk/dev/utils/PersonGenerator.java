package kpk.dev.utils;

import kpk.dev.models.Person;

/**
 * Created by krasimirkaramazov on 3/16/14.
 */
public class PersonGenerator {

    public static Person generatePerson() {
        Person p = new Person();
        p.setFirstName(generateName(Constants.RAND.nextInt(Constants.HIGH_FIRST_NAME - Constants.LOW_FIRST_NAME) + Constants.LOW_FIRST_NAME));
        p.setLastName(generateName(Constants.RAND.nextInt(Constants.HIGH_LAST_NAME - Constants.LOW_LAST_NAME) + Constants.LOW_LAST_NAME));
        return p;
    }

    private static String generateName(int length) {
        final StringBuilder builder = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            builder.append((char)(Constants.RAND.nextInt(Constants.ASCII_TABLE_LETTERS_END - Constants.ASCII_TABLE_LETTERS_START) + Constants.ASCII_TABLE_LETTERS_START));
        }
        return builder.toString();
    }

    public static int generateNumSubordinates() {
        return Constants.RAND.nextInt(Constants.HIGH_NUM_SUBORDINATES - Constants.LOW_NUM_SUBORDINATES) + Constants.LOW_NUM_SUBORDINATES;
    }

    public static double generateEmployeeScore() {
        return Constants.RAND.nextDouble() * Constants.HIGH_WORKER_SCORE;
    }
}
