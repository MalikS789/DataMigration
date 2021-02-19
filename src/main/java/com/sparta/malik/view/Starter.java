package com.sparta.malik.view;

import com.sparta.malik.controller.Controller;
import com.sparta.malik.model.EmployeeDTO;

import java.util.ArrayList;

public class Starter {

    public static void start() {
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 12);
    }
}
