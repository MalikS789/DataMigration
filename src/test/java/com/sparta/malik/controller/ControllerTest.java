package com.sparta.malik.controller;

import com.sparta.malik.model.EmployeeDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ControllerTest {

    @Test
    @DisplayName("A test to see if all employees can be read from the CSV file")
    public void getEmployeesTest() throws Exception {
        TraineeManager.getEmployees();
    }

    @Test
    @DisplayName("A test to see the multithreaded implementation of the employee uploader works")
    public void uploadAllEmployeesMultiThreadedTest() throws Exception {
        TraineeManager.uploadAllEmployeesMultiThreaded(new ArrayList<>(), 10);
    }

    @Test
    @DisplayName("A test to see the non-threaded implementation of the employee uploader works")
    public void uploadAllEmployeesSingleThreadTest() throws Exception {
        TraineeManager.uploadAllEmployeesSingleThreadNonBatched(new ArrayList<>());
    }

    @Test
    @DisplayName("A test to see if uploading a singular employee works")
    public void UploadEmployeeTest() throws Exception {
        EmployeeDTO e = new EmployeeDTO(1, "", "", 'M', "", 'M', "", null, null, -1);
        TraineeManager.UploadEmployee(e);
    }
}
