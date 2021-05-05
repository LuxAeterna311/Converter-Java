package ru.currency.converter.entity;

import javax.validation.constraints.Min;
import ru.currency.converter.entity.CurrencyParser;


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
	
	public double convert(CurrencyParser parser) {
		if (leftCurrency.equals("RUB")) {
			return this.value / parser.getRub();
		}
		else {
			return this.value * parser.getRub(); 
		}
	}
}
