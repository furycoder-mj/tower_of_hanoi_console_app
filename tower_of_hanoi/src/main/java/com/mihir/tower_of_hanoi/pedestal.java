package com.mihir.tower_of_hanoi;

import java.util.Stack;
import com.mihir.tower_of_hanoi.disc;


public class pedestal {
	Stack<disc> discList;
	String name;
	public pedestal() {
		this.discList = new Stack<disc>();
	}
	public pedestal(String name) {
		this.name = name;
		this.discList = new Stack<disc>();
	}
	public Stack<disc> getDiscList() {
		return discList;
	}

	public void setDiscList(Stack<disc> discList) {
		this.discList = discList;
	}
}
