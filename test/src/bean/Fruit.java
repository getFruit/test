package bean;


import java.io.Serializable;

public class Fruit  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String number,name ,color,origin,season,describe,taste;
	private Category category;
	private String[] function;
	private Fruiterer fruiterer;
	private float price;
	private double count;
	private Integer favorite;
	
	
	


	

	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getOrigin() {
		return origin;
	}



	public void setOrigin(String origin) {
		this.origin = origin;
	}



	public String getSeason() {
		return season;
	}



	public void setSeason(String season) {
		this.season = season;
	}



	public String getDescribe() {
		return describe;
	}



	public void setDescribe(String describe) {
		this.describe = describe;
	}



	public String[] getFunction() {
		return function;
	}



	public void setFunction(String[] function) {
		this.function = function;
	}



	public Fruiterer getFruiterer() {
		return fruiterer;
	}



	public void setFruiterer(Fruiterer fruiterer) {
		this.fruiterer = fruiterer;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public double getCount() {
		return count;
	}



	public void setCount(double count) {
		this.count = count;
	}



	public Integer getFavorite() {
		return favorite;
	}



	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	




	public String getTaste() {
		return taste;
	}



	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	
	
	
	
	
}
