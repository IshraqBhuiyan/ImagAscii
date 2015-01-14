import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.util.ArrayList;
public final class VideoProcessing{

    public static ArrayList<BufferedImage> getImage(String url) throws Exception{
	ArrayList<BufferedImage> inStream = new ArrayList<BufferedImage>;
	ImageReader image = ImageIO.read(new URL(url));

    }
	
					      







    
    //////////////////////////////////////////////////////////////////////////////////////////////
    public BufferedImage[] OldGIFtoFrames(String fileLocation) throws IOException{
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

    public BufferedImage[] GifReader(String fileLocation) throws IOException{
	File gif = new File(fileLocation);
	BufferedImage image = ImageIO.read(gif);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    
}
