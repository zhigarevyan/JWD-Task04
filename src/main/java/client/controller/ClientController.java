package client.controller;

import entity.TextElement;
import entity.impl.Word;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private static ObjectInputStream objectInputStream;
    private static ObjectOutputStream objectOutputStream;
    private final BufferedReader inputReader;

    public ClientController() {
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start(Socket clientSocket) {
        try {

            objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            Object[] response = {"0"};

            while(!response[0].equals("17")) {
                System.out.println(getMessage());
                response = readFromKeyboard();
                sendMessage(response);

                Thread.sleep(1000);

                TextElement text = getTextFromServer();

                System.out.println(text.value());

                Thread.sleep(1000);
            }

        }
        catch (IOException e) {
            System.err.println("IOException at Client level");
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            System.err.println("InterruptedException at Client level");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException at Client level");
            e.printStackTrace();
        }
        finally {
            try {
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getMessage() throws IOException {
        return objectInputStream.readUTF();
    }

    public void sendMessage(Object[] message) throws IOException {
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
    }

    public Object[] readFromKeyboard() throws IOException {
        String input = inputReader.readLine();
        String paramInput;
        Object[] returnArr = new Object[]{input};

        switch (input) {
            case "4", "8", "11", "12" -> {
                System.out.println("write param");
                paramInput = inputReader.readLine();
                returnArr = new Object[]{input, paramInput};
            }
            case "10", "14" -> {
                System.out.println("write params");
                paramInput = inputReader.readLine();
                returnArr = new Object[]{input, paramInput.split(" ")};
            }
            case "9" -> {
                System.out.println("write list of words");
                paramInput = inputReader.readLine();
                List<Word> wordList = new ArrayList<>();
                for (String string : paramInput.split(" ")) {
                    wordList.add(new Word(string));
                }
                returnArr = new Object[]{input, wordList};
            }
        }
        return  returnArr;
    }


    public TextElement getTextFromServer() throws IOException, ClassNotFoundException {
        return (TextElement) objectInputStream.readObject();
    }

 }

