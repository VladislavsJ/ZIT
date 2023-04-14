import java.util.ArrayList;

public class Huffman {

    public static void encoder(){

        // prototype code
        System.out.println("Huffman encoding......");

        // manipulate this data (copy, modify, delete), this is the data to compress
        Data.theData.add((byte)0);



        ArrayList<Leaf> leafs = new ArrayList<Leaf>();
        leafs = freqTable(); // return leaf table

        // then call tree maker and filetobinary
        System.out.println(leafs.get(0).frequency+":"+leafs.get(0).character);
    }

    public static void decoder(){

        // prototype code
        System.out.println("Huffman decoding......");
        Data.theData.add((byte)0);
    }

    public static ArrayList<Leaf> freqTable(){
        ArrayList<Leaf> leafs = new ArrayList<Leaf>();
        // prototype code
        Leaf leaf = new Leaf();
        leaf.character = 'D';
        leaf.frequency = 3;
        
        leafs.add(leaf);

        
        return leafs;
    }
}
