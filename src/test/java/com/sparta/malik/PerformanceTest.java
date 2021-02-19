package com.sparta.malik;

import com.sparta.malik.controller.Controller;
import com.sparta.malik.model.EmployeeDTO;
import com.sparta.malik.view.Printer;
import org.junit.Test;

import java.util.ArrayList;

public class PerformanceTest {

    @Test
    public void uploadAllEmployeesMultiThreadedTest() {
        Controller.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 12);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 12 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreadedNonBatched() {
        Controller.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreadedNonBatched(employees, 12);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Non Batched (" + 12 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesSingleThreadBatchedTest() {
        Controller.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesSingleThreadBatched(employees);
        Long end = System.nanoTime();
        Printer.printMessage("Singular thread Employee Upload Batched : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesSingleThreadNonBatchedTest() {
        Controller.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesSingleThreadNonBatched(employees);
        Long end = System.nanoTime();
        Printer.printMessage("Singular thread Employee Upload Non Batched : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreaded100Test() {
        Controller.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 100);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 100 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreaded500Test() {
        Controller.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 500);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 50 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }

    @Test
    public void uploadAllEmployeesMultiThreaded1000Test() {
        Controller.removeAllEmployees();
        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 1000);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 1000 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }


}
