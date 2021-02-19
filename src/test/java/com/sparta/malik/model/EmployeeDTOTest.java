package com.sparta.malik.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

public class EmployeeDTOTest {

    @Test
    public void setSalaryTest() throws Exception {
        EmployeeDTO e = new EmployeeDTO(1, "", "", 'M', "", 'M', "", null, null, -1);
        if (e.getSalary() < 0) {
            Assertions.fail("Salary should not be less then 0!");
        }
    }


    @Test
    public void equalsTest() throws Exception {
        EmployeeDTO e = new EmployeeDTO(1, "", "", 'M', "", 'M', "", null, null, -1);
        EmployeeDTO e2 = new EmployeeDTO(1, "", "", 'M', "", 'M', "", null, null, -1);
        if (!e.equals(e2)) {
            Assertions.fail("They should report as equal, as they have identical attributes");
        }
    }


    @Test
    public void toStringTest() throws Exception {
        EmployeeDTO e = new EmployeeDTO(1, "A", "B", 'C', "D", 'E', "F", null, null, -1);
        if (!e.toString().equals("empID=1, prefix='A', firstName='B', middleInitial='C', lastName='D', gender='E', email='F', dateofBirth='null', dateofJoining='null', salary=0.0")) {
            Assertions.fail("Not expected string");
        }
    }
}
