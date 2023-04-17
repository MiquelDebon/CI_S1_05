package S1_01_N2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class Main {
    static Properties propiedades = new Properties();
    public static void main(String[] args) {
        String directoryToCheck = getDirectoryToCheck();
        String directoryToWrite = getDirectoryToWrite();

        File file = new File(directoryToCheck);
        loopDirectoryFile(file, directoryToWrite);
    }
    static String getDirectoryToCheck(){
        InputStream entrada = null;
        String output = "";
        try{
            entrada = new FileInputStream("src/S1_01_N2/datos.properties");
            propiedades.load(entrada); //To read the file
            output = propiedades.getProperty("directorioToCheck");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return output;
    }

    static String getDirectoryToWrite(){
        InputStream entrada = null;
        String output = "";
        try{
            entrada = new FileInputStream("src/S1_01_N2/datos.properties");
            propiedades.load(entrada); //To read the file
            output = propiedades.getProperty("directorioToWriteTXT");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return output;
    }


    static void loopDirectoryFile(File file, String directoryToWriteTXT){
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
                    writeTXTMethod(currentFile, directoryToWriteTXT);
                }
            }
        }else{
            System.out.println("💥There is no file");
        }
    }


    static void writeTXTMethod(File currentFile, String directoryToWriteTXT){
        File[] childrenFile = null;

        if(currentFile != null){
            Date date = new Date(currentFile.lastModified());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm");
            String simpleDate = simpleDateFormat.format(date);
            try {
                FileWriter writeFile = new FileWriter(directoryToWriteTXT, true);
                PrintWriter printWriter = new PrintWriter(writeFile);
                if (currentFile.isDirectory()) {
                    printWriter.println("\n🗂️ DIRECTORY " + currentFile.getName() + " LAST MODIFICATION ⏰: " +date );
                    childrenFile = currentFile.listFiles();
                    if(childrenFile != null){
                        for(File c : childrenFile){
                            writeTXTMethod(c, directoryToWriteTXT);
                        }
                    }
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
    }

}
