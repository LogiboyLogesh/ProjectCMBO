package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankModel {
	
	@JsonProperty("UserType")
	private String UserType;

	@JsonProperty("ScenarioType")
	private String ScenarioType;

	@JsonProperty("BankCode")
	private String BankCode;
	
	@JsonProperty("BankName")
	private String BankName;
	
	@JsonProperty("BankShortName")
	private String BankShortName;

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public String getScenarioType() {
		return ScenarioType;
	}

	public void setScenarioType(String scenarioType) {
		ScenarioType = scenarioType;
	}

	public String getBankCode() {
		return BankCode;
	}

	public void setBankCode(String bankCode) {
		BankCode = bankCode;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public String getBankShortName() {
		return BankShortName;
	}

	public void setBankShortName(String bankShortName) {
		BankShortName = bankShortName;
	}
	
	

}
