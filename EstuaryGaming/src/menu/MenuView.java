package menu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuView extends JPanel{
	
	BufferedImage[] images = new BufferedImage[2];
	public final static int screenWidth = 715;
	public final static int screenHeight = 635;
	
	public MenuView(){
		createImage();
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(images[0], 0, 0, new Color(0, 0, 0, 0), this);
		g.drawRect(221, 157, 262, 85);
		g.drawRect(221, 276, 262, 85);
		g.drawRect(221, 396, 262, 85);
	}
	
	private void createImage() {

		try{
			
			images[0] = ImageIO.read(new File("src/images/menuscreen.png"));//background
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}