package com.simple.hr;

public class Contractor implements Payable{
	private int hoursWorked;
	private int partsQuantity;
	private double partsCost;
	private double hourlyRate;
	
	public Contractor(int hw, int pq, double pc, double hr) {
		this.hoursWorked = hw;
		this.partsQuantity = pq;
		this.partsCost = pc;
		this.hourlyRate = hr;
	}
	
	@Override
	public double calculatePay() {
		return (this.hoursWorked * this.hourlyRate) + (this.partsCost * this.partsQuantity);
	}

	@Override
	public String generatePayStub() { // invoice
		// TODO Auto-generated method stub
		return null;
	}

}
