package server;

public class MessageGenerator {

    private static MessageGenerator instance = new MessageGenerator();

    private MessageGenerator() {
    }

    public static MessageGenerator getInstance() {
        return instance;
    }

    public String welcomeMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, User!\n");
        stringBuilder.append("1) Get text\n");
        stringBuilder.append("2) Get max count of sentences with repeated word\n");
        stringBuilder.append("3) Get word in first sentence that not exist in others\n");
        stringBuilder.append("4) Get unique words from questions (int length)\n");
        stringBuilder.append("5) Swap first and last word every sentence\n");
        stringBuilder.append("6) Get list of words by alphabet\n");
        stringBuilder.append("7) Get list of words sorted by vowel percentage\n");
        stringBuilder.append("8) Get list of words sorted by count of letter asc (char letter)\n");
        stringBuilder.append("9) Get list of words sorted by count of sentences (List<Word> words)\n");
        stringBuilder.append("10) Remove substring every sentence (char startChar,char endChar)\n");
        stringBuilder.append("11) Remove words starts with consonants(int length)\n");
        stringBuilder.append("12) Get list of words sorted by count of letter desc(char letter)\n");
        stringBuilder.append("13) Remove start letters from words\n");
        stringBuilder.append("14) Replace words to substring (int length,String subString)\n");
        stringBuilder.append("15) Get list of words that begins with vowel\n");
        stringBuilder.append("16) Get all sentences by quantity of words\n");

        return stringBuilder.toString();
    }

}
