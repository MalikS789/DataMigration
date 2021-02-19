package com.sparta.malik.controller.thread;

import com.sparta.malik.controller.Controller;
import com.sparta.malik.model.EmployeeDTO;

import java.util.ArrayList;

public class UploadThreadNonBatched implements Runnable {
    private ArrayList<EmployeeDTO> employeeDTOS;
    public boolean done = false;

    public UploadThreadNonBatched(ArrayList<EmployeeDTO> employeeDTOS) {
        this.employeeDTOS = employeeDTOS;
    }

    @Override
    public void run() {
        for (EmployeeDTO e : employeeDTOS) {
            Controller.UploadEmployee(e);
        }
        done = true;
    }
}
