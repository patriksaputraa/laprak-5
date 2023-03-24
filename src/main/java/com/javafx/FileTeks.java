package com.javafx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTeks {
    private String file_name;
    FileTeks(String file){
        this.file_name = file;
    }

    public void write(String text) throws IOException{
        // FileReader fileInput = new FileReader(file_name);
        // BufferedReader bufferInput = new BufferedReader(fileInput);
        // BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        try {
            FileWriter fileOutput = new FileWriter(file_name);//delete append
            fileOutput.write(text);
            fileOutput.close();
            // bufferOutput.write(text);
            // bufferOutput.newLine();
            // bufferOutput.flush();
        } catch (IOException e) {
            System.err.println("An error occured. " + e.getMessage());
            e.printStackTrace();
        }
        // bufferOutput.close();
        // bufferInput.close();
    }

    public String[] read() throws IOException{
        String result = "";
        try {
            File file = new File(file_name);
            Scanner fileReader = new Scanner(file);
            //BufferedReader bufferInput = new BufferedReader(file);
            //String data = fileReader.nextLine();
            while(fileReader.hasNextLine()){
                result += fileReader.nextLine() + "\n";
                //data = fileReader.nextLine();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("An error occured. " + e.getMessage());
            e.printStackTrace();
        }
        return result.split("\n");
    }

    public String getFileName(){
        return file_name;
    }
    public void setFileName(String newFileName){
        this.file_name = newFileName;
    }
}