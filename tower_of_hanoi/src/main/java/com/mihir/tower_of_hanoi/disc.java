package com.mihir.tower_of_hanoi;

public class disc {
	public disc(int size, String name) {
		this.size = size;
		this.name = name;
	}
	int size;
	String name;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
