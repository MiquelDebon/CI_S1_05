package S1_01_N1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MainEx2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

//        File file = getPath();
        File file = new File("/Users/miqueldebonvillagrasa/Desktop");
        loopDirectoryFile(file);

    }


    static File getFileByPath(){
        File file;
        String directory;
        boolean rightDirectory = false;

        System.out.println("    💡You also can copy:   /Users/miqueldebonvillagrasa/Desktop");
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

    static void loopDirectoryFile(File file){
        String[] filesList = file.list();
        String directory = file.getPath();

        if(filesList.length > 0){
            Arrays.sort(filesList);
            for(int i=0; i<filesList.length; i++){
                if(filesList[i].charAt(0) == '.'){
                    //Skip rare Files from Apple
                }else {
                    String newpath = directory + "/" + filesList[i];
                    File currentFile = new File(newpath);
                    printFile(currentFile);
                }
            }
        }else{
            System.out.println("💥There is no file");
        }
    }


    static void printFile(File currentFile){
        File[] childrenFile = null;
        if(currentFile != null){
            Date date = new Date(currentFile.lastModified());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm");
            String simpleDate = simpleDateFormat.format(date);

            if (currentFile.isDirectory()) {
                System.out.println("🗂️ DIRECTORY " + currentFile.getName() + " LAST MODIFICATION - ⏰" + simpleDate );
                childrenFile = currentFile.listFiles();
                if(childrenFile != null){
                    for(File c : childrenFile){
                        printFile(c);
                    }
                }
            } else if (currentFile.isFile()) {
                System.out.println("📈 File " + currentFile.getName() + " LAST MODIFICATION - ⏰" + simpleDate );
            } else if (currentFile.isHidden()) {
                System.out.println("Is hidden" + " LAST MODIFICATION - ⏰"  + simpleDate );
            }
        }
    }
}


