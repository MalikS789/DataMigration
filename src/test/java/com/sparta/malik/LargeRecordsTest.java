package com.sparta.malik;

import com.sparta.malik.controller.TraineeManager;
import com.sparta.malik.model.CSVEmployeeReader;
import com.sparta.malik.model.EmployeeDTO;
import com.sparta.malik.util.Printer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class LargeRecordsTest {

    @Test
    @DisplayName("Testing to see if the multithreaded version of the employee upload is working (65,500 records)")
    public void LargeRecordsTest() throws IOException, ParseException {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = CSVEmployeeReader.getEmployees("src/main/resources/EmployeeRecordsLarge.csv");
        TraineeManager.uploadAllEmployeesMultiThreaded(employees, 12);
        Long end = System.nanoTime();
        Printer.printMessage("Large Multithreaded Employee Upload (" + 12 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

}
