package S1_01_N1;


import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MainEx3 {
    static Scanner sc = new Scanner(System.in);
    static final String directoryToCheck = "/Users/miqueldebonvillagrasa/Desktop";
    static final String directoryToWriteTXT = "/Users/miqueldebonvillagrasa/Desktop/OutputSummary.txt";
    public static void main(String[] args) {

//        File file = getPath();
        File file = new File(directoryToCheck);
        printResult(file);
    }


    static File getPath(){
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

    static void printResult (File file){
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
                    File[] childrenDirectory = writeTXTMethod(currentFile);
                    if(childrenDirectory != null){
                        for(File childrenFile : childrenDirectory){
                            writeTXTMethod(childrenFile);
                        }
                    }
                }
            }
        }else{
            System.out.println("💥There is no file");
        }
    }


    static File[] writeTXTMethod(File currentFile){
        File[] childrenFile = null;

        if(currentFile != null){
            Date date = new Date(currentFile.lastModified());
            try {
                FileWriter writeFile = new FileWriter(directoryToWriteTXT, true);
                PrintWriter printWriter = new PrintWriter(writeFile);
                if (currentFile.isDirectory()) {
                    printWriter.println("\n🗂️ DIRECTORY " + currentFile.getName() + " LAST MODIFICATION ⏰: " +date );
                    childrenFile = currentFile.listFiles();
                } else if (currentFile.isFile()) {
                    printWriter.println("\n📈 File " + currentFile.getName() + " LAST MODIFICATION ⏰: " +date );
                } else if (currentFile.isHidden()) {
                    printWriter.println("\nIs hidden" + " LAST MODIFICATION ⏰: "  +date );
                }
                printWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return childrenFile;
    }
}


