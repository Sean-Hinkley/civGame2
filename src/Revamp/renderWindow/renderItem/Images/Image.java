package Revamp.renderWindow.renderItem.Images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
    String title;
    private BufferedImage image;

    public Image(String imgstr, String tit) {
        title = tit;
        try {
            image = ImageIO.read(new File("src\\Revamp\\renderWindow\\Sand.png"));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }


}
