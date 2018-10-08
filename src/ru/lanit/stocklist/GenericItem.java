package ru.lanit.stocklist;

import java.util.Date;

public class GenericItem {
	
	static int currentID = 1; // ������� ID 
	
	private int ID;   // ID ������
	private String name; // ������������ ������
	private float price; //���� ������
	private GenericItem analog; //�������
	private Category category = Category.GENERAL;
	
	public GenericItem(String name, float price, GenericItem analog){
		this.ID = GenericItem.currentID++;
		this.setName(name);
		this.setPrice(price);
		this.setAnalog(analog);		
	}
	
	public GenericItem(String name, float price, Category category){
		this.ID = GenericItem.currentID++;
		this.setName(name);
		this.setPrice(price);
		this.setCategory(category);		
	}
	
	public void printAll(){
		System.out.println("Name: "+getName()+"; ");
		System.out.println("price: "+getPrice()+"; ");
		System.out.println("analog: "+getAnalog().getName()+"; ");		
	}

	public int getID() {
		return ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setAnalog(GenericItem analog) {
		this.analog = analog;
	}

	public GenericItem getAnalog() {
		return analog;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}
	
	//�������������� ������� �� ������, � ������� ���������� ������������, ���� � 
	//����� ��������
	public boolean equals(Object o){
		if(o instanceof GenericItem){
			boolean b1,b2,b3;
			GenericItem i = (GenericItem)o;			
			b1 = (i.getName().equals(getName()));
			b2 = (i.getPrice()==getPrice());
			b3 = (i.getCategory()==this.category);
			return(b1&&b2&&b3);
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "ID: "+getID()+"; Name: "+getName()+"; Price: "+getPrice();
	}
	
}
