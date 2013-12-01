package de.manthei.drivebook;

import java.util.Date;

public class Fuel {

	private int id;
	private double measure;
	private double cost;
	private double mileage;
	private boolean summer;
	private Date date;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getMeasure() {
		return measure;
	}
	
	public void setMeasure(double measure) {
		this.measure = measure;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getMileage() {
		return mileage;
	}
	
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public boolean isSummer() {
		return summer;
	}
	
	public void setSummer(boolean summer) {
		this.summer = summer;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getMileage());
	}
	
}
