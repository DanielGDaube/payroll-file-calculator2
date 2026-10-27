package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args)  {
        Scanner payrollScanner = new Scanner(System.in);

        try {

            System.out.println("Enter the name of the file to process:");
            String readFile = payrollScanner.nextLine();
            System.out.println("Enter the name of the payroll file to create:");
            String writeFile = payrollScanner.nextLine();

            BufferedReader employeeReader = new BufferedReader(new FileReader(readFile));
            BufferedWriter employeeWriter = new BufferedWriter(new FileWriter(writeFile));
            employeeReader.readLine();

            String line;
            String payrollText;

            while ((line = employeeReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hours = Double.parseDouble(tokens[2]);
                double pay = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hours, pay);

                payrollText = String.format("%s| %s:| $%.2f %n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                employeeWriter.write(payrollText);

            }
            employeeWriter.close();

        }
        catch (Exception e){
            System.out.println("Something went wrong");

        }
    }
}
