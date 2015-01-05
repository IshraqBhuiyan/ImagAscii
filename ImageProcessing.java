import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class ImageProcessing{

    public int[][] convertToGrayscale(String imagelocation){ // converts image at imagelocation to a 2d array of it's grayscale
	BufferedImage image;
	rawimage = new File(imagelocation);
	image = ImageIO.read(rawimage);
	int height = image.getHeight();
	int width = image.getWidth();
	int[][] ans = new int[width][height]
	for( int x = 0;x<width;x++){
	    for(int y = 0; y<height;y++){
		Color c = new Color(image.getRGB(x,y));
		int red = (int)(c.getRed() * 0.299);
		int green = (int)(c.getGreen() * 0.587);
		int blue = (int)(c.getBlue() *0.114);
		ans[x][y] = red + green + blue
	    }
	}
	return ans;
    }
	

}