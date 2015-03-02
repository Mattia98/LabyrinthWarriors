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
	public static int blockSize = 20;
	
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
		
		for(int i = 0; i<MapLoader.walls.size(); i++) {
			addWall(MapLoader.walls.get(i));
		}
		
		this.setTitle("Labyrinth Warrior");
		this.add(mainPanel);
		
	}
	
	
	
	
	public void addWall(Wall wall) {
		mainPanel.add(wall);
		this.repaint();
		this.setTitle("wall spawned!");
	}
	
	private boolean rightPassable() {
		return !((mainPanel.getComponentAt(warrior1.getX()+blockSize*2, warrior1.getY()).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()+blockSize*2, warrior1.getY()+blockSize).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()+blockSize*2, warrior1.getY()+blockSize*2-1).getBackground() == Color.black));
	}
	
	private boolean leftPassable() {
		return !((mainPanel.getComponentAt(warrior1.getX()-1, warrior1.getY()).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()-1, warrior1.getY()+blockSize).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()-1, warrior1.getY()+blockSize*2-1).getBackground() == Color.black));
	}
	
	private boolean downPassable() {
		return !((mainPanel.getComponentAt(warrior1.getX(), warrior1.getY()+blockSize*2).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()+blockSize, warrior1.getY()+blockSize*2).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()+blockSize*2-1, warrior1.getY()+blockSize*2).getBackground() == Color.black));
	}
	
	private boolean upPassable() {
		return !((mainPanel.getComponentAt(warrior1.getX(), warrior1.getY()-1).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()+blockSize, warrior1.getY()-1).getBackground() == Color.black)||
				(mainPanel.getComponentAt(warrior1.getX()+blockSize*2-1, warrior1.getY()-1).getBackground() == Color.black));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		int x, y;
		int wHeight, wWidth;
		int key = arg0.getKeyCode();
		x = warrior1.getX();
		y = warrior1.getY();
		wWidth = ((this.getWidth()/5)*5-30);
		wHeight = ((this.getHeight()/5)*5-55);
		
		if(key == 87 && x>=5 && y>5 && x<=wWidth && y<=wHeight && upPassable())
			warrior1.moveEntity(Warrior.Direction.up);
		else if(key == 65 && x>5 && y>=5 && x<=wWidth && y<=wHeight && leftPassable())
			warrior1.moveEntity(Warrior.Direction.left);
		else if(key == 83 && x>=5 && y>=5 && x<=wWidth && y<wHeight && downPassable())
			warrior1.moveEntity(Warrior.Direction.down);
		else if(key == 68 && x>=5 && y>=5 && x<wWidth && y<=wHeight && rightPassable())
			warrior1.moveEntity(Warrior.Direction.right);
		
		
		this.setTitle("X="+x+" Y="+y+" Wi="+this.getWidth()+" He="+this.getHeight());
		if(x == 400 && y == 400) {
			this.setTitle("won!!");
		}
		
		if(key == 80) {
			addWall(new Wall(5, 1, 4, 7));
		}
		if(key == 81) {
			
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