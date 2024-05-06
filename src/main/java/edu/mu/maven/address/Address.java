package edu.mu.maven.address;

public class Address {
	private String street;
	private String city;
	private String region;
	private String zipcode;
	private String country;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		String addressAsString;
		addressAsString = String.format("%s\n%s, %s %s, %s", 
										street, city, region, zipcode, country);
		
		return addressAsString;
	}
}
