import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//3. Write a program that reads an image and prints its pixel values.
public class ImageToPixels {
    String input = "smileImage.png";

    public void prompt() {
        try {
            BufferedImage image = ImageIO.read(new File(input));
            printPixels(image);
        } catch (IOException e) {
            System.out.println("Couldn't read image: " + e.getMessage());
        }
    }

    public void printPixels(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            System.out.println();
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                Color c = new Color(rgb);
                System.out.print("(" + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + "), ");
            }
        }
    }
}
