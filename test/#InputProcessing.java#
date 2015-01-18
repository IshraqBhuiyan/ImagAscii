import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.util.ArrayList;
import java.io.File;
import java.util.Iterator;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.FileImageOutputStream;
public final class InputProcessing{

    public static ArrayList<BufferedImage> getImage(String url, int frameTime) throws IOException{
	ArrayList<BufferedImage> inStream = new ArrayList<BufferedImage>; //if number of elements in inStream > 1, then it is a gif, elsewise it is a single image
	ImageReader image = ImageIO.read(new URL(url));
	try{
	    int i = image.getMinIndex();
	    while(true){
		inStream.add(image.read(i));
		i++;
	    }
	}catch(IndexOutOfBoundsException e){
	    //does nothing, just breaks off reading the image
	}
	return inStream;

    }
	
    public static void writeGif(String output, ArrayList<BufferedImage> gifSequence){
	File file = new File(output);
	//Iterator ImageWriters = ImageIO.getImageWritersByFormatName("GIF");
	//ImageWriter Writer = null;
	ImageOutputStream output = new FileImageOutputProcessing(file);
	GifSequenceWriter
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
