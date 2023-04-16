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
        boolean rightDirectory;
        String[] filesList;

        //"/Users/miqueldebonvillagrasa/Desktop"

        do{
            System.out.println("    💡You also can copy:   /Users/miqueldebonvillagrasa/Desktop");
            System.out.print("✏️Please write the directory: ");
            directory = sc.nextLine();
            file = new File(directory);
            filesList = file.list();
            rightDirectory = filesList.length > 0 ;
        }while(!rightDirectory);

        Arrays.sort(filesList);
        for(int i=0; i<filesList.length; i++){
            if(filesList[i].charAt(0) == '.'){ //Skip hidden files
            }else{
                System.out.println(filesList[i]);
            }
        }
    }
}
