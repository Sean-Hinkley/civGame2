package gameEnv;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
public class ImgHandler {
	private ArrayList<Img> imgList;
	public String title;
	public ImgHandler() {
		title = "Test";
		imgList = new ArrayList<Img>();
	}
	public BufferedImage getImg(int ind) {	
		if(imgList.size()>0) {
			if(imgList.get(ind)!=null) {
				return imgList.get(ind).getImg();
			}
			return null;
		}
		return null;
	}

	public void addImage(String tit, String set) {
		Img f = new Img(set, tit);
		imgList.add(f);
		f.resize(128,128 );
	}
	public class Img {
		private BufferedImage img;
		public String title;
		public Img(BufferedImage im, String tit) {}
		public Img(String im, String tit) {
			title = tit;
			try {
				img = ImageIO.read(new File(im));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void resize(int h, int w) {
			int wid = img.getWidth();
		    int heigt = img.getHeight();
		    BufferedImage dimg = new BufferedImage(wid, heigt, img.getType());
		    Graphics2D g = dimg.createGraphics();
		    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g.drawImage(img, 0, 0, w,h, 0, 0, w, h, null);
		    g.dispose();
		    img = dimg;
		}
		public BufferedImage getImg() {
			return img;
		}
		public String toString() {
			String tmp = title;
			return tmp;
		}
	}
}
