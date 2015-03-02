package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Warrior extends Entity {
	
	public Warrior() {
		this.setSize(MainWindow.blockSize*2, MainWindow.blockSize*2);
		loadStandardImage("resources/warriorstill.png");
	}
	
	
}
