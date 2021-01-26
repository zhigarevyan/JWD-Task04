package server.dao;

import java.io.*;

public class TextFileReader {
    private final String file;

    public TextFileReader(String file) {
        this.file = file;
    }


    public String readAll() {
        String textFromFile="";
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytesFromFile = inputStream.readAllBytes();
            textFromFile = new String(bytesFromFile);
        }catch (FileNotFoundException e){
            System.err.println("File not found while creating TextFileReader");
        }catch (IOException e) {
            System.err.println("Error while reading file");
        }
        return textFromFile;
    }
}
