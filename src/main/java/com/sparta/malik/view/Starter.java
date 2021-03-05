package com.sparta.malik.view;

import com.sparta.malik.controller.TraineeManager;
import com.sparta.malik.model.EmployeeDTO;

import java.util.ArrayList;

public class Starter {

    public static void start() {
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesMultiThreaded(employees, 12);
    }
}
