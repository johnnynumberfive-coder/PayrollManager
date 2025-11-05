package com.simple.hr;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		SalariedEmployee e1 = new SalariedEmployee("John Nelson", 2500.00);
		SalariedEmployee e2 = new SalariedEmployee("Joe Smith", 1000.00);
		Contractor c1 = new Contractor (10, 1, 0.99, 100.00);
		Contractor c2 = new Contractor (25, 0, 0, 80.00);
		
//		System.out.println(e1.calculatePay());
//		System.out.println(e2.calculatePay());
//		
//		System.out.println(c1.calculatePay());
//		System.out.println(c2.calculatePay());
		String filePath = "paystubs.txt";
		
		List<SalariedEmployee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		
		SalariedEmployee.printPayStub(filePath, employees);
	}
	

}
