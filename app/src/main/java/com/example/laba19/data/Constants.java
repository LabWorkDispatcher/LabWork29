package com.example.laba19.data;


public class Constants {
    public static String[] units = new String[]{"mm", "cm", "m", "km", "ft", "yard", "mile"};
    public static float[] relativity = new float[]{0.1F, 0.01F, 0.001F, 3280.84F, 0.333333F, 0.0005681F};

    public static int APP_MEASUREMENT_DEGREES_TO_PI_RADIANS = 180;
    public static int APP_MEASUREMENT_GRADIANS_TO_PI_RADIANS = 200;

    public static int APP_MEASUREMENT_TYPE_DEGREES = 0;
    public static int APP_MEASUREMENT_TYPE_RADIANS = 1;
    public static int APP_MEASUREMENT_TYPE_GRADIANS = 2;
    public static int APP_MEASUREMENT_TYPES_COUNT = 3;

    public static String APP_CHANNEL_ID = "2187995";

    public static String APP_DEFAULT_TEXT_CALCULATION = "Successful calculation!";
    public static String APP_DEFAULT_TEXT_EQUALIZATION = "Successful equalization!";
    public static String APP_DEFAULT_TEXT_TRIGONOMETRIC = "Successful trigonometric calculation!";
    public static String APP_DEFAULT_TEXT_LOGARITHMIC = "Successful logarithmic calculation!";
}
