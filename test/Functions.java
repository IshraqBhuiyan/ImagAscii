import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public final class ImageProcessing{

    public static int[][][] convertToGrayscale(String imagelocation, bool colors) throws IOException{ // converts image at imagelocation to a 2d array of it's grayscale
	File rawimage = new File(imagelocation);
	BufferedImage image = ImageIO.read(rawimage);
	int height = image.getHeight();
	int width = image.getWidth();
	int[][][] ans = new int[width][height][4];
	for( int x = 0;x<width;x++){
	    for(int y = 0; y<height;y++){
		Color c = new Color(image.getRGB(x,y));
		//Stores RGB values in the array
		if(colors){
		    
		    ans[x][y][1] = c.getRed();
		    ans[x][y][2] = c.getGreen();
		    ans[x][y][3] = c.getBlue();
		}

		// Stores Grayscale values
		int red = (int)(ans[x][y][1] * 0.299);
		int green = (int)(ans[x][y][2] * 0.587);
		int blue = (int)(ans[x][y][3] *0.114);
		ans[x][y][0] = red + green + blue;
	    }
	}
	return ans;
    }


    public static int average(int[][][] grayscale,int width, int height,int x,int y, int color){// returns the average grayscale of a widthxheight at x,y
	int ans = 0;
	for(int i = 0;i<width;i++){
	    for(int t = 0; t<height;t++){
		ans += grayscale[i+x][t+y][color];
	    }
	}
	return ans/(width*height);
    }

    public static int[][][] blockBreak(int[][][] grayscale, int scale){
	int yscale =(scale*3) / 2;// (2*scale)/3;
	int width = grayscale.length/scale;
	int height = grayscale[0].length/yscale;
	int[][][] ans = new int[height][width][4];
	for(int x = 0;x<width;x++){
	    for(int y=0;y<height;y++){
		//System.out.println("" + x*width + " " + y*height);
		
		for(int i=0;i<4;i++){
		    ans[y][x][i] = average(grayscale,scale,yscale,x*scale,y*yscale,i);	
		}
	    }

	}
	return ans;
    }
    /*
    public static int[][] BreakBlock(int[][] grayscale, int scale){ //takes an array of grayscale pixels and then using a relative scale from 1 to 10, where 1 has the lowest
	                                                            //block density, breaks the image into block
	int blockWidth = grayscale[0].length/(80 * scale);
	int blockHeight = grayscale.length/(40*scale);
	int yBlocks = grayscale.length/blockHeight;
	if(grayscale.length % blockHeight != 0) yBlocks++;
	int xBlocks = grayscale[].length/blockWidth;
	if(grayscale[0].length % blockWidth != 0) xBlocks++;
	int[][][] Blocks = new int[yBlocks][xBlocks][4];
	for(int i=0; i<yBlocks; i++){
	    for(int j=0;j<xBlocks;j++){
		if(i==yBlocks){
		    if(j==xBlocks){
			Blocks[i][j][0] = average(grayscale,grayscale[i].length % blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight,0);
			Blocks[i][j][1] = average(grayscale,grayscale[i].length % blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight,1);
			Blocks[i][j][2] = average(grayscale,grayscale[i].length % blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight,2);
			Blocks[i][j][3] = average(grayscale,grayscale[i].length % blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight,3);
		    }else{
			Blocks[i][j][0] = average(grayscale, blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight,);
			Blocks[i][j][1] = average(grayscale, blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight);
			Blocks[i][j][2] = average(grayscale, blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight);
			Blocks[i][j][3] = average(grayscale, blockWidth, grayscale.length % blockHeight, j*BlockWidth, i*blockHeight);
		    }
		}else if(j==xBlocks){
		    Blocks[i][j] = average(grayscale, grayscale[i].length % blockWidth, blockHeight, j*blockWidth, i*blockHeight);
		}else{
		    Blocks[i][j] = average(grayscale, blockWidth, blockHeight, j*blockWidth, i*blockHeight);
		}
	    }
	}
	return Blocks;
    }
    */
    public static String grayToChar(int val){
	String scale = " .:-*\\=±½©®æ¥Æ#";
	return ""+scale.charAt(14-(14/(255/(val+1))));
	//int index  = 0;
	
	//	for
    }
 
    public static String[] imageToAscii(String filename,int scale)throws IOException{ // returns an array of lines of ASCII art
	int[][][] grayscale = convertToGrayscale(filename);
	int[][][] breakup = blockBreak(grayscale,scale);
	String[] ans = new String[]; 
	for(int x = 0;x<breakup.length;x++){
	    for(int y = 0;y<breakup[0].length;y++){
		ans[x] += grayToChar(breakup[x][y]);
	    }
	}
	return ans;
    }
    
    public static BufferedImage buildImage(String[] art,w,h,int[][][] colors){//colors contains the colors of an image formatted as [x][y][0-2] 0-2 returning red green or blue
	int width = w*art[0].length();
	int height = h*art.length;
	BufferedImage output = new  BufferedImage(width,height,"png");
	for( int blockx=0;blockx<art[0].length();blockx++){
	    int firstx = blockx*w;
	    for(int blocky=0;blocky<art.length;blocky++){
		int firsty = block*h;
		bool[][] cmap = charMap.get(art[blocky].charAt(blockx));//stores a boolean based map of the ascii character you're drawing
		for(int x = 0;x<w;x++){
		    for(int y =0;y<h;y++){
			Color c = new Color(255,255,255);
			if(cmap[x][y]){
			    c.setRed(colors[blockx][blocky][0];
			    c.setGreen(colors[blockx][blocky][1];
			    c.setBlue(colors[blockx][blocky][2];
			}
		    }
		}
	    }
	}
	
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
	//	grayscaletoblurryimage("grascale.jpg", convertToGrayscale("Fate.zero.full.1072802.jpg"));
	System.out.println(imageToAscii("gray.jpg",10));
    }
}
