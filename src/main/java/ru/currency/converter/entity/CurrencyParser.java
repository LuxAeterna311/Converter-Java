package ru.currency.converter.entity;
import org.jsoup.nodes.*;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyParser {
	
	private double rub;
	private Elements listCurrency;
	
	public CurrencyParser(String url, String tag, String subtag) {
		try {
		Document doc = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
		this.listCurrency = doc.select(tag);
		}
		catch (IOException exception) {
			exception.printStackTrace();		
		}
		
		parseCurrencyString(subtag);
	}
	
	private void parseCurrencyString(String subtag) {
		String[] arrayOfWords = {};
		for (Element element: this.listCurrency.select(subtag)) {
			if (element.text().contains("USD")) {
				arrayOfWords = element.text().split(" ");
			}
		}
		
		NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
		try {
			Number number = format.parse(arrayOfWords[arrayOfWords.length - 1]);
			this.rub = number.doubleValue();
		}
		catch(Exception exception) {
			System.out.println(exception.getStackTrace());
		}
	}
	
	public double getRub() {
		return this.rub;
	}
}
