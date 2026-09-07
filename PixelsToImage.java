import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

//4. Write a program that consumes pixel values and creates an image.
public class PixelsToImage {
    Scanner scan = new Scanner(System.in);

    public void prompt() {
        System.out.println("Enter width:");
        int width = scan.nextInt();
        System.out.println("Enter height:");
        int height = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter colors, no spaces (r=red, g=green, y=yellow, w=white, b=black, o=orange):");
        String colors = scan.nextLine();

        if (colors.length() != width * height) {
            System.out.println("Incorrect Input");
            System.exit(0);
        }

        BufferedImage image = buildImage(width, height, colors);

        System.out.println("Enter file name:");
        String fileName = scan.nextLine();

        try {
            ImageIO.write(image, "png", new File(fileName + ".png"));
        } catch (IOException e) {
            System.out.println("Couldn't write image: " + e.getMessage());
        }
    }

    public BufferedImage buildImage(int width, int height, String colors) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char letter = colors.charAt(y * width + x);
                image.setRGB(x, y, colorToRGB(letter));
            }
        }

        return image;
    }

    public int colorToRGB(char letter) {
        switch (letter) {
            case 'r':
                return Color.RED.getRGB();
            case 'g':
                return Color.GREEN.getRGB();
            case 'y':
                return Color.YELLOW.getRGB();
            case 'w':
                return Color.WHITE.getRGB();
            case 'b':
                return Color.BLACK.getRGB();
            case 'o':
                return Color.ORANGE.getRGB();
            default:
                System.out.println("Incorrect Input");
                System.exit(0);
                return 0;
        }
    }
}
