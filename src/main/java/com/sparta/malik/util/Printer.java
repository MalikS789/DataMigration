package com.sparta.malik.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Printer {

    private static Logger logger = LogManager.getLogger(Printer.class);

    public static void printMessage(String message) {
        if (message == null) {
            printErrorMessage(new Exception("Cannot print null string!"));
        } else {
            System.out.println(message);
        }
    }

    public static void printArray(int[] array) {
        if (array.length < 1) {
            printErrorMessage(new Exception("Cannot print an empty array!"));
        } else {
            System.out.println(Arrays.toString(array));
        }
    }

    public static void printErrorMessage(Exception message) {
       System.err.println(message.getMessage());
        logger.error("Exception raised : " + message.getMessage(), message);
    }
}
