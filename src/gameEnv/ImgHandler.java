package gameEnv;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ListFormat.Style;
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

	public int chkImg(String tit, String set) {
		for(int x = 0; x < imgList.size(); x++) {
			if(imgList.get(x).getimgStr().equals(set)) {
				return x;
			}
		
		}
		int ind = imgList.size();
		addImage(tit, set);
		return ind;
	}	

	public void addImage(String tit, String set) {
		Img f = new Img(set, tit);
		imgList.add(f);
		f.resize(128,128 );
	}

	public void resize(int w, int h) {
		for(int x = 0; x < imgList.size(); x++) {
			Img im = imgList.get(x);
			//System.out.println("W" + w + " H" + h);
			im.resize(w,h);
		}
	}
	public class Img {
		private BufferedImage img;
		public String title;
		private String imgstr;
		public Img(BufferedImage im, String tit) {}
		public Img(String im, String tit) {
			title = tit;
			imgstr = im;
			try {
				//System.out.println(im);
				img = ImageIO.read(new File(im));
				resize(128, 128);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

		public String getimgStr() {
			return imgstr;
		}
		public void resize(int w, int h) {
			//System.out.println("W" + w + " H" + h);
		    BufferedImage dimg = new BufferedImage(w, h, img.getType());
		    Graphics2D g = dimg.createGraphics();
		    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g.drawImage(img, 0, 0, w, h, null);
		    g.dispose();
		    img = dimg;
			//System.out.println(img.getWidth());
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
