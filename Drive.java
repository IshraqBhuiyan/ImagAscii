import java.utils.Scanner;
public class  Drive{
    public static void main(String[]args){
	String image = "noimage";
	String outtxt = "noout";
	String outimg = "noout";
	boolean color = true;
	
	if(args.length=0){
	
	}
	else{
	    for(int i=0;i<args.length;i++){
		//		if(args[0] == "--help" || args[0] == "-h"){
		Switch(args[i]){
		    case "-h":
			System.out.println("Usage: Drive         Guided tutorial mode\n"+
					   "       Drive [FILE]  Convert FILE to ASCII art\n"+
					   "Initialization options:\n"+
					   "  -h, --help           See usage\n"+
					   "  --color              Add color to output\n"+
					   "  --output [filename]  Save output to filename.txt\n"+
					   "  --save [filename]    Save output to filename.png\n");
			break;
		    } 
		    case "--help":
			System.out.println("Usage: Drive         Guided tutorial mode\n"+
					   "       Drive [FILE]  Convert FILE to ASCII art\n"+
					   "Initialization options:\n"+
					   "  -h, --help           See usage\n"+
					   "  --color              Add color to output\n"+
					   "  --output [filename]  Save output to filename.txt\n"+
					   "  --save [filename]    Save output to filename.png\n");
			break;
		    } 
		    
	    }
	}
    }
}
