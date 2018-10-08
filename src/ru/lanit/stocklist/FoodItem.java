package ru.lanit.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem{
	
	private Date dateOfIncome; //Дата поступления
	private short expires; // Срок годности
	
	public FoodItem(String name, float price, FoodItem analog, Date date, short expires){
		super(name,price,analog);
		this.dateOfIncome = date;
		this.expires      = expires;
		this.setCategory(Category.FOOD);
	}
	
	public FoodItem(String name, float price){
		this(name,price,null,new Date(),(short)256);
	}
	
	public FoodItem(String name){
		this(name,100,null,new Date(),(short)256);
	}
	
	public void printAll(){
		System.out.println("Name: "+getName()+"; ");
		System.out.println("price: "+getPrice()+"; ");
		System.out.println("analog: "+getAnalog().getName()+"; ");
		System.out.println("Date of income: "+dateOfIncome+"; ");
		System.out.println("Expires: "+expires+"; ");
		System.out.println();
	}
	
	@Override
	public String toString(){
		return "ID: "+getID()+"; Name: "+getName()+"; Price: "+getPrice()+"; Date:" +dateOfIncome;
	}

	public void setDateOfIncome(Date dateOfIncome) {
		this.dateOfIncome = dateOfIncome;
	}

	public Date getDateOfIncome() {
		return dateOfIncome;
	}

	public void setExpires(short expires) {
		this.expires = expires;
	}

	public short getExpires() {
		return expires;
	}

	public FoodItem clone(){
		return new FoodItem(getName(),getPrice(),null,dateOfIncome,expires);
	}
	
	//Эквивалентными считаем те товары, у которых одинаковые наименования, цены и 
	//сроки годности
	public boolean equals(Object o){
		if(o instanceof FoodItem){
			boolean b1,b2,b3;
			FoodItem i = (FoodItem)o;			
			b1 = (i.getName().equals(getName()));
			b2 = (i.getPrice()==getPrice());
			b3 = (i.expires==expires);
			return(b1&&b2&&b3);
		}
		return false;
	}
	
}
