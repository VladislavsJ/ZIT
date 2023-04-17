import java.util.ArrayList;

public class Huffman {

    public static void encoder(){
        ArrayList<Leaf> leafs = new ArrayList<Leaf>();
        leafs = freqTable(); // return leaf table
        Node tree = treeMaker(leafs);
        fileToBinary(tree); // doesnt return anything just creates a Data to write
        
    }

    public static void decoder(){

        // prototype code
        System.out.println("Decoder empty......");
    }

    public static ArrayList<Leaf> freqTable(){
        ArrayList<Leaf> leafs = new ArrayList<Leaf>();

        // Data.theData consists of an array of characters.
        // They represent chars (using ascii table) that are in the file.
        // So the letter B would be number 66 in Data.theData array.
        // Create an arrayList of leafs which represent table of 
        // frequencies for Huffman coder.
        // dont hesitate to ask questions or make remarks or ask for help
        
        Leaf leaf = new Leaf();
        for (char c : Data.theData){
            leaf.character == c;
            leaf.frequency = 1;
            for(char ch : Data.theData){
                if (ch = leaf.character) {
                  leaf.frequency++;
                }
            }
            leafs.add(leaf);
        }
        return leafs;
    }

    public static Node treeMaker(ArrayList<Leaf> leafs){
        // for starters look at pseudo codes on the web to double check the logic

        // pick nodes with the smallest frequency
        // Create branch to hold them and 
        // pop them out of an array | mark them as dealt with and dont look at them again
        // or smth else, but think of another good method
        // iterate over the array again until u have only one node left


        // placeholder code
        ArrayList<Leaf> leafz = new ArrayList<Leaf>();
        Leaf leaf = new Leaf();
        leaf.character = 'D';
        leaf.frequency = 3;
        leafz.add(leaf);
        leaf.character = 'G';
        leaf.frequency = 2;
        leafz.add(leaf);
        leaf.character = 'R';
        leaf.frequency = 7;
        leafz.add(leaf);

        Branch root = new Branch();
        Branch second = new Branch();
        root.left = leafz.get(2);
        root.right = second;
        second.left = leafz.get(0);
        second.left = leafz.get(1);

        return root;
    }

    public static Node fileToBinary(Node tree){
        // Notes on what to actually do:
        // u get a tree and u have to either:
        // create a new data object
        // or overwrite a existing Data
        // Idk what is better honestly, but think what makes more sense and do that

        // and then insert compressed data in the Data

        // u can use:
        // parseInt("001001", 2) | parseInt(x, base)
        // for writing bit by bit
        
        // dont forget to insert the tree itself not just the compressed data

        // dont hesitate to ask questions or make remarks or ask for help

        
        Node n = new Node();
        System.out.println("fileToBinary not erroring out");
        return n;
    }
}
