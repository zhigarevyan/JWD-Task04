package server.controller;

import entity.impl.Word;
import server.MessageGenerator;
import server.service.TextService;
import server.service.TextServiceProvider;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerController {
    private boolean process = true;

    private static ObjectInputStream requestStream;
    private static ObjectOutputStream responseStream;

    private final TextService textService = TextServiceProvider.getTextService();
    private final MessageGenerator messageGenerator = MessageGenerator.getInstance();


    public void start(Socket clientSocket) {

        try {
            responseStream = new ObjectOutputStream(clientSocket.getOutputStream());
            requestStream = new ObjectInputStream(clientSocket.getInputStream());
            while (process) {
                sendMessage(messageGenerator.welcomeMessage());

                Thread.sleep(1000);

                Object[] response = readResponseObject();
                System.out.printf("Client choice mode %s. Proceed...", response[0]);
                doTask(response);
            }

        } catch (IOException e) {
            System.err.printf("IOException at Server level", e);
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.printf("InterruptedException at Server level", e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.printf("Class not found at Server level", e);
        } finally {

        }

    }

    public void sendMessage(String message) throws IOException {
        responseStream.writeUTF(message);
        responseStream.flush();
    }

    private Object[] readResponseObject() throws IOException, ClassNotFoundException {
        return (Object[]) requestStream.readObject();
    }

    private String readResponse() throws IOException {
        return requestStream.readUTF();
    }

    public void doTask(Object[] clientRequest) throws IOException {
        switch ((String) clientRequest[0]) {
            case "1" -> {
                responseStream.writeObject(textService.getText());
                responseStream.flush();
            }
            case "2" -> {
                responseStream.writeObject(textService.getMaxCountOfSentencesWithRepeatedWord());
                responseStream.flush();
            }
            case "3" -> {
                responseStream.writeObject(textService.getWordInFirstSentenceThatNotExistInOthers());
                responseStream.flush();
            }
            case "4" -> {
                responseStream.writeObject(textService.getUniqueWordsFromQuestions(Integer.parseInt((String) clientRequest[1])));
                responseStream.flush();
            }
            case "5" -> {
                responseStream.writeObject(textService.swapFirstAndLastWordEverySentence());
                responseStream.flush();
            }
            case "6" -> {
                responseStream.writeObject(textService.getListOfWordsByAlphabet());
                responseStream.flush();
            }
            case "7" -> {
                responseStream.writeObject(textService.getListOfWordsSortedByVowelPercentage());
                responseStream.flush();
            }
            case "8" -> {
                responseStream.writeObject(textService.getListOfWordsSortedByCountOfLetterAsc(clientRequest[1].toString().charAt(0)));
                responseStream.flush();
            }
            case "9" -> {
                responseStream.writeObject(textService.getListOfWordsSortedByCountOfSentences((List<Word>) clientRequest[1]));
                responseStream.flush();
            }
            case "10" -> {
                String[] params = (String[]) clientRequest[1];
                responseStream.writeObject(textService.removeSubstringEverySentence(params[0].charAt(0), params[1].charAt(0)));
                responseStream.flush();
            }
            case "11" -> {
                responseStream.writeObject(textService.removeWordsStartsWithConsonants(Integer.parseInt(clientRequest[1].toString())));
                responseStream.flush();
            }
            case "12" -> {
                responseStream.writeObject(textService.getListOfWordsSortedByCountOfLetterDesc(clientRequest[1].toString().charAt(0)));
                responseStream.flush();
            }
            case "13" -> {
                responseStream.writeObject(textService.removeStartLettersFromWords());
                responseStream.flush();
            }
            case "14" -> {
                String[] params = (String[]) clientRequest[1];
                responseStream.writeObject(textService.replaceWordsToSubString(Integer.parseInt(params[0]), String.valueOf(params[1])));
                responseStream.flush();
            }
            case "15" -> {
                responseStream.writeObject(textService.getListOfWordsThatBeginsWithVowel());
                responseStream.flush();
            }
            case "16" -> {
                responseStream.writeObject(textService.getAllSentencesByQuantityOfWords());
                responseStream.flush();
            }
            case "17" -> process = false;
        }
    }
}
