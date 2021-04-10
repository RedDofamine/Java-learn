package localization.logic;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//System.out.println("this my vois one week in russia");
		
		//Locale defLocale = Locale.getDefault();
		//Locale[] locales = Locale.getAvailableLocales();
		//Locale japanese = new Locale("ja", "JP");
		//Locale german = new Locale("de", "DE");
		//System.out.println(NumberFormat.getCurrencyInstance(japanese).format(new Date()));
		//Locale ukraine = new Locale("uk", "UA");
		//Locale arabic = new Locale("ar", "LB");
		//System.out.println(DateFormat.getDateInstance(DateFormat.FULL, german).format(new Date()));
		//System.out.println(DateFormat.getDateInstance(DateFormat.FULL, arabic).format(new Date()));
		//double amt = 123456.78;
		//System.out.println(NumberFormat.getCurrencyInstance(new Locale("ja", "JP")).format(new Date()));
		//Locale ua = new Locale("uk", "UA");
		//System.out.println(defLocale);
		//System.out.println(NumberFormat.getCurrencyInstance(ua).format(1000));
		/*for (Locale loc : locales) {
			System.out.println(loc);
		}*/
		//ResourceBundle bundleDef = ResourceBundle.getBundle("localization");
		//System.out.println(bundleDef.getString("hello"));
		//ResourceBundle bundleUA = ResourceBundle.getBundle("localization", new Locale("uk", "UA"));
		//System.out.println(bundleUA.getString("hello"));
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("To display fields, dates, or currencies, enter: fields; date; money\nTo change the language, write one of: ua; en; de");
				i18n(sc.nextLine());
		}
	}
	
	
	private static String[] field = {"play", "language", "saveFieldName", "saveDate", "saveTime", "health", "stomach", "rank", "money"};
	final static String PATH = "localization/cfg/resource_bundle";
	static ResourceBundle rb = ResourceBundle.getBundle(PATH);
	
	
	private static void i18n(String lang) {
		
		switch(lang) {
		case "ua":
			setLANG("uk", "UA");
			rb = ResourceBundle.getBundle(PATH);
			setElements(rb);
			break;
		case "de":
			setLANG("de", "DE");
			rb = ResourceBundle.getBundle(PATH);
			setElements(rb);
			break;
		case "en":
			setLANG("en", "UK");
			rb = ResourceBundle.getBundle(PATH);
			setElements(rb);
			break;
		case "date":
			System.out.println(getDATE());
			break;
		case "money":
			System.out.println(getCURRENCY(1000));
			break;
		case "fields":
			showFields();
			break;
		default: 
			System.out.println("Incorrect input");
			break;
		}
		
	/*	
		
		setElements(rb);
		showFields();
		//getDATE();
		//getCURRENCY(1000);
		
		
		
		
		
		//getDATE();
		//getCURRENCY(1000);
		
		
		setLANG("en", "UK");
		rb = ResourceBundle.getBundle(PATH);
		setElements(rb);
		showFields();
		//getDATE();
		//getCURRENCY(1000);
		*/
	}
	public static void showFields() {
		for(String f: field) {
			System.out.println(f);
		}
		System.out.println("");
	}
	public static void setLANG(String language, String country) {
		Locale.setDefault(new Locale(language, country));
	}
	public static void setElements(ResourceBundle rb) {
		//System.out.println(rb.getString("language") + ":" + rb.getString("greeting"));
		field[0] = rb.getString("play");
		field[1] = rb.getString("language");
		field[2] = rb.getString("saveFieldName");
		field[3] = rb.getString("saveDate");
		field[4] = rb.getString("saveTime");
		
		field[5] = rb.getString("health");
		field[6] = rb.getString("stomach");
		field[7] = rb.getString("rank");
		field[8] = rb.getString("money");
		
	}
	public static String getDATE() {
		return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.DEFAULT, Locale.getDefault()).format(new Date());
	}
	public static String getCURRENCY(int money) {
		return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(money);
	}
	
	
}
