import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class Colors{
    private String hex = "0123456789ABCDEF";
    
    public String hexCode(Color thiscolor){
	return "#"+intToHex(thiscolor.getRed())+intToHex(thiscolor.getGreen())+intToHex(thiscolor.getBlue());
    }

    public static String intToHex(int val){
	return hex[val/16] + hex[val%16];
    }


}