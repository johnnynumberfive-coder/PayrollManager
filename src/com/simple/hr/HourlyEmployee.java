package com.simple.hr;

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
		// TODO Auto-generated method stub
		return null;
	}

}
