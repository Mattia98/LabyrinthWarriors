package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Entity extends JPanel {
	
	public enum Direction {
		up,
		down,
		right,
		left
	}
	
	BufferedImage still;
	protected String imagePath = "resources/noimage.png";
	
	public Entity() {
		this.setSize(MainWindow.blockSize, MainWindow.blockSize);
		this.setLocation(10, 10);
	}
	
	protected Boolean loadStandardImage(String path) {
		try {
			still = ImageIO.read(new File(path));
			this.setOpaque(false);
		} catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean moveEntity(Direction direction) {
		int x, y, step;
		x = this.getX();
		y = this.getY();
		step = MainWindow.blockSize/4;
		switch(direction) {
			case up:
			y-=step; break;
			case down:
				y+=step; break;
			case right:
				x+=step; break;
			case left:
				x-=step; break;
		}
		this.setLocation(x, y);
		return true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    g.drawImage(still, 0, 0, getWidth(), getHeight(), this);
	}
}
