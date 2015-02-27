package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener, KeyListener {
	
	JPanel mainPanel;
	Warrior warrior1;
	JPanel finishPanel;
	public int blockSize = 20;
	
	public MainWindow() {
		mainPanel = new JPanel();
		warrior1 = new Warrior();
		finishPanel = new JPanel();
		
		finishPanel.setSize(40, 40);
		finishPanel.setLocation(400, 400);
		finishPanel.setBackground(Color.orange);
		
		mainPanel.setLayout(null);
		this.addKeyListener(this);
		mainPanel.add(warrior1);
		mainPanel.add(finishPanel);
		
		this.setTitle("Labyrinth Warrior");
		this.add(mainPanel);
		
	}
	
	
	
	
	public void makeWall(int height, int width, int x, int y) {//Coordinates starts form the top left; size is measured in blocks
		Wall wall = new Wall();
		wall.setSize(width*blockSize, height*blockSize);
		wall.setLocation(x*blockSize+5, y*blockSize+5);
		wall.setBackground(Color.black);
		mainPanel.add(wall);
		this.repaint();
		this.setTitle("wall spawned!");
	}
	
	private boolean rightPassable() {
		Component elementNextToWarrior = mainPanel.getComponentAt(warrior1.getX()+blockSize, warrior1.getY()+blockSize);
		if(elementNextToWarrior.getBackground() == Color.black)
			return false;
		else
			elementNextToWarrior = mainPanel.getComponentAt(warrior1.getX()+blockSize, warrior1.getY()+blockSize+blockSize-1);
		if(elementNextToWarrior.getBackground() == Color.black)
			return false;
		
		return true;
	}
	
	private boolean leftPassable() {
		Component elementNextToWarrior = mainPanel.getComponentAt(warrior1.getX()-1, warrior1.getY()+blockSize);
		if(elementNextToWarrior.getBackground() == Color.black)
			return false;
		else
			elementNextToWarrior = mainPanel.getComponentAt(warrior1.getX()-1, warrior1.getY()+blockSize+blockSize-1);
		if(elementNextToWarrior.getBackground() == Color.black)
			return false;
		
		return true;
	}
	
	private boolean downPassable() {
		Component elementNextToWarrior = mainPanel.getComponentAt(warrior1.getX(), warrior1.getY()+40);
		if(elementNextToWarrior.getBackground() == Color.black)
			return false;
		
		return true;
	}
	
	private boolean upPassable() {
		Component elementNextToWarrior = mainPanel.getComponentAt(warrior1.getX(), warrior1.getY()-1);
		if(elementNextToWarrior.getBackground() == Color.black)
			return false;
		
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		int x, y;
		int wHeight, wWidth;
		char key = arg0.getKeyChar();
		x = warrior1.getX();
		y = warrior1.getY();
		wWidth = ((this.getWidth()/5)*5-30);
		wHeight = ((this.getHeight()/5)*5-55);
		
		if(key == 'w' && x>=5 && y>5 && x<=wWidth && y<=wHeight && upPassable())
				y-=5;
		else if(key == 'a' && x>5 && y>=5 && x<=wWidth && y<=wHeight && leftPassable())
				x-=5;
		else if(key == 's' && x>=5 && y>=5 && x<=wWidth && y<wHeight && downPassable())
				y+=5;
		else if(key == 'd' && x>=5 && y>=5 && x<wWidth && y<=wHeight && rightPassable())
				x+=5;
		
		warrior1.setLocation(x, y);
		
		this.setTitle("X="+x+" Y="+y+" Wi="+this.getWidth()+" He="+this.getHeight());
		if(x == 400 && y == 400) {
			this.setTitle("won!!");
		}
		
		if(key == 'p') {
			makeWall(5, 1, 4, 7);
		}
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}