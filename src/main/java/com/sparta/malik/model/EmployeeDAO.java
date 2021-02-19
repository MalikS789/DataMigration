package com.sparta.malik.model;

import com.sparta.malik.view.Printer;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class EmployeeDAO {

    private String URL = "jdbc:mysql://127.0.0.1:3306/mylocal?serverTimezone=GMT";
    private Connection connection = null;
    private Properties properties = new Properties();

    private final String insertEmployeeUsingParameters = "INSERT INTO Employee (" +
            "prefix, firstname, middleinital, lastname, gender, email, dateOfBirth, dateOfJoining, salary" +
            ") VALUE (?,?,?,?,?,?,?,?,?)";

    public static HashMap<Integer, EmployeeDTO> alreadyAdded = new HashMap<>();

    private Connection connectToDatabase() {
        try {
            properties.load(new FileReader("src/main/resources/login.properties"));
            connection = DriverManager.getConnection(URL, properties.getProperty("username"), properties.getProperty("password"));
        } catch (IOException | SQLException e) {
            Printer.printErrorMessage(e);
        }
        return connection;
    }

    public EmployeeDTO getEmployee(int empId) {
        return alreadyAdded.getOrDefault(empId, null);
    }

    public void addEmployee(EmployeeDTO e) {
        if (getEmployee(e.getEmpID()) == null) {
            try {
                PreparedStatement preparedStatement = connectToDatabase().prepareStatement(insertEmployeeUsingParameters);
                preparedStatement.setString(1, e.getPrefix());
                preparedStatement.setString(2, e.getFirstName());
                preparedStatement.setString(3, String.valueOf(e.getMiddleInitial()));
                preparedStatement.setString(4, e.getLastName());
                preparedStatement.setString(5, String.valueOf(e.getGender()));
                preparedStatement.setString(6, e.getEmail());
                preparedStatement.setDate(7, Date.valueOf(e.getDateofBirth()));
                preparedStatement.setDate(8, Date.valueOf(e.getDateofJoining()));
                preparedStatement.setFloat(9, e.getSalary());

                if (preparedStatement.executeUpdate() == 0) {
                    //as employee doesn't exist, add it
                    Printer.printErrorMessage(new Exception("Unable to add employee to the database"));
                } else {
//                    Printer.printMessage("" + e.getEmpID());
                    alreadyAdded.put(e.getEmpID(), e);
                }
            } catch (SQLException throwables) {
                Printer.printErrorMessage(throwables);
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    Printer.printErrorMessage(throwables);
                }
            }
        }
    }

    public void addEmployeesBatch(ArrayList<EmployeeDTO> employees) {
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(insertEmployeeUsingParameters);
            connection.setAutoCommit(false);
            for (EmployeeDTO e : employees) {
                    preparedStatement.setString(1, e.getPrefix());
                    preparedStatement.setString(2, e.getFirstName());
                    preparedStatement.setString(3, String.valueOf(e.getMiddleInitial()));
                    preparedStatement.setString(4, e.getLastName());
                    preparedStatement.setString(5, String.valueOf(e.getGender()));
                    preparedStatement.setString(6, e.getEmail());
                    preparedStatement.setDate(7, Date.valueOf(e.getDateofBirth()));
                    preparedStatement.setDate(8, Date.valueOf(e.getDateofJoining()));
                    preparedStatement.setFloat(9, e.getSalary());
                    preparedStatement.addBatch();
                    preparedStatement.clearParameters();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            Printer.printErrorMessage(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void updateEmployee(EmployeeDTO e, String columnName, Object newValue) {
        PreparedStatement preparedStatement = null;
        try {
            String updateEmployeesUsingParameters = "UPDATE Employee SET ?=? WHERE empId=? AND ?!=?";
            preparedStatement = connectToDatabase().prepareStatement(updateEmployeesUsingParameters);
            preparedStatement.setString(1, columnName);
            preparedStatement.setObject(2, newValue);
            preparedStatement.setInt(3, e.getEmpID());
            preparedStatement.setString(4, columnName);
            preparedStatement.setObject(5, newValue);
            if (preparedStatement.executeUpdate() == 0) {
                //as employee doesn't exist, add it
                addEmployee(e);
            }
        } catch (SQLException throwables) {
            Printer.printErrorMessage(throwables);
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                Printer.printErrorMessage(throwables);
            }
        }
    }

    public void removeEmployee(String columnName, Object Value) {
        PreparedStatement preparedStatement = null;
        try {
            String deleteEmployeeUsingParameters = "DELETE FROM Employee WHERE ?=?";
            preparedStatement = connectToDatabase().prepareStatement(deleteEmployeeUsingParameters);
            preparedStatement.setString(1, columnName);
            preparedStatement.setObject(2, Value);
            if (preparedStatement.executeUpdate() == 0) {
                Printer.printErrorMessage(new Exception("Unable to delete employee from the database"));
            }
        } catch (SQLException throwables) {
            Printer.printErrorMessage(throwables);
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                Printer.printErrorMessage(throwables);
            }
        }
    }

    public void removeAllEmployees() {
        PreparedStatement preparedStatement = null;
        try {
            String removeAllEmployeesFromTable = "DELETE FROM Employee";
            preparedStatement = connectToDatabase().prepareStatement(removeAllEmployeesFromTable);
            if (preparedStatement.executeUpdate() == 0) {
                Printer.printErrorMessage(new Exception("Unable to delete all employee records"));
            }
        } catch (SQLException throwables) {
            Printer.printErrorMessage(throwables);
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                Printer.printErrorMessage(throwables);
            }
        }
    }
}
