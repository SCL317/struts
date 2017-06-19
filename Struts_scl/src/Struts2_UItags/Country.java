package Struts2_UItags;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Country {
	
	private int countryId;
	private String countryName;
	
	public Country(int countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

	
}
