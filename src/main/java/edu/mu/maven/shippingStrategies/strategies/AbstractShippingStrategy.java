package edu.mu.maven.shippingStrategies.strategies;

import java.time.OffsetDateTime;

public abstract class AbstractShippingStrategy {
	public abstract String calculateArrival();
	
	protected final OffsetDateTime calculateNDaysAhead(long days) {
		OffsetDateTime today = OffsetDateTime.now();
		return today.plusDays(days);
	}
	
	protected final String dateAsString(OffsetDateTime date) {
		String dateString = String.format("%s, %s %s, %s", 
										  date.getDayOfWeek(),
										  date.getMonth(),
										  date.getDayOfMonth(),
										  date.getYear()
										  );
		
		return dateString;
	}
}
