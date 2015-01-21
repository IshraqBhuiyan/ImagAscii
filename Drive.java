import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.util.Scanner;
public class  Drive{
    public static void main(String[]args) throws Exception{
	String input;
	String outtxt = "noout";
	String outimg = "noout";
	boolean color = true;
	boolean tutorial = args.length==0;
	

	for(int i=1;i<args.length;i++){
	    //		if(args[0] == "--help" || args[0] == "-h"){

	    if(args[i].equals("-h") || args[i].equals("--help")){
		System.out.println("Usage:\n  Drive         Guided tutorial mode\n"+
				   "       Drive [FILE]  Convert FILE to ASCII art\n"+
				   "Initialization options:\n"+
				   "  -h, --help           See usage\n"+      
				   "  --color              Add color to output(feature pending)\n"+
				   "  --output [filename]  Save output to filename.txt\n"+
				   "  --save [filename]    Save output to filename.png\n");	

	    }else if(args[i].equals("--output")){
		try{
		    if(!(args[i+1].charAt(0) == '-')){
			i++;
			outtxt = args[i];
		    }else{	
			System.out.println("ERROR: No output file given");
		    }
		} catch(IndexOutOfBoundsException e){
		    System.out.println("ERROR: No output file given");
		}
	    }else if(args[i].equals("--save")){
		try{
		    if(!(args[i+1].charAt(0) == '-')){
			i++;
			outimg = args[i];
		    }else{	
			System.out.println("ERROR: No output file given");
		    }
		} catch(IndexOutOfBoundsException e){
		    System.out.println("ERROR: No output file given");
		}
		    
	    }else{
		color = args[i].equals("--color");
	    }
	}
	if(!tutorial){
	    input = args[0];
	}else{//  Begin Tutorial
	    Scanner reader = new Scanner(System.in);
	    System.out.println("Welcome to the Swagscii tutorial! Please enter the name of the image you would like to convert to ASCII art");
	    input = reader.nextLine();
	    System.out.println("Would you like your image to be returned in color? Y/n(feature pending)");
	    color = reader.nextLine().toLowerCase().equals("y");
	    System.out.println("Would you like to out put your ASCII art to a text file? Y/n");
	    if(reader.nextLine().toLowerCase().equals("y")){
		System.out.println("please enter a name for the output file");
		outtxt = reader.nextLine();
	    }
	    System.out.println("Would you like to out put your ASCII art to an image file? Y/n");
	    if(reader.nextLine().toLowerCase().equals("y")){
		System.out.println("please enter a name for the output file, without any file extensions");
		outimg = reader.nextLine();
	    }
	    System.out.println("Processing image...");
	}	
	File rawimage = new File(input);
	BufferedImage image = ImageIO.read(rawimage);
	int Iheight = image.getHeight();
	int Iwidth = image.getWidth();
	//Begin doing stuff with the parameters gathered
	System.out.println("begin processing");
	String text = ImageProcessing.imageToAscii(input,3);

	//String[] splitText = ImageProcessing.imageToAsciiArray(input, 3);;
	//System.out.println("begin rendering");
	//BufferedImage renderIMG = ImageOutput.renderTextToImage(splitText);
	//ImageIO.write(renderIMG, "png", new File(outimg + ".png"));
	String[] splitText = ImageProcessing.imageToAsciiArray(input, 3);;
	System.out.println("begin rendering");
	BufferedImage renderIMG = ImageOutput.renderTextToImage(splitText);
	ImageIO.write(renderIMG, "png", new File(outimg + ".png"));
	if(!(outtxt.equals("noout"))){
	    PrintWriter txtfile = new PrintWriter(outtxt+".txt");
	    txtfile.println(text);
	    txtfile.close();
	}

	System.out.println("begin jframing");
	SwagWindow output = new SwagWindow(input,text,Iwidth,Iheight,2);
	output.pack();
	output.setVisible(true);
	Thread.sleep(1000);
	BufferedImage outputIMG = takeScreenshot(output);
	ImageIO.write(outputIMG, "png", new File(outimg + ".png"));
    //System.out.println(input,color,outimg,outtxt,tutorial);
}
    public static BufferedImage takeScreenshot(JFrame argFrame){
	Rectangle rec = argFrame.getBounds();
	BufferedImage output = new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
	argFrame.paint(output.getGraphics());
	return output;
    }
}
