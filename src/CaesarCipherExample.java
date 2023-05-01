// import required classes and package, if any
import java.util.Scanner;

// create class CaesarCipherExample for encryption and decryption
public class CaesarCipherExample
{
    // ALPHABET string denotes alphabet from a-z
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // create encryptData() method for encrypting user input string with given shift key
    public static String encryptData(String inputStr, int shiftKey)
    {
        // convert inputStr into lower case
        inputStr = inputStr.toLowerCase();

        // encryptStr to store encrypted data
        String encryptStr = "";

        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr.length(); i++)
        {
            if(inputStr.charAt(i)==' '){
                char encryptChar = inputStr.charAt(i);
                // add encrypted char to encrypted string
                encryptStr += encryptChar;
            }
            else{

                // get position of each character of inputStr in ALPHABET

                int pos = ALPHABET.indexOf(inputStr.charAt(i));

                // get encrypted char for each char of inputStr
                int encryptPos = (shiftKey + pos) % 26;
                char encryptChar = ALPHABET.charAt(encryptPos);

                // add encrypted char to encrypted string
                encryptStr += encryptChar;
            }
            // add encrypted char to encrypted string

        }

        // return encrypted string
        return encryptStr;
    }

    // create decryptData() method for decrypting user input string with given shift key
    public static String decryptData(String inputStr1, int shiftKey1)
    {
        // convert inputStr into lower case
        inputStr1 = inputStr1.toLowerCase();

        // decryptStr to store decrypted data
        String decryptStr = "";

        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr1.length(); i++)
        {
            if(inputStr1.charAt(i)==' '){
                char decryptChar = inputStr1.charAt(i);
                // add encrypted char to encrypted string
                decryptStr += decryptChar;
            }
            else{

                // get position of each character of inputStr in ALPHABET
                int pos = ALPHABET.indexOf(inputStr1.charAt(i));

                // get decrypted char for each char of inputStr
                int decryptPos = (pos - shiftKey1) % 26;

                // if decryptPos is negative
                if (decryptPos < 0){
                    decryptPos = ALPHABET.length() + decryptPos;
                }
                char decryptChar = ALPHABET.charAt(decryptPos);

                // add decrypted char to decrypted string
                decryptStr += decryptChar;
            }
        }
        // return decrypted string
        return decryptStr;
    }

    // main() method start
    public static void main(String[] args)
    {
        // create an instance of Scanner class
        Scanner sc = new Scanner(System.in);

        // take input from the user
        System.out.println("\n Enter a string for encryption using Caesar Cipher: ");
        String inputStr = sc.nextLine();

        System.out.println("\n Enter the value by which each character in the plaintext message gets shifted: ");
        int shiftKey = Integer.valueOf(sc.nextLine());


        System.out.println("\n Encrypted Data ===> "+encryptData(inputStr, shiftKey));


        System.out.println("\n Enter a string for decryption using Caesar Cipher: ");
        String inputStr1 = sc.nextLine();

        System.out.println("\n Enter the value by which each character in the plaintext message gets shifted: ");
        int shiftKey1 = Integer.valueOf(sc.nextLine());
        System.out.println("\n Decrypted Data ===> "+decryptData(inputStr1, shiftKey1));

        // close Scanner class object
        sc.close();
    }
}