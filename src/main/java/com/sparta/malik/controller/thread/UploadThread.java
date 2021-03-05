package com.sparta.malik.controller.thread;

import com.sparta.malik.controller.TraineeManager;
import com.sparta.malik.model.EmployeeDTO;

import java.util.ArrayList;

public class UploadThread implements Runnable {

    private ArrayList<EmployeeDTO> employeeDTOS;
    public boolean done = false;

    public UploadThread(ArrayList<EmployeeDTO> employeeDTOS) {
        this.employeeDTOS = employeeDTOS;
    }

    @Override
    public void run() {
        TraineeManager.batchUpload(employeeDTOS);
        done = true;
    }

}
