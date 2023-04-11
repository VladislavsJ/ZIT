//import java.io.*;

public class Zit {
    public static void main(String [] args) {
    if (args.length < 2) {
      System.err.println("Usage: Deflate [c|d] <filename>"); // compress or decompress
      System.exit(1);
    }

    try {
      //openFile(args[1]);
      System.out.println("opening file...");
      
    }  /*
    catch (FileNotFoundException f) {
      System.err.println("File not found: "+args[0]);
    } catch (IOException e) {
      System.err.println("Problem processing file: "+args[0]);
    }
    */ finally {}

    if (args[0].indexOf('d') != -1) {
      //unCompress(args[1]);
      System.out.println("decompressing...");
    } else {
      //compress(args[1]);
      System.out.println("compressing...");
    }
  }
}