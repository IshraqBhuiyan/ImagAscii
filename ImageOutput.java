import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.FontMetrics;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Hashtable;
import java.util.LinkedList;

public class ImageOutput{
    /**
     * Renders a paragraph of text
     */
    public static BufferedImage renderTextToImage(String[] text){
	Font font = new Font("Serif", Font.PLAIN, 6);
	BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2d = img.createGraphics();
	g2d.setFont(font);
	FontMetrics fm = g2d.getFontMetrics();
	int width = fm.stringWidth(text[0]);
	//int width = fm.getWidths() * text[0].length() ;
	//int height = fm.getHeight() * text.length;
	int height = (fm.getAscent() + fm.getDescent() + fm.getLeading())*text.length;
	g2d.dispose();

	img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	g2d = img.createGraphics();
	
	g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
	g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
	g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	
	g2d.setFont(font);
	fm = g2d.getFontMetrics();
	g2d.setColor(Color.BLACK);

	float drawPosY = 0;
	float drawPosX = 0;

	System.out.println("begin writing image");
	int i = 0;
	while(i < text.length){
	    System.out.println("" + i);
	    drawPosY += fm.getAscent();
	    g2d.drawString(text[i], drawPosX, drawPosY);
	    drawPosY += fm.getDescent() + fm.getLeading();
	    i++;
	}
	g2d.dispose();
	return img;
    }

}
