// ****************************************************************
// CountLetters.java
//
// Reads a words from the standard input and prints the number of 
// occurrences of each letter in that word.
//          
// ****************************************************************
import java.util.Scanner;
public class CountLetters{
    static char NotChar;
    public static void main(String[] args){
    int[] counts = new int[26]; 
    
    Scanner scan = new Scanner(System.in); 

    //get word from user 
    System.out.print("Enter a single word (letters only, please): "); 
    String word = scan.nextLine(); 

    //convert to all upper case 
    word = word.toUpperCase(); 
    
    try{
        //count frequency of each letter in string 
        for (int i=0; i < word.length(); i++){ 
            NotChar = word.charAt(i);
            counts[word.charAt(i)-'A']++; 
        }
    }catch(ArrayIndexOutOfBoundsException Exception){
        if (NotChar != ' '){
           System.out.println("'"+NotChar + "' Is not a letter\n");
        }
    }
    
    //print frequencies
    System.out.println();
    for (int i=0; i < counts.length; i++) 
        if (counts [i] != 0) 
            System.out.println((char)(i +'A') + ": " + counts[i]); 
    } 
} 