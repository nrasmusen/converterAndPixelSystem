import java.util.Scanner;
import java.lang.Integer;

//2. Build a number-base converter supporting binary, decimal, octal, and hexadecimal.
public class NumberBaseConverter {
    String input;
    int num;
    
    Scanner scan = new Scanner(System.in);

    public void prompt() {
        System.out.println("Enter Number:");
        input = scan.nextLine();
        char[] charArr = input.toCharArray();

        System.out.println("Convert from: \n1. Binary, \n2. Decimal, \n3. Octal, \n4. Hex (use lowercase)");
        switch (scan.nextInt()) {
            case 1:
                num = binaryToDecimal(Integer.parseInt(input));
                break;
            case 2:
                break;
            case 3:
                num = octalToDecimal(Integer.parseInt(input));
                break;
            case 4:
                num = hexToDecimal(charArr);
                break;

            default:
                System.out.println("Incorrect Input");
                System.exit(0);
                break;
        }

        System.out.println("Convert to: \n1. Binary, \n2. Decimal, \n3. Octal, \n4. Hex (use lowercase)");
        switch (scan.nextInt()) {
            case 1:
                System.out.println("Converted Number: " + decimalToBinary(num));
                break;
            case 2:
                System.out.println("Converted Number: " + num);
                break;
            case 3:
                System.out.println("Converted Number: " + decimalToOctal(num));
                break;
            case 4:
                System.out.println("Converted Number: " + decimalToHex(num));
                break;

            default:
                System.out.println("Incorrect Input");
                System.exit(0);
                break;
        }
    }

    public int binaryToDecimal(int num) {
        if (num < 10) {
            return num;
        }
        return binaryToDecimal(num / 10) * 2 + (num % 10);
    }

    public String decimalToBinary(int num) {
        if (num < 2) {
            return String.valueOf(num);
        }
        return decimalToBinary(num / 2) + (num % 2);
    }

    public int octalToDecimal(int num) {
        if (num < 10) {
            return num;
        }
        return octalToDecimal(num / 10) * 8 + (num % 10);
    }

    public String decimalToOctal(int num) {
        if (num < 8) {
            return String.valueOf(num);
        }
        return decimalToOctal(num / 8) + (num % 8);
    }
    
    public int hexToDecimal(char[] charArr){
        for (char c : charArr) {
            if(!Character.isDigit(c)){
                
            }
        }
        return 0;
        
    }

    public String decimalToHex(int num){
        return "";
    }
}
