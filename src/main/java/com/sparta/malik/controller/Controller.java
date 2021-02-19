package com.sparta.malik.controller;

import com.sparta.malik.controller.thread.UploadThread;
import com.sparta.malik.controller.thread.UploadThreadNonBatched;
import com.sparta.malik.model.CSVEmployeeReader;
import com.sparta.malik.model.EmployeeDAO;
import com.sparta.malik.model.EmployeeDTO;
import com.sparta.malik.view.Printer;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Controller {

    private static EmployeeDAO dao = new EmployeeDAO();

    public static ArrayList<EmployeeDTO> getEmployees() {
        try {
            return CSVEmployeeReader.getEmployees("src/main/resources/employees.csv");
        } catch (IOException | ParseException e) {
            Printer.printErrorMessage(e);
        }
        return null;
    }

    public static void uploadAllEmployeesMultiThreaded(ArrayList<EmployeeDTO> employees, int numberOfThreads) {
        if (employees == null || employees.size() < 1) {
            return;
        }
        UploadThread[] threads = new UploadThread[numberOfThreads];
        int amountPerArray = (int) Math.ceil(employees.size() / (double) numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            int lowerbound = (amountPerArray * i);
            int upperbound = amountPerArray * (i + 1);

            if (lowerbound > employees.size()) {
                break;
            }
            if (upperbound >= employees.size()) {
                upperbound = employees.size() - 1;
            }
            threads[i] = new UploadThread(new ArrayList<EmployeeDTO>(employees.subList(lowerbound, upperbound)));
            threads[i].run();
        }
        for (UploadThread t : threads) {
            if (t == null) {
                break;
            }
            while (!t.done) {
                //this will ensure all threads are done
            }
        }
    }

    public static void uploadAllEmployeesMultiThreadedNonBatched(ArrayList<EmployeeDTO> employees, int numberOfThreads) {
        if (employees == null || employees.size() < 1) {
            return;
        }
        UploadThreadNonBatched[] threads = new UploadThreadNonBatched[numberOfThreads];
        int amountPerArray = (int) Math.ceil(employees.size() / (double) numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {

            int lowerbound = (amountPerArray * i);
            int upperbound = amountPerArray * (i + 1);

            if (lowerbound > employees.size()) {
                break;
            }
            if (upperbound >= employees.size()) {
                upperbound = employees.size() - 1;
            }
            threads[i] = new UploadThreadNonBatched(new ArrayList<EmployeeDTO>(employees.subList(lowerbound, upperbound)));
            threads[i].run();
        }
        for (UploadThreadNonBatched t : threads) {
            while (!t.done) {
                //this will ensure all threads are done
            }
        }
    }

    public static void batchUpload(ArrayList<EmployeeDTO> e) {
        dao.addEmployeesBatch(e);
    }

    public static void uploadAllEmployeesSingleThreadNonBatched(ArrayList<EmployeeDTO> employees) {
        for (EmployeeDTO e : employees) {
            UploadEmployee(e);
        }
    }

    public static void uploadAllEmployeesSingleThreadBatched(ArrayList<EmployeeDTO> employees) {
        batchUpload(employees);
    }

    public static void UploadEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            Printer.printErrorMessage(new Exception("Employee can't be null!"));
        } else {
            if (employeeDTO.getDateofBirth() != null && employeeDTO.getDateofJoining() != null) {
                dao.addEmployee(employeeDTO);
            }
        }
    }

    public static void removeAllEmployees() {
        dao.removeAllEmployees();
    }

}
