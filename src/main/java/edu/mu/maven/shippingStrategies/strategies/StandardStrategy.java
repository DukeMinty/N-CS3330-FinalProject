package edu.mu.maven.shippingStrategies.strategies;

import java.time.OffsetDateTime;
import java.util.Random;

public class StandardStrategy extends AbstractShippingStrategy{
	private Random random;
	
	public StandardStrategy() {
		random = new Random();
	}
	
	@Override
	public String calculateArrival() {
		// Calculates a random day 1-2 weeks ahead of today
		OffsetDateTime randomDay = calculateNDaysAhead(7 + random.nextInt(8));
		return dateAsString(randomDay);
	}

}