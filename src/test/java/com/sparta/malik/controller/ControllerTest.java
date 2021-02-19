package com.sparta.malik.controller;

import com.sparta.malik.model.EmployeeDTO;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class ControllerTest {

    @Test
    @DisplayName("A test to see if all employees can be read from the CSV file")
    public void getEmployeesTest() throws Exception {
        Controller.getEmployees();
    }

    @Test
    @DisplayName("A test to see the multithreaded implementation of the employee uploader works")
    public void uploadAllEmployeesMultiThreadedTest() throws Exception {
        Controller.uploadAllEmployeesMultiThreaded(new ArrayList<>(), 10);
    }

    @Test
    @DisplayName("A test to see the non-threaded implementation of the employee uploader works")
    public void uploadAllEmployeesSingleThreadTest() throws Exception {
        Controller.uploadAllEmployeesSingleThreadNonBatched(new ArrayList<>());
    }

    @Test
    @DisplayName("A test to see if uploading a singular employee works")
    public void UploadEmployeeTest() throws Exception {
        EmployeeDTO e = new EmployeeDTO(1, "", "", 'M', "", 'M', "", null, null, -1);
        Controller.UploadEmployee(e);
    }
}
