package main;

import java.awt.Color;

import javax.swing.JPanel;

public class Warrior extends JPanel {
	
	public Warrior() {
		this.setSize(20, 40);
		this.setLocation(10, 10);
		this.setBackground(Color.green);
	}
	
	
	//Moves the warrior 5 px up.
	public Boolean moveUp() {
		int x, y;
		x = this.getX();
		y = this.getY();
		y-=5;
		this.setLocation(x, y);
		return true;
	}
	
	
}
