import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Huffman {
    public static void encoder(FileWriter out){
        ArrayList<Leaf> leafs = new ArrayList<Leaf>();
        leafs = freqTable(); // return leaf table
        Node tree = treeMaker(leafs);
        fileToBinary((Branch)tree,out); // return binary file
        
    }
    //used variables in many places
    public static int bitBuffer[]= new int[8];
    public static int bitBufferLength=0;
    public static byte bitBuffer1=0;
    public static boolean BufferFileEnd=false;
    public static int totalChcount=33;//:TODO Insert Count of characters here!!

    public static void decoder(FileReader input , ArrayList<Character> theDataHuffman){
        //My idea is that I will insert in the output all chars probabilites
        // and then I will use the probabilites to create a tree, when this code will be maded
        // and then I will use the tree to decode the input
        //test tree
        ArrayList<Leaf> leaftest = new ArrayList<Leaf>();
        Leaf leaf = new Leaf(); leaf.character = 'D'; leaf.frequency = 3;
        leaftest.add(leaf);//0D
        leaf = new Leaf();
        leaf.character = 'G';
        leaf.frequency = 2;
        leaftest.add(leaf);//1G
        leaf = new Leaf();
        leaf.character = 'R';
        leaf.frequency = 7;
        leaftest.add(leaf);//2R
        leaf = new Leaf();
        leaf.character = 'Z';
        leaf.frequency = 1;
        leaftest.add(leaf);//3Z
        leaf = new Leaf();
        leaf.character = 'T';
        leaf.frequency = 1;
        leaftest.add(leaf);//4T
        leaf = new Leaf();
        leaf.character = 'O';
        leaf.frequency = 1;
        leaftest.add(leaf);//5O
        Branch root = new Branch();
        Branch ZT= new Branch();
        ZT.left = leaftest.get(3);
        ZT.right = leaftest.get(4);
        Branch D_Bzt= new Branch();
        D_Bzt.left= leaftest.get(0);
        D_Bzt.right = ZT;
        Branch GO = new Branch();
        GO.left = leaftest.get(1);
        GO.right = leaftest.get(5);
        Branch R_Bgo= new Branch();
        R_Bgo.left = leaftest.get(2);
        R_Bgo.right = GO;
        root.left = R_Bgo;
        root.right = D_Bzt;
        //flush the data, if it is not empty from encoder
        bitBuffer1=0;
        bitBufferLength=0;
        //
        char c=0;
        while(!BufferFileEnd && (--totalChcount >0)){
            c=FindCharacterInTree(root, input);
            System.out.print(c);
            
                theDataHuffman.add(c);
                //System.out.println(c);

            }

        
        // prototype code
        System.out.println();
        System.out.println("Decoder empty......");
    }

    public static ArrayList<Leaf> freqTable(){ 
        ArrayList<Leaf> leafs = new ArrayList<>(); 
        HashMap<Character, Integer> frequencyMap = new HashMap<>(); 
        for (char c : Data.theData){ 
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1); 
        } 
        for (char c : frequencyMap.keySet()) { 
            Leaf leaf = new Leaf(); 
            leaf.character = c; 
            leaf.frequency = frequencyMap.get(c); 
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
        leafz.add(leaf);//0D
        leaf = new Leaf();
        leaf.character = 'G';
        leaf.frequency = 2;
        leafz.add(leaf);//1G
        leaf = new Leaf();
        leaf.character = 'R';
        leaf.frequency = 7;
        leafz.add(leaf);//2R
        leaf = new Leaf();
        leaf.character = 'Z';
        leaf.frequency = 1;
        leafz.add(leaf);//3Z
        leaf = new Leaf();
        leaf.character = 'T';
        leaf.frequency = 1;
        leafz.add(leaf);//4T
        leaf = new Leaf();
        leaf.character = 'O';
        leaf.frequency = 1;
        leafz.add(leaf);//5O


        Branch root = new Branch();
        Branch ZT= new Branch();
        ZT.left = leafz.get(3);
        ZT.right = leafz.get(4);
        Branch D_Bzt= new Branch();
        D_Bzt.left= leafz.get(0);
        D_Bzt.right = ZT;
        Branch GO = new Branch();
        GO.left = leafz.get(1);
        GO.right = leafz.get(5);
        Branch R_Bgo= new Branch();
        R_Bgo.left = leafz.get(2);
        R_Bgo.right = GO;
        root.left = R_Bgo;
        root.right = D_Bzt;
        return root;

    }
    public static Node fileToBinary(Branch tree,FileWriter out){
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
        
        String test = "ZZRRRRRGGGGGOOOOOTTTTTDDDDDDRRRO";
        try {
        for(int i=0;i<test.length();i++){
            writeBits(FindCharacter(tree, test.charAt(i)),out);  
            //FindCharacter as "11212" and insert these bits
            //in bitBuffer1, If bitbuffer ==8 it will write it to the file
            // if string ended and bitbuffer1 is not empty, it will write it to the file as "111" <<5 11100000
            //:TODO: I need to count totalChcount before writing to file, I need to know how many bits to write
            //I think to make it in freqency table

            }
            if (bitBuffer1!=-1){
                int totalbits = (int)((Math.log(bitBuffer1)+0.5)/(float)Math.log(2));
                out.write((char)(bitBuffer1<< 8-totalbits));
        }
        out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("fileToBinary not erroring out");
        return tree;//IDK what to return there
    }
    
    public static int FindCharacter(Branch tree, char c){
        //recursion, untli not found in tree, If not exist it not checked
        //1 is 0 , and 2 is 1, return path in inverse order
        //if 'D' path is 111000, it will return 111222, 
        int C_Founded=0;
        if (tree.left instanceof Leaf){
            if(((Leaf) tree.left).character==c)
                return 1;
            else if (tree.right instanceof Leaf){
                if(((Leaf) tree.right).character==c)
                    return 2;
                    else return -1;
            }
            else {
                //System.out.println("right is branch");
                C_Founded = FindCharacter((Branch) tree.right, c);
                if(C_Founded==-1)
                    return -1;
                else return C_Founded*10+2;
            }
        }
        else{
            C_Founded = FindCharacter((Branch) tree.left, c);
            if(C_Founded==-1)
                    return FindCharacter((Branch) tree.right, c)*10+2;
                else return C_Founded*10+1;
        }
    
}
public static char FindCharacterInTree(Branch tree,FileReader Input){
    int bit;
    while(true){//IF everything is working correctly, this will not loop forever
        bit = BitFromBuffer(Input);
        if (bit ==0){
            if (tree.left instanceof Leaf){
                return (char)((Leaf) tree.left).character;
            }
            else{
                tree = (Branch) tree.left;
            }
        }
        else if (bit ==1){
            if (tree.right instanceof Leaf){
                return (char)((Leaf) tree.right).character;
            }
            else{
                tree = (Branch) tree.right;
            }
        }
        else{//if bit is -1
            System.out.println("End of the file");
            return ' ';
        }
    }


}
public static int BitFromBuffer(FileReader Input) {
    int bit=0;
    //read next byte if bitBufferLength ==0,
    // and get first bit from bitBuffer1
    // and shift bitBuffer1 to the left
    //"00011" <<"00110" << "01100" << "11000"
    try {
        if(bitBufferLength==0){
            bitBuffer1=(byte)Input.read();
            bitBufferLength=8;
        }
        bitBufferLength--;
        bit=(bitBuffer1 >> 7) & 1;
        bitBuffer1<<=1;
            return bit;
        
    } catch (Exception e) {
        System.out.println(e);
        BufferFileEnd=true;
        return -1;
    }
}

public static void writeBits(int bits,FileWriter out) throws IOException 
{//there 2 is 1, and 1 is 0;
    // inverse order, Used with FindCharacter which give inversed order
    while(bits>0){
    int lastBit = (bits % 10)-1; // extract the last digit and-1, 2=1, 1=0
    bits /= 10;               // remove the last digit from the number
    bitBuffer1<<=1;
    bitBuffer1|=lastBit;
    if (++bitBufferLength == 8) {  // if the buffer is full write to file
        out.write((char)bitBuffer1);

        bitBufferLength = 0;  // reset the buffer Lenght
        bitBuffer1=-1;// reset the buffer
        }
        
    }
}
    


}
