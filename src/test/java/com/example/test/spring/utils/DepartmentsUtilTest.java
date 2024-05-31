package com.example.test.spring.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentsUtilTest {

    @Test
    void toIntegerNumber() {
        assertInstanceOf(Integer.class, DepartmentsUtil.toInteger("4"));
    }

    @Test
    void toIntegerEmptyString() {
        assertNull(DepartmentsUtil.toInteger(""));
    }

    @Test
    void toIntegerNull(){
        assertNull(DepartmentsUtil.toInteger(null));
    }

    @Test
    void toIntegerWord(){
        assertNull(DepartmentsUtil.toInteger("asdf"));
    }

    @Test
    void toStringNumber() {
        assertInstanceOf(String.class, DepartmentsUtil.toString(5));
    }

    @Test
    void toStringVoid() {
        assertNull(DepartmentsUtil.toString(null));
    }
}