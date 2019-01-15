package dominationassemble;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class SemiDomino implements ImageObserver {

	public static Image getImage(String type) {
		Image image = null;
		try {
			switch (type) {

			case ("Mer"):
				image = ImageIO.read(new File("resources/water.png"));

			case ("Mine"):
				ImageIO.read(new File("resources/mines.png"));

			case ("Montage"):
				image = ImageIO.read(new File("resources/desert.png"));

			case ("Foret"):
				ImageIO.read(new File("resources/foret.png"));

			case ("Champs"):
				ImageIO.read(new File("resources/wheat.png"));

			case ("Prairie"):
				ImageIO.read(new File("resources/grass.png"));

			default:
				System.out.println("error");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;

	}

	public void placement(Graphics g, Image image, int cordX, int cordY) {

		g.drawImage(image, cordX, cordY, 56, 56, this);

	}
}
