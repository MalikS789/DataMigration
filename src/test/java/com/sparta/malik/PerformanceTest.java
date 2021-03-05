package com.sparta.malik;

import com.sparta.malik.controller.TraineeManager;
import com.sparta.malik.model.EmployeeDTO;
import com.sparta.malik.util.Printer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PerformanceTest {

    @Test
    public void uploadAllEmployeesMultiThreadedTest() {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesMultiThreaded(employees, 12);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 12 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreadedNonBatched() {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesMultiThreadedNonBatched(employees, 12);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Non Batched (" + 12 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesSingleThreadBatchedTest() {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesSingleThreadBatched(employees);
        Long end = System.nanoTime();
        Printer.printMessage("Singular thread Employee Upload Batched : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesSingleThreadNonBatchedTest() {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesSingleThreadNonBatched(employees);
        Long end = System.nanoTime();
        Printer.printMessage("Singular thread Employee Upload Non Batched : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreaded100Test() {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesMultiThreaded(employees, 100);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 100 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreaded500Test() {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesMultiThreaded(employees, 500);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 50 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreaded1000Test() {
        TraineeManager.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = TraineeManager.getEmployees();
        TraineeManager.uploadAllEmployeesMultiThreaded(employees, 1000);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 1000 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }


}
