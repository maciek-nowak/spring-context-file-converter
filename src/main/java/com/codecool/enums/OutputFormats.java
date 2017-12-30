package com.codecool.enums;

public enum OutputFormats {
    TABLE,
    XML,
    JSON;

    public static boolean contains(String givenFormat) {

        for (OutputFormats outputFormat : OutputFormats.values()) {
            if (outputFormat.name().equals(givenFormat.toUpperCase()))
                return true;
        }

        return false;
    }

    public static OutputFormats getOutputFormat(String format) {
        return OutputFormats.valueOf(format.toUpperCase());
    }
}
