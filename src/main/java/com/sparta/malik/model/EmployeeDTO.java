package com.sparta.malik.model;

import com.sparta.malik.util.Printer;

import java.time.LocalDate;

public class EmployeeDTO {

    private int id;
    private String prefix;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private char gender;
    private String email;
    private LocalDate dateofBirth;
    private LocalDate dateofJoining;
    private float salary = 0f;

    public EmployeeDTO(int id, String prefix,
                       String firstName, char middleInitial,
                       String lastName, char gender, String email,
                       LocalDate dateofBirth, LocalDate dateofJoining, float salary
    ) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateofBirth = dateofBirth;
        this.dateofJoining = dateofJoining;
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int empID) {
        this.id = empID;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public LocalDate getDateofJoining() {
        return dateofJoining;
    }

    public void setDateofJoining(LocalDate dateofJoining) {
        this.dateofJoining = dateofJoining;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if (salary < 0) {
            Printer.printErrorMessage(new Exception("Cannot give an employee less then no money!"));
        }
        this.salary = 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof EmployeeDTO) {
            EmployeeDTO temp = (EmployeeDTO) obj;
            return temp.prefix.equals(this.prefix)
                    && temp.firstName.equals(this.firstName)
                    && temp.middleInitial == this.middleInitial
                    && temp.lastName.equals(this.lastName)
                    && temp.gender == this.gender
                    && temp.email.equals(this.email)
                    && temp.dateofBirth == this.dateofBirth
                    && temp.dateofJoining == this.dateofJoining
                    && temp.salary == this.salary;
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateofBirth='" + dateofBirth + '\'' +
                ", dateofJoining='" + dateofJoining + '\'' +
                ", salary=" + salary;
    }
}
