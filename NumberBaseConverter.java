import java.util.Scanner;
import java.lang.Integer;

//2. Build a number-base converter supporting binary, decimal, octal, and hexadecimal.
public class NumberBaseConverter {
    String input;
    int num;
    char[] hexRef = { 'a', 'b', 'c', 'd', 'e', 'f' };
    Scanner scan = new Scanner(System.in);

    public void prompt() {
        System.out.println("Enter Number:");
        input = scan.nextLine();

        System.out.println("Convert from: \n1. Binary \n2. Decimal \n3. Octal \n4. Hex (use lowercase)");
        switch (scan.nextInt()) {
            case 1:
                num = binaryToDecimal(Integer.parseInt(input));
                break;
            case 2:
                num = Integer.parseInt(input);
                break;
            case 3:
                num = octalToDecimal(Integer.parseInt(input));
                break;
            case 4:
                num = hexToDecimal(input);
                break;

            default:
                System.out.println("Incorrect Input");
                System.exit(0);
        }

        System.out.println("Convert to: \n1. Binary \n2. Decimal \n3. Octal \n4. Hex (use lowercase)");
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

    public int hexToDecimal(String hexNum) {
        char curr = hexNum.charAt(hexNum.length() - 1);
        int currValue = -1;

        if (Character.isDigit(curr)) {
            currValue = curr - '0';
        } else {
            for (int i = 0; i < hexRef.length; i++) {
                if (curr == hexRef[i]) {
                    currValue = i + 10;
                }
            }
        }

        if (hexNum.length() == 1) {
            return currValue;
        }

        return hexToDecimal(hexNum.substring(0, hexNum.length() - 1)) * 16 + currValue;

    }

    public String decimalToHex(int num) {
        int curr = num % 16;
        char currValue;

        if (curr < 10) {
            currValue = (char) ('0' + curr);
        } else {
            currValue = hexRef[curr - 10];
        }

        if (num < 16) {
            return String.valueOf(currValue);
        }

        return decimalToHex(num / 16) + currValue;
    }

}
