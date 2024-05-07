package edu.mu.maven.shippingStrategies;

import edu.mu.maven.shippingStrategies.strategies.AbstractShippingStrategy;

public class ShippingContext {
	private AbstractShippingStrategy strategy;
	
	public ShippingContext() {}
	
	public void setStrategy(AbstractShippingStrategy strat) {
		strategy = strat;
	}
	
	public String getArrivalDate() {
		return strategy.calculateArrival();
	}
}
