/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RomaUlina
 */
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean isFile = false;
        Scanner scan = new Scanner(System.in);
        
        while(isFile == false){
            System.out.print("Enter File Name: ");
            String fileName = scan.nextLine().trim();
            File myFile = new File(fileName);
            try{
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                isFile = true;
            }catch(FileNotFoundException e){
                System.out.println("File is not exist.");
            }
        }  
    }  
}
