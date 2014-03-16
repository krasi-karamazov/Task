package kpk.dev.utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by krasimirkaramazov on 3/16/14.
 */
public class Constants {

    protected static final int ASCII_TABLE_LETTERS_START = 97;
    protected static final int ASCII_TABLE_LETTERS_END = 122;

    protected static final int LOW_FIRST_NAME = 3;
    protected static final int HIGH_FIRST_NAME = 10;

    protected static final int LOW_LAST_NAME = 5;
    protected static final int HIGH_LAST_NAME = 14;

    protected static final int LOW_NUM_SUBORDINATES = 1;
    protected static final int HIGH_NUM_SUBORDINATES = 25;

    protected static final double HIGH_WORKER_SCORE = 10.0;

    protected static final Random RAND = new Random(System.currentTimeMillis());

    public static final DecimalFormat SCORE_FORMAT = new DecimalFormat("0.0");

    public static final int NUM_MANAGERS = 12;
}
