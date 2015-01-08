import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public final class ImageProcessing{

    public static int[][] convertToGrayscale(String imagelocation) throws IOException{ // converts image at imagelocation to a 2d array of it's grayscale
	File rawimage = new File(imagelocation);
	BufferedImage image = ImageIO.read(rawimage);
	int height = image.getHeight();
	int width = image.getWidth();
	int[][] ans = new int[width][height];
	for( int x = 0;x<width;x++){
	    for(int y = 0; y<height;y++){
		Color c = new Color(image.getRGB(x,y));
		int red = (int)(c.getRed() * 0.299);
		int green = (int)(c.getGreen() * 0.587);
		int blue = (int)(c.getBlue() *0.114);
		ans[x][y] = red + green + blue;
	    }
	}
	return ans;
    }


    public static int average(int[][] grayscale,int width, int height,int x,int y){// returns the average grayscale of a widthxheight at x,y
	int ans = 0;
	for(int i = 0;i<width;i++){
	    for(int t = 0; t<height;t++){
		ans += grayscale[i+x][t+y];
	    }
	}
	return ans/(width*height);
    }

	public static int[][] blackBreak(int[][] grayscale, int scale){
		int yscale = scale*2;
		int width = grayscale.length/scale;
		int height = grayscale[0].length/yscale;
		int[][] ans = new int[width][height];
		for(int x = 0;x<width;x++){
			for(int y=0;y<height;y++){
				ans[x][y] = average(grayscale,scale,yscale,x*width,y*height);	
			}
		}
		return ans;
	}

	//Test function thingies and potatoes below, enjoy


    public static void grayscaletoimage(String destination, int[][] input) throws IOException{
	BufferedImage image = new BufferedImage(input.length,input[0].length,1);
	for(int x = 0;x<input.length;x++){
	    for(int y=0;y<input[x].length;y++){
		Color c  = new Color(input[x][y],input[x][y],input[x][y]);
		image.setRGB(x,y,c.getRGB());
	    }
	}
	File dest = new File(destination);
	ImageIO.write(image,"jpg",dest);
    }


    public static void grayscaletoblurryimage(String destination, int[][] input) throws IOException{
	BufferedImage image = new BufferedImage(input.length,input[0].length,1);
	for(int x = 0;x<input.length - 170;x++){
	    for(int y=0;y<input[x].length - 100;y++){
		input[x][y] = average(input,100,100,x,y);
		Color c  = new Color(input[x][y],input[x][y],input[x][y]);
		image.setRGB(x,y,c.getRGB());
	    }
	}
	File dest = new File(destination);
	ImageIO.write(image,"jpg",dest);
    }

    public static void main(String[] args) throws IOException{
	grayscaletoblurryimage("grascale.jpg", convertToGrayscale("Fate.zero.full.1072802.jpg"));
	
    }
}
