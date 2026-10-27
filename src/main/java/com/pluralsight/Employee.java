package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public int getEmployeeId() {
        return employeeId;
    }


    public String getName() {
        return name;
    }


    public double getHoursWorked() {
        return hoursWorked;
    }

    public Employee setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
        return this;
    }

    public double getPayRate() {
        return payRate;
    }

    public Employee setPayRate(double payRate) {
        this.payRate = payRate;
        return this;
    }

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Calculates the gross pay using hoursWorked and payRate, accounts for overtime
    public double getGrossPay(){
        double overTime = hoursWorked - 40;
        return (hoursWorked > 40)? (overTime * (payRate + (payRate * 1.5))) + ((hoursWorked - overTime) * payRate) : hoursWorked * payRate;
    }
}
