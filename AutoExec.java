import java.io.IOException;
import java.io.*;
import java.util.Scanner;

// creates automatically an executable .bash or .bat file
 public class AutoExec {
    public static String ForJAR;

    public static void main(String[] args) throws IOException {
        final char getBash = '1';
        final char getBat = '2';

        Scanner s = new Scanner(new BufferedInputStream(System.in));
        System.out.print(".jar Filename: ");
        ForJAR = s.nextLine();

        System.out.println("\nFor .bash{1} or .bat{2}");
        System.out.print(">>> ");

        char input = (char) System.in.read();

        try {
            if (input == getBash){
                CreateExec.createExecLinux();
            }
            if (input == getBat){
                CreateExec.createExecWindows();
            } else {
                System.out.println("Did not chose anything");
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        s.close();
    }
    public static class CreateExec {
       private static void createExecLinux(){
           String Linux = "!# /bin/bash/\njava -jar " + ForJAR + ".jar";

           File linuxBashFile = new File("start.sh");
           try {
                System.out.println("\n[Created] " + linuxBashFile.getName());
               if (linuxBashFile.createNewFile()) {
                    System.out.println(Linux);
                } else {
                    System.out.println("File already Exist");
                }
            } catch (IOException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
            try {
                FileWriter writeToFile = new FileWriter(linuxBashFile.getName(), true);
                writeToFile.write(Linux);
                System.out.println("Writing Complete");
                writeToFile.close();
            } catch (IOException e){
                System.out.println("Writing Error");
            }
        }
       private static void createExecWindows(){

            String Windows = "@echo off\njava -jar " + ForJAR + ".jar\npause";

            File windowsBatFile = new File("start.bat");
            System.out.println("\n[Created] " + windowsBatFile.getName());

            try {
                if (windowsBatFile.createNewFile()) {
                    System.out.println(Windows);
                } else {
                    System.out.println("File already Exist");
                }
            } catch (IOException er) {
                System.out.println("Writing Error");
                er.printStackTrace();
            }
            try {
                FileWriter writeToFile = new FileWriter(windowsBatFile.getName());
                writeToFile.write(Windows);
                System.out.println("Writing Complete");
                writeToFile.close();
            } catch (IOException er) {
                System.out.println("Writing Error");
            }
       }
    }
 }