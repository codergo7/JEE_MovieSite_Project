package com.entity;

public class Director {
	private int id;
	private String name;

	public Director() {
		// TODO Auto-generated constructor stub
	}

	public Director(String name, int id) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
