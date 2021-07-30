// #!/usr/bin/java --source 12


import java.io.FileWriter;
import java.io.IOException;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Iofiletest {
    public static void main(String[] args) {
        // try ... catch exception ...
        try {
            FileWriter myFileWriter = new FileWriter("example.txt", true);
            myFileWriter.write("Hello world\n");
            myFileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        
        // try
        try {
            File myFile = new File("example.txt");
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                System.out.println(line);
            }
            myScanner.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    } // main
}

