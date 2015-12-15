package com.pentasys.moneypattern;

import java.util.function.DoubleToLongFunction;

public class Money {

	private Integer amount;
	private String currency;
	
	private boolean samecurrency(Money compareObject){
		return compareObject.getCurrency().equalsIgnoreCase(currency);		
	}
	
	private static int doubleAmountToInt(double f){		
		String s = Double.toString(f);
		String[] ss = s.split("\\.");
		s = ss[0] + ss[1];
		return Integer.valueOf(s);		
	}

	public Money(int amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	
	public Money(int amount) {
		this(amount,"EUR");
	}
	
	public Money(double f){
		super();
		this.amount=doubleAmountToInt(f);
		this.currency = "EUR";		
	}
	
	public Integer getAmount() {
		return this.amount;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	public boolean equals(Money compareObject){
		if((compareObject.getAmount() == this.amount) && samecurrency(compareObject))
			return true;
		else
			return false;
	}
	
	public String printAmount(){
		String s;
		s=this.amount.toString();
		if(s.length() == 1)
			s = "0.0"+s;
		else if(s.length() == 2)
			s= "0."+s;
		else if(s.length() >= 3)
			s = s.substring(0, s.length()-2) +"."+ s.substring(s.length()-2);
		return s;
	}	
	
	public int add(Money m) throws differentCurrencyException{	
		if(this.samecurrency(m))
			return this.amount + m.amount;
		else
			throw new differentCurrencyException("Currency is different");
	}
	
	public int sub(Money m) throws differentCurrencyException{	
		if(this.samecurrency(m))
			return this.amount - m.amount;
		else
			throw new differentCurrencyException("Currency is different");
	}

	public int mul(Money m) throws differentCurrencyException{	
		if(this.samecurrency(m))
			return this.amount * m.amount;
		else
			throw new differentCurrencyException("Currency is different");
	}
	
	public int div(Money m) throws differentCurrencyException{	
		if(this.samecurrency(m))
			return this.amount / m.amount;
		else
			throw new differentCurrencyException("Currency is different");
	}
	
}