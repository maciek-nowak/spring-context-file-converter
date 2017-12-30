package com.codecool.enums;

public enum OutputFormats {
    TABLE,
    XML,
    JSON;

    public static boolean contains(String format) {
        return true;
    }

    public static OutputFormats getOutputFormat(String format) {
        return OutputFormats.valueOf(format.toUpperCase());
    }
}
