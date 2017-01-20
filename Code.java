/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.*;
import java.io.*;

/**
 *
 * @author Gary Deng
 */
public class Code extends Encryption{

    static String data = "";
    static Scanner dataFile;
    static String encryptedData = "";
    static int[] a1z26Data;
    static int read = 0;
    static int code = 0;
    static int caesarKey = 0;

    public static void init() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Secret Message Program");
        System.out.println("==============================================");
        System.out.println("Select a cipher");
        System.out.println("1. Atbash");
        System.out.println("2. Caesar");
        System.out.println("3. a1z26");
        code = scan.nextInt();
        if (code == 2) {
            System.out.println("enter key");
            caesarKey = scan.nextInt();
        }
        if ((code == 1) || (code == 2) || (code == 3)) {
            System.out.println("Enter 0 to enter string or 1 to read file");
            read = scan.nextInt();
            String g = scan.nextLine();
            if (read == 0) {
                System.out.println("Enter a String");
                String r = scan.nextLine();
                data = r;
            } else if (read == 1) {
                System.out.println("enter a file name");
                String docname = scan.next();

                try {
                    File file = new File(docname + ".txt");
                    dataFile = new Scanner(file);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("enter 0 or 1");
            }
        } else {
            System.out.println("Invalid Choice");
        }
    }

    public static void encryptAtbash() {
        if (read == 0) {
            char[] dataChar = data.toLowerCase().toCharArray();
            for (int i = 0; i < dataChar.length; i++) {
                encryptedData += Atbash(dataChar[i]);
            }
        }
        if (read == 1) {
            data = dataFile.nextLine();
            char[] dataChar = data.toLowerCase().toCharArray();
            for (int i = 0; i < dataChar.length; i++) {
                encryptedData += Atbash(dataChar[i]);

            }

        }
    }

    public static void encryptCaesar() {
        if (read == 0) {
            char[] dataChar = data.toLowerCase().toCharArray();
            for (int i = 0; i < dataChar.length; i++) {
                encryptedData += Caesar(dataChar[i], caesarKey);
            }
        }
        if (read == 1) {
            data = dataFile.nextLine();
            char[] dataChar = data.toLowerCase().toCharArray();
            for (int i = 0; i < dataChar.length; i++) {
                encryptedData += Caesar(dataChar[i], caesarKey);

            }

        }
    }

    public static void encryptA1Z26() {
        a1z26Data = new int[data.length()];
        if (read == 0) {
            char[] dataChar = data.toLowerCase().toCharArray();
            for (int i = 0; i < dataChar.length; i++) {

                encryptedData += a1z26(dataChar[i]);

                if (i < dataChar.length - 1 && dataChar[i+1] != ' ' && dataChar[i] != ' ') {
                    encryptedData += "-";
                }
                else {
                        encryptedData += "";
                    }
                }

            
        }
        if (read == 1) {
            data = dataFile.nextLine();
            char[] dataChar = data.toLowerCase().toCharArray();
            for (int i = 0; i < dataChar.length; i++) {
                
                    encryptedData += a1z26(dataChar[i]);
                
                if (i < dataChar.length - 1 && dataChar[i+1] == ' ') {
                    encryptedData += "-";
                    
                }
                

            }
        }
    }

    public static void main(String[] args) {
        init();
        switch (code) {
            case (1):
                encryptAtbash();
                System.out.println("String Entered: " + data);
                System.out.println("Encrypted Message: " + encryptedData);
                break;
            case (2):
                encryptCaesar();
                System.out.println("String Entered: " + data);
                System.out.println("Encrypted Message: " + encryptedData);
                break;
            case (3):
                encryptA1Z26();
                
                
                System.out.println("String Entered: " + data);

                System.out.print("Encrypted Message: ");

                System.out.print(encryptedData);

                System.out.println();
                break;
            default:

        }

        System.out.println("==============================================");
    }

}
