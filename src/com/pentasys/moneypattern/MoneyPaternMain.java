package com.pentasys.moneypattern;

public class MoneyPaternMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hey there I am working!");
		
		Money  m1 = new Money((int)10000);
		Money m2 = new Money((int)200);
		Money m3 = null;
		Money m4 = new Money((int)2300,"DM");
		Money m5 = new Money(8.77d);
		
		try {
			m3 = new Money( m1.add(m2));
		} catch (differentCurrencyException e) {
			System.out.println("money excepiton catched");
			e.printStackTrace();
		}
		
		System.out.println(m3.getAmount());
		System.out.println(m5.printAmount());

	}

}
