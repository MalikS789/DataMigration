package com.sparta.malik.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVEmployeeReader {

    private static ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private static ArrayList<EmployeeDTO> redundancies = new ArrayList();
    private static HashMap<Integer, EmployeeDTO> alreadyAdded = new HashMap<>();

    public static ArrayList<EmployeeDTO> getEmployees(String directory) throws IOException, ParseException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(directory));
        String line;

        bufferedReader.readLine(); //skip first line

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        int employeeID = 0;

        while ((line = bufferedReader.readLine()) != null) {

            String[] records = line.split(",");

            int empID = Integer.parseInt(records[0]); //NOT unique and therefore discardable
            String prefix = records[1];
            String firstName = records[2];
            char middleInitial = records[3].charAt(0);
            String lastName = records[4];
            char gender = records[5].charAt(0);
            String email = records[6];

            LocalDate dateofBirth = LocalDate.parse(records[7], formatter);
            LocalDate dateofJoining = LocalDate.parse(records[8], formatter);

            float salary = Float.parseFloat(records[9]);

            EmployeeDTO employeeDTO = new EmployeeDTO(employeeID, prefix, firstName, middleInitial, lastName, gender, email,
                    dateofBirth, dateofJoining, salary);
            if (!alreadyAdded.containsKey(empID)) {
                employees.add(employeeDTO);
                alreadyAdded.put(empID, employeeDTO);
                employeeID++;
            } else {
                redundancies.add(employeeDTO);
            }
        }
        System.out.println(redundancies.size());

        return employees;
    }

}
