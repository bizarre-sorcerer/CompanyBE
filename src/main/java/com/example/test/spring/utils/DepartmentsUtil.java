package com.example.test.spring.utils;

import org.mapstruct.Named;

public class DepartmentsUtil {
    @Named("convertToInteger")
    public static Integer toInteger(String value) {
        if (value == null || value.isEmpty()){
            return null;
        }

        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e){
            return null;
        }
    }

    @Named("convertToString")
    public static String toString(Integer value) {
        if (value == null){
            return null;
        }

        return String.valueOf(value);
    }
}
