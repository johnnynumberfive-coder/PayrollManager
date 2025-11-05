package com.simple.hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalariedEmployee extends Employee implements Payable {

	private double salary;
	
	public SalariedEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public SalariedEmployee(String name, double sal) {
		super(name);
		this.salary = sal;
	}

	@Override
	public double calculatePay() {
		return this.salary - (this.salary * 0.3);
	}

	@Override
	public String generatePayStub() {
		Address addr = new Address("111 Windmill Ridge Dr", "Rockwall", "Texas", "75032", "USA");
		Company cmp = new Company("Nelson Media", addr);
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String str = format.format(date);
		
		String outStr = "\t\t" + cmp.getName()
						+ "\n\t" + "Name: " + getName() + "   - Employee ID: " + getEmployeeID()
						+ "\n\t" + "Pay Date: " + str
						+ "\n\t" + "Gross Salary: " + salary
						+ "\n\t" + "Net Salary:   " + calculatePay() + "\n\n";
		return outStr;
	}
	public static void printPayStub(String filePath, List<SalariedEmployee> employees) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			for(SalariedEmployee employee : employees) {
				writer.write(employee.generatePayStub());
			} 
		} catch (IOException e) {
			System.out.println("There was an error printing the pay stubs!");
			e.printStackTrace();
		}
	}
}
