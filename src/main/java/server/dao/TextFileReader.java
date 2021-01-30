package server.dao;

import server.dao.exception.DAOException;

import java.io.*;

public class TextFileReader {
    private final String file;

    public TextFileReader(String file) {
        this.file = file;
    }


    public String readAll() throws DAOException {
        String textFromFile="";
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytesFromFile = inputStream.readAllBytes();
            textFromFile = new String(bytesFromFile);
        }catch (FileNotFoundException e){
            throw new DAOException("File not found while creating TextFileReader");
            //System.err.println("File not found while creating TextFileReader");
        }catch (IOException e) {
            throw new DAOException("Error while reading file");
            //System.err.println("Error while reading file");
        }
        return textFromFile;
    }
}
