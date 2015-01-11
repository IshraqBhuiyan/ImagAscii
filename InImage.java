import java.util.*;
import java.io.*;
import java.awt.*;


//when this class is construct, make sure to use try catch statements to find a valid file
public class InImage throws IOException{
    private Color[][] RGB;
    BufferedImage image;

    public InImage(String filename){
	convertRGB(filename);
    }

    public void openFile(filename){
	image = new BufferedImage(new File(filename));
	RGB = new Color[image.getHeight()][image.getWidth()];
    }

    public void convertRGB(filename){
	openFile(filename);
	for(int i=0;i<image.getHeight();i++){
	    for(int t=0;t<image.getWidth();t++){
		RGB[i][t] = new Color(image.getRGB(t, i));
	    }
	}
    }

    public Color[][] getRGB(){
	return RGB;
    }
}
