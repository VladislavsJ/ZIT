// Grupas nosaukums: ZIT

// Grupas dalībnieki:
// Ņina Aļjanaki 12. gr. 221RDB018
// Konstantīns Siņica 12. gr. 151RMC125
// Vasīlijs Dvils-Dmitrijevs 12. gr. 221RDB021
// Kirils Bedins 18. gr. 221RDC018
// Vladislavs Jacina 12. gr. 221RDB038
// Ņikita Plotņikovs 12. gr. 221RDB021 (Grupas vadītājs)


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//import java.util.ArrayList;


public class Zit {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choiseStr;
		String sourceFile, resultFile, firstFile, secondFile;

		int terminationCounter = 0;
		loop: while (true) {
			
			choiseStr = sc.next();
								
			switch (choiseStr) {
        case "comp":
          System.out.print("source file name: ");
          sourceFile = sc.next();
          System.out.print("archive name: ");
          resultFile = sc.next();
          comp(sourceFile, resultFile);
          break;
        case "decomp":
          System.out.print("archive name: ");
          sourceFile = sc.next();
          System.out.print("file name: ");
          resultFile = sc.next();
          decomp(sourceFile, resultFile);
          break;
        case "size":
          System.out.print("file name: ");
          sourceFile = sc.next();
          size(sourceFile);
          break;
        case "equal":
          System.out.print("first file name: ");
          firstFile = sc.next();
          System.out.print("second file name: ");
          secondFile = sc.next();
          System.out.println(equal(firstFile, secondFile));
          break;
        case "about":
          about();
          break;
        case "exit":
          break loop;
        default:
          terminationCounter+=1;
          switch (terminationCounter) {
            case 6:
              System.out.println("This command doesn't exist. 1 more attempt or the program will exit.");
            case 7:
              break loop;
            default:
              System.out.println("This command doesn't exist. Try again.");
          }
			}
		}

		sc.close();
	}




  // TODO:
  //// make data be passed not as an argument but as a global var
  //// write shell for freqTable
  // Check for if the source file exists




  public static void readFile(String sourceFile){
    // prototype code
    System.out.println("reading......");
    Data.theData.add((byte)0);
  }

  public static void writeFile(String resultFile){
    // prototype code
    System.out.println("writing......");
    System.out.println(Data.theData);
  }

	public static void comp(String sourceFile, String resultFile) {
    readFile(sourceFile);

    LZ77.encoder();
    Huffman.encoder();

    writeFile(resultFile);

    
	}

	public static void decomp(String sourceFile, String resultFile) {
    readFile(sourceFile);
    
    Huffman.decoder();
    LZ77.decoder();

    writeFile(resultFile);
	}
	






	public static void size(String sourceFile) {
		try {
			FileInputStream f = new FileInputStream(sourceFile);
			System.out.println("size: " + f.available());
			f.close();
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static boolean equal(String firstFile, String secondFile) {
		try {
			FileInputStream f1 = new FileInputStream(firstFile);
			FileInputStream f2 = new FileInputStream(secondFile);
			int k1, k2;
			byte[] buf1 = new byte[1000];
			byte[] buf2 = new byte[1000];
			do {
				k1 = f1.read(buf1);
				k2 = f2.read(buf2);
				if (k1 != k2) {
					f1.close();
					f2.close();
					return false;
				}
				for (int i=0; i<k1; i++) {
					if (buf1[i] != buf2[i]) {
						f1.close();
						f2.close();
						return false;
					}
						
				}
			} while (k1 == 0 && k2 == 0);
			f1.close();
			f2.close();
			return true;
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public static void about() {
    System.out.println("Grupas nosaukums: ZIT");
		System.out.println("");
    System.out.println("Grupas dalībnieki:");
		System.out.println("Ņina Aļjanaki 12. gr. 221RDB018");
    System.out.println("Konstantīns Siņica 12. gr. 151RMC125");
		System.out.println("Vasīlijs Dvils-Dmitrijevs 12. gr. 221RDB021");
    System.out.println("Kirils Bedins 18. gr. 221RDC018");
		System.out.println("Vladislavs Jacina 12. gr. 221RDB038");
    System.out.println("Ņikita Plotņikovs 12. gr. 221RDB021 (Grupas vadītājs)");
	}
}

