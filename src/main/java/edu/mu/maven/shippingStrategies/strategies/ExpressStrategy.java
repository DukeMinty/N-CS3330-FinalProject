package edu.mu.maven.shippingStrategies.strategies;

import java.time.OffsetDateTime;

public class ExpressStrategy extends AbstractShippingStrategy{
	
	public ExpressStrategy() {}
	@Override
	public String calculateArrival() {
		OffsetDateTime tomorrow = calculateNDaysAhead(1);
		return dateAsString(tomorrow);
	}

}
