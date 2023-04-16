package S1_01_N1;

import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MainEx1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File file;
        String directory;
        boolean rightDirectory = false;
        String[] filesList;

        //"/Users/miqueldebonvillagrasa/Desktop"

        do{
            System.out.println("    💡You also can copy:   /Users/miqueldebonvillagrasa/Desktop");
            System.out.print("✏️Please write the directory: ");
            directory = sc.nextLine();
            file = new File(directory);
            filesList = file.list();
            if(file.exists() ){
                rightDirectory = true;
            }
        }while(!rightDirectory);

        if(filesList.length > 0){
            Arrays.sort(filesList);
            for(int i=0; i<filesList.length; i++){
                if(filesList[i].charAt(0) == '.'){ //Skip hidden files
                }else{
                    System.out.println(filesList[i]);
                }
            }
        }else{
            System.out.println("There is no file");
        }

    }
}
