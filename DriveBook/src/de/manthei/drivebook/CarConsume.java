package de.manthei.drivebook;

public class CarConsume {

	private double distance;
	private double fuel;
	private double price;

	private double consume;
	private double cost;

	
	public CarConsume(final double distance, final double fuel, final double price) {
		this.distance = distance;
		this.fuel = fuel;
		this.price = price;
		consume = (this.fuel / this.distance) * 100;
		cost = this.price / this.distance;
	}


	public double getConsume() {
		return consume;
	}


	public double getCost() {
		return cost;
	}
	
}
