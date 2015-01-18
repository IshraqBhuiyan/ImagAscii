import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwagWindow extends JFrame{// implements ActionListener{
    /*    private JButton ctof;
    private JButton ftoc;
    private JTextField input;*/
    private Container c1;
    private JTextArea output;
    //private double answer;
    public SwagWindow(String title,String content,int width,int height,int size){
	this.setTitle(title);
	this.setSize(width,height);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//	input = new JTextField(12);
	//	ctof = new JButton("Celsius to Fahrenheit");

	output = new JTextArea(content);
	c1 = this.getContentPane();
	c1.setLayout(new FlowLayout());
	Font f = new Font(Font.MONOSPACED, 3, size);
	output.setFont(f);
	//	ftoc.addActionListener(this);

	/*	c1.add(input);
	c1.add(ctof);
	c1.add(ftoc);*/
	c1.add(output);
    }

 }