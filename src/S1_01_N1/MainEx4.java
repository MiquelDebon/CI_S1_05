package S1_01_N1;

import java.io.*;
import java.util.Scanner;

public class MainEx4 {
    static Scanner sc = new Scanner(System.in);
    static final String directoryToCheck = "/Users/miqueldebonvillagrasa/Desktop/42 barcelona.txt";
    public static void main(String[] args) {

        //Para que el usuario pueda introducir la dirección descomentar la linea de abajo
//        File file = getPath();
        File file = new File(directoryToCheck);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such path");
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    static File getPath(){
        File file;
        String directory;
        boolean rightDirectory = false;

        System.out.println("    💡 Write tha path of a txt File in your computer");
        do{
            System.out.print("✏️Please write the directory: ");
            directory = sc.nextLine();
            file = new File(directory);
            if(file.exists() ){
                System.out.println("✅Right directory");
                rightDirectory = true;
            }else{
                System.out.println("⚠️This directory does not exist");
            }
        }while(!rightDirectory);
        return  file;
    }
}
