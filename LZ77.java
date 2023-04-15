//import java.util.ArrayList;

public class LZ77 {
    public static class Triplet{
        byte first=0;
        byte second=0;
        char next='A';
    }

    public static void encoder(){
        // Read Data.theData and either:
        // create a new data object
        // or overwrite a existing Data
        // Idk what is better honestly, but think what makes more sense and do that

        // and then insert compressed data in the Data

        // u can use:
        // parseInt("001001", 2) | parseInt(x, base)
        // for writing bit by bit

        // dont hesitate to ask questions or make remarks or ask for help




        // prototype code
        System.out.println("LZ77 encoding......");





        // shell for window
        char[] searchBuf = {'B','A','N'};
        char[] lookAhead = {'A','N','A', 'F'};
        Triplet tmp = new Triplet();
        tmp = window(searchBuf,lookAhead);
        System.out.println("first byte is: "+tmp.first);
        
    }

    public static void decoder(){

        // prototype code
        System.out.println("LZ77 decoding......");
    }

    public static Triplet window(char[] searchBuf,char[] lookAhead){
        // take 2 arrays (talk with Kostya how big they are)
        // make triplets (number1, number2, character) where number1 is the jump back length,
        // number2 is the length of the occurrence and character is the next letter after occurance
        // this is the standard LZ77 sliding window mechanic
        
        // keep in mind that position has more bits then the length
        // we encode position and length with 2 bytes (16bits)
        // where 12 bits are allocated for position and only 4 bits for length

        // u can use:
        // parseInt("001001", 2) | parseInt(x, base)
        // for writing bit by bit

        // dont hesitate to ask questions or make remarks or ask for help



        // prototype code
        Triplet trip = new Triplet();
        trip.first = 3;
        trip.second = 4;
        trip.next = 'E';
        return trip;
    }
}
