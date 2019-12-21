package com.demo.resource;

public class Country {
	
	private Integer id;
	private String name;
	private String iso2Code;
	private String region;
	private String adminregion;
	private String incomeLevel;
	private String lendingType;
	//private String countryCode;
	private String capitalCity;
	
	/*
	 * <wb:longitude>-47.9292</wb:longitude> 
	 * <wb:latitude>-15.7801</wb:latitude>
	 */
 
	public Country() {
	}
	
	public Country(Integer id, String name, String iso2Code, String region, String adminregion, String incomeLevel,
			String lendingType, String capitalCity) {
		super();
		this.id = id;
		this.name = name;
		this.iso2Code = iso2Code;
		this.region = region;
		this.adminregion = adminregion;
		this.incomeLevel = incomeLevel;
		this.lendingType = lendingType;
		this.capitalCity = capitalCity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIso2Code() {
		return iso2Code;
	}

	public void setIso2Code(String iso2Code) {
		this.iso2Code = iso2Code;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAdminregion() {
		return adminregion;
	}

	public void setAdminregion(String adminregion) {
		this.adminregion = adminregion;
	}

	public String getIncomeLevel() {
		return incomeLevel;
	}

	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	public String getLendingType() {
		return lendingType;
	}

	public void setLendingType(String lendingType) {
		this.lendingType = lendingType;
	}

	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}


}

