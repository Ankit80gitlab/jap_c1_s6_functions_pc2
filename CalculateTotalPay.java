package com.jap.hourlywagescalculator;

import java.util.Scanner;

public class CalculateTotalPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the employee");
        String name = sc.next();

        System.out.println("Enter base pay of the employee");
        double basePay = sc.nextDouble();

        System.out.println("Enter number of hours worked by the employee");
        int hoursWorked = sc.nextInt();

        CalculateTotalPay calculateTotalPay = new CalculateTotalPay();
        double salary = calculateTotalPay.calculateHourlyWages(basePay, hoursWorked);

        System.out.println("Name :: " + name);
        System.out.println("Base pay :: " + basePay + "$");
        System.out.println("Hours worked :: " + hoursWorked);
        System.out.println();
        System.out.println("Salary of employee :: " + salary + "$");

    }

    // Function to calculate wage of employee by analysing base pay and hours worked by employee
    public static double calculateHourlyWages(double basePay, int hoursWorked) {

		boolean minimumWage= checkBasePay(basePay);
		boolean calculateHourly= calculateOnHourlyBasis(hoursWorked);

        double salary=0.0;

		if ((minimumWage==true)&&(calculateHourly==true))
		{		
			salary=basePay*40 + 2*basePay*(hoursWorked-40);
			return salary;
		}
		else if ((minimumWage==true)&&(hoursWorked>0))
		{
            salary=basePay*hoursWorked;
			return salary;
		}
		else
		{
			return 0;                                
		}
        
	}
    // Function to estimate if an employee has worked more than 40 hrs to get overtime pay
    public static boolean calculateOnHourlyBasis(int hoursWorked) {
		boolean calculateHourly = false;

		if (hoursWorked > 40 && hoursWorked < 60)
		{
			calculateHourly=true;
		}
		else
		{
			calculateHourly=false;
		}
	     return calculateHourly;
    }

    // Function to check if base pay is more than minimum wage
    public static boolean checkBasePay(double basePay) {
        boolean basePayMoreThanMinimumWage = false;

			if (basePay>=12)
			{
				basePayMoreThanMinimumWage=true;
			}
			else
			{
                basePayMoreThanMinimumWage=false;
			}
			 return basePayMoreThanMinimumWage;
    }
}
