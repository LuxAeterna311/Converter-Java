package ru.currency.converter.entity;
import org.jsoup.nodes.*;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyParser {
	
	public static Double getRUB(String url, String tag, String subtag) {
		Elements listCurrency = getListCurrency(url, tag);
		String stringRUB = parseCurrency(subtag, listCurrency);
		double doubleRUB = convertToDouble(stringRUB);
		
		return doubleRUB;
	}
	
	private static Elements getListCurrency(String url, String tag) {
		try {
			Document doc = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
			Elements listCurrency = doc.select(tag);
			
			return listCurrency;
		}
		catch (IOException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	private static String parseCurrency(String subtag, Elements listCurrency) {
		String[] arrayOfWords = {};
		
		for (Element element: listCurrency.select(subtag)) {
			if (element.text().contains("USD")) {
				arrayOfWords = element.text().split(" ");
			}
		}
		
		return arrayOfWords[arrayOfWords.length - 1];
	}
	
	private static double convertToDouble(String stringRUB) {
		NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
		double rub = 0.0;
		
		try {
			Number number = format.parse(stringRUB);
			rub = number.doubleValue();
		}
		catch(Exception exception) {
			System.out.println(exception.getStackTrace());
		}
		
		return rub;
	}
}
