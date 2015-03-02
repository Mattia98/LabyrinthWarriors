package main;

public class Main {

	public static void main(String[] args) {
		MapLoader mapLoader = new MapLoader();
		
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		//mainWindow.setResizable(false);
		mainWindow.setSize(800, 600);
		mainWindow.setLocation(200, 100);
	}

}