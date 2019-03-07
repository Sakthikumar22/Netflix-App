package com.chainsys.model;

public class Movie {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int id;
	private String name;
	private int price;
	
	private String castname,castrole;
	public String getCastname() {
		return castname;
	}
	public void setCastname(String castname) {
		this.castname = castname;
	}
	public String getCastrole() {
		return castrole;
	}
	public void setCastrole(String castrole) {
		this.castrole = castrole;
	}
	private Director director;
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	} 
	
	
	
	
	
}

