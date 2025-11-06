package com.simple.hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourlyEmployee extends Employee implements Payable{
	
	@SuppressWarnings("unused")
	private int hoursWorked;

	public HourlyEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public HourlyEmployee(String name, int hours) {
		super(name);
		this.hoursWorked = hours;
	}

	@Override
	public double calculatePay() {
		return (this.hoursWorked * getPayRate()) - (this.hoursWorked * 0.3);
	}

	@Override
	public String generatePayStub() {
		Address addr = new Address("111 Windmill Ridge Dr", "Rockwall", "Texas", "75032", "USA");
		Company cmp = new Company("Nelson Media", addr);
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String str = format.format(date);
		System.out.println("name: " + getName());
		System.out.println("id: " + getEmployeeID());
		System.out.println("hours: " + hoursWorked);
		System.out.println("rate: " + getPayRate());
		System.out.println("net: " + calculatePay());
		System.out.println("company: " + cmp.getName());

		String outStr = "\t\t" + cmp.getName()
						+ "\n\t" + "Name: " + getName() + "   - Employee ID: " + getEmployeeID()
						+ "\n\t" + "Pay Date: " + str
						+ "\n\t" + "Hours Worked: " + this.hoursWorked
						+ "\n\t" + "Pay Rate: " + getPayRate()
						+ "\n\t" + "Net Check:   " + calculatePay() + "\n\n";
		return outStr;
	}
		
		public static void printPayStub(String filePath, List<HourlyEmployee> hemployees) {
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
				for(HourlyEmployee employee : hemployees) {
					writer.write(employee.generatePayStub());
				} 
			} catch (IOException e) {
				System.out.println("There was an error printing the pay stubs!");
				e.printStackTrace();
			}

	}

}
