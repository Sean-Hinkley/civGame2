package gameEnv;

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
		Img tst = new Img("C:\\Users\\se.g.hinkley\\Desktop\\civGame2\\civGame2\\src\\gameEnv\\map\\Imgs\\Plains-Copy.png", "Plains");
		imgList.add(tst);
		System.out.println(imgList.get(0));
	}
	
	public BufferedImage getImg(int ind) {
		if(imgList.get(ind)!=null) {
			return imgList.get(ind).getImg();
		}
		
		return null;
	}
	
	
	public class Img {
		
		private BufferedImage img;
		public String title;
		
		
		public Img(BufferedImage im, String tit) {
			
		}
		
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
			/*int w = img.getWidth();
		    int h = img.getHeight();
		    BufferedImage dimg = new BufferedImage(128, 160, img.getType());
		    Graphics2D g = dimg.createGraphics();
		    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g.drawImage(img, 0, 0, 128, 160, 0, 0, w, h, null);
		    g.dispose();
		    image = dimg;*/
		}
		
		public BufferedImage getImg() {
			return img;
		}
		
		public String toString() {
			String tmp = title;
			return tmp;
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
	}
}
