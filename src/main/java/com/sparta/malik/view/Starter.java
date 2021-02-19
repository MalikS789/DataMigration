package com.sparta.malik.view;

import com.sparta.malik.controller.Controller;
import com.sparta.malik.model.EmployeeDTO;

import java.util.ArrayList;

public class Starter {

    public static void start() {

        int cores = Runtime.getRuntime().availableProcessors();

        Controller.removeAllEmployees();

        Long start = System.nanoTime();
        ArrayList<EmployeeDTO> employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, cores);
        Long end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + cores + " threads) : " + (end - start) / 1000000 + " milliseconds");

        Controller.removeAllEmployees();

        start = System.nanoTime();
        employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreadedNonBatched(employees, cores);
        end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Non Batched (" + cores + " threads) : " + (end - start) / 1000000 + " milliseconds");

        Controller.removeAllEmployees();

        start = System.nanoTime();
        employees = Controller.getEmployees();
        Controller.uploadAllEmployeesSingleThreadBatched(employees);
        end = System.nanoTime();
        Printer.printMessage("Singular thread Employee Upload Batched : " + (end - start) / 1000000 + " milliseconds");

        Controller.removeAllEmployees();

        start = System.nanoTime();
        employees = Controller.getEmployees();
        Controller.uploadAllEmployeesSingleThreadNonBatched(employees);
        end = System.nanoTime();
        Printer.printMessage("Singular thread Employee Upload Non Batched : " + (end - start) / 1000000 + " milliseconds");

        Controller.removeAllEmployees();

        start = System.nanoTime();
        employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 100);
        end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 100 + " threads) : " + (end - start) / 1000000 + " milliseconds");

        Controller.removeAllEmployees();

        start = System.nanoTime();
        employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 500);
        end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 500 + " threads) : " + (end - start) / 1000000 + " milliseconds");

        Controller.removeAllEmployees();

        start = System.nanoTime();
        employees = Controller.getEmployees();
        Controller.uploadAllEmployeesMultiThreaded(employees, 1000);
        end = System.nanoTime();
        Printer.printMessage("Multithreaded Employee Upload Batched (" + 1000 + " threads) : " + (end - start) / 1000000 + " milliseconds");
    }
}
