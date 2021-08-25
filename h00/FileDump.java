/**
 * 
 */

package edu.ics211.h00;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * reads in a file from the console and converts the contents of the file into binary, hexadecimal, and UTF8.
 * 
 * @author Rei Yamamoto
 *
 */
public class FileDump {

  /**
   * runs the binary, hex, and utf method.
   * 
   * @param args reads in the name of the file from the command line.
   * @throws Exception if no file is found it throws an exception
   */
  public static void main(String[] args) throws Exception {
    String fileIn = args[0];
    binary(fileIn);
    hex(fileIn);
    utf(fileIn);
  }


  /**
   * converts the contents of the file into binary.
   * 
   * @param a reads in the file
   * @throws IOException throws an exception if the file is not found
   */
  public static void binary(String a) throws IOException {
    FileReader file = new FileReader(a);
    System.out.println("Binary contents of " + a + ":");
    while (file.ready()) {
      System.out.print(Integer.toBinaryString(file.read()) + " ");
    }
    System.out.println();
    System.out.println();
    file.close();
  }


  /**
   * converts the contents of the file to hexadecimal.
   * 
   * @param a reads the file
   * @throws IOException throws exception if there is no file found
   */
  public static void hex(String a) throws IOException {
    FileReader file = new FileReader(a);
    System.out.println("Hexadecimal contents of " + a + ":");
    while (file.ready()) {
      System.out.print(Integer.toHexString(file.read()) + " " + "");
    }
    System.out.println();
    System.out.println();
    file.close();
  }


  /**
   * converts the contents of the file to utf-8.
   * 
   * @param a reads the file
   * @throws IOException throws an exception if the file is not found
   */
  public static void utf(String a) throws IOException {
    FileReader file = new FileReader(a);
    System.out.println("UTF-8 contents of " + a + ";");
    byte[] bytes = Files.readAllBytes(new File(a).toPath());
    String text = new String(bytes, "UTF-8");
    System.out.print(text + " ");
    System.out.println();
    System.out.println();
    file.close();
  }
}
