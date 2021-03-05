package com.sparta.malik.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

public class CSVEmployeeReaderTest {

    @Test
    public void getEmployeesTest() throws IOException, ParseException {
        CSVEmployeeReader.getEmployees("src/main/resources/employees.csv");
    }

}
