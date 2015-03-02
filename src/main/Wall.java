package main;

import java.awt.Color;

import javax.swing.JPanel;

public class Wall extends JPanel {
	
	public Wall(int height, int width, int x, int y) {
		setSize(width*MainWindow.blockSize, height*MainWindow.blockSize);
		setLocation(x*MainWindow.blockSize+5, y*MainWindow.blockSize+5);
		setBackground(Color.black);
	}
}
