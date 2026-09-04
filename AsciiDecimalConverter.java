import java.util.Scanner;

//1. Build an ASCII-to-decimal converter.
public class AsciiDecimalConverter {
    String str;
    Scanner scan = new Scanner(System.in);

    public void prompt() {
        System.out.println("Enter String to Convert");
        str = scan.nextLine();

        System.out.println("Converted to Decimal:");
        for(char c : str.toCharArray()){
            System.out.print((int)c + " ");
        }
    }
}
