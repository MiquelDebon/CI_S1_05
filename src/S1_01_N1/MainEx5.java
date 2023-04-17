package S1_01_N1;

import javax.management.ObjectName;
import java.io.*;
import java.util.Scanner;

public class MainEx5 {
    static Scanner sc = new Scanner(System.in);
    static final int SIZEFILE = 520;

    public static void main(String[] args) {

        ME_CarClass car = new ME_CarClass("MiCoche", 200);
        final String pathFile = "src/S1_01_N1/OutputJavaFile.ser";

        serializarObjecto(car, pathFile);
        File file = new File(pathFile);
        ME_CarClass carOutput = (ME_CarClass) deSseritzarFile(pathFile);
        System.out.println("Name of the car '" + carOutput.getNameCar() + "'");

//        //JUST TO HAVE FUN
//        final String pathJavaFile = "src/S1_01_N1/ME_CarClass.java";
//        int[] serializeFile = new int[SIZEFILE];
//        File file = new File(pathJavaFile);
//        serializeFile = serializeFile(file);
//        unSerializeFile(serializeFile, pathOutFile);

    }

    static void serializarObjecto(Object obj, String outPath){
        try {
            FileOutputStream newFile = new FileOutputStream(outPath);
            ObjectOutputStream out =  new ObjectOutputStream(newFile);//This class provides methods for writing Java objects to a file.
            out.writeObject(obj);
            newFile.close();
            out.close();
        } catch (IOException e) {
            System.out.println("An error occur");
        }
    }

    static Object deSseritzarFile(String inPath){
        ME_CarClass carOutput = null;
        try {
            FileInputStream fileIn = new FileInputStream(inPath);
            ObjectInputStream inputStream = new ObjectInputStream(fileIn);
            carOutput = (ME_CarClass) inputStream.readObject();

            fileIn.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("There is no such File");
        }
        return carOutput;
    }

    // ---------------JUST TO HAVE FUN --------------------


    static int[] serializeFile(File file){
        //Check the size of the file by get info from the Java file (460 bytes)
        int[] serializeFile = new int[SIZEFILE];

        try {
            boolean exit = false;
            FileInputStream fileInputStream = new FileInputStream(file);
            int index = 0;

            while(!exit){
                int byteEntrada = fileInputStream.read();

                if(byteEntrada != -1){
                    serializeFile[index++] = byteEntrada;
                }else{
                    exit = true;
                }
            }
//            System.out.println("Total" + index); To check the size of the file
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("There is no such File");
        } catch (IOException e) {
            System.out.println("An error occur");
        }
        return serializeFile;
    }


    static void unSerializeFile(int[] file, String outputPath){
        try {
            FileOutputStream newFile = new FileOutputStream(outputPath);
            for(int i=0; i<file.length; i++){
                newFile.write(file[i]);
            }
            newFile.close();
        } catch (IOException e) {
            System.out.println("An error occur");
        }
    }





}
