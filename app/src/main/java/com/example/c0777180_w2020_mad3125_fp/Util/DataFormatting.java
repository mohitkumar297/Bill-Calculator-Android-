package com.example.c0777180_w2020_mad3125_fp.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFormatting {

    public static String stringToDouble(Double d)
    {
        return String.format("$ " + "%.2f", d);
    }
    public static boolean validateEmail(String s) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public static boolean mobileValidate(String str)
    {
        if(str.length() == 10)
        {
            return true;
        }
        return false;
    }

}
