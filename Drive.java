import java.util.Scanner;
public class  Drive{
    public static void main(String[]args){
	String image,input;
	String outtxt = "noout";
	String outimg = "noout";
	boolean color = true;
	boolean tutorial = args.length==0;
	

	if(!tutorial){
	    input = ars[0];
	}
	for(int i=1;i<args.length;i++){
	    //		if(args[0] == "--help" || args[0] == "-h"){

	    if(args[i].equals("-h") || args[i].equals("--help")){
		System.out.println("Usage:\n  Drive         Guided tutorial mode\n"+
				   "       Drive [FILE]  Convert FILE to ASCII art\n"+
				   "Initialization options:\n"+
				   "  -h, --help           See usage\n"+
				   "  --color              Add color to output\n"+
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
	//Begin Tutorial
	if(tutorial){
	    Scanner reader = new Scanner(System.input);
	    System.out.println("Welcome to the Swagscii tutorial! Please enter the name of the image you would like to conver to ASCII art");
	    image = reader.nextLine();
	    System.out.println("Would you like your image to be returned in color? Y/n");
	    color = reader.nextLine().StringToLowerCase().equals("y");
	    System.out.println("Would you like to out put your ASCII art to a text file?");
	    if(reader.nextLine().StringToLowerCase().equals("y")){
		System.out.println("please enter a name for the output file");
		outtxt = reader.nextLine();
	    }
	    System.out.println("Would you like to out put your ASCII art to an image file?");
	    if(reader.nextLine().StringToLowerCase().equals("y")){
		System.out.println("please enter a name for the output file");
		outimg = reader.nextLine();
	    }
	    System.out.println("Processing image...");
	}	
	 
	//Begin doing stuff with the parameters gathered	


    }
}
