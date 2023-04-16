package S1_01_N1;


import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MainEx1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File file;
        String directory;
        boolean rightDirectory = false;
        String[] filesList;

        System.out.println("    💡You also can copy:   /Users/miqueldebonvillagrasa/Desktop");
        do{
            System.out.print("✏️Please write the directory: ");
            directory = sc.nextLine();
            file = new File(directory);
            filesList = file.list();
            if(file.exists() ){
                System.out.println("✅Right directory");
                rightDirectory = true;
            }else{
                System.out.println("⚠️This directory does not exist");
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
            System.out.println("💥There is no file");
        }

    }
}
