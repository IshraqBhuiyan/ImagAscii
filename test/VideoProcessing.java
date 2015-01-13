import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.JFrame;
import javax.imageio.plugins.*;
public class VideoProcessing{

    public BufferedImage[] GIFtoFrames(String fileLocation) throws IOException{
        File gif = new File(fileLocation);
	ImageReader reader = new GIFImageReader(new GIFImageReaderSpi());
	//	ImageReader reader = new GIFImageReader(new GIFImageReaderSpi());
        reader.setInput(ImageIO.createImageInputStream(gif));
        BufferedImage[] ans = new BufferedImage[reader.getNumImages(true)];
        for(int i=0;i<reader.getNumImages(true);i++){
            ans[i] = reader.read(i);
        }
        return ans;
    }

}