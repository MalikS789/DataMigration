package com.sparta.malik.controller;

import com.sparta.malik.model.EmployeeDTO;

import java.util.ArrayList;

public class UploadThread implements Runnable {

    private ArrayList<EmployeeDTO> employeeDTOS;

    public UploadThread(ArrayList<EmployeeDTO> employeeDTOS) {
        this.employeeDTOS = employeeDTOS;
    }

    @Override
    public void run() {
        Controller.batchUpload(employeeDTOS);
    }

}
