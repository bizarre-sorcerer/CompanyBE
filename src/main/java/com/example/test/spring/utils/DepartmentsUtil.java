package com.example.test.spring.utils;

import org.mapstruct.Named;

public class DepartmentsUtil {
    @Named("convertToInteger")
    public static Integer convertToInteger(String value) {
        if (value != null && !value.isEmpty()){
            return Integer.valueOf(value);
        }
        return null;
    }

    @Named("convertToString")
    public static String convertToString(Integer value) {
        if (value != null){
            return String.valueOf(value);
        }
        return null;
    }
}
