package ru.currency.converter.entity;

import javax.validation.constraints.Min;


public class Converter {
	
	private String leftCurrency;
	private String rightCurrency;
	
	@Min(value = 0, message = "Value should be greater 0")
	private Double value;
	
	
	public Converter(String leftCurrency, String rightCurrency, Double value) {
		this.leftCurrency = leftCurrency;
		this.rightCurrency = rightCurrency;
		this.value = value;
	}
	
	public Double getValue() {
		return this.value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public double convert(String url, String tag, String subtag) {
		if (leftCurrency.equals("RUB")) {
			return this.value / CurrencyParser.getRUB(url, tag, subtag);
		}
		else {
			return this.value * CurrencyParser.getRUB(url, tag, subtag); 
		}
	}
}
