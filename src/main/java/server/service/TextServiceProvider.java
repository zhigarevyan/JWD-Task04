package server.service;

import server.service.impl.TextServiceImpl;

public class TextServiceProvider {
    private static TextService textServiceInstance;

    public static TextService getTextService() {
        if(textServiceInstance ==null){
            textServiceInstance = new TextServiceImpl();
        }
        return textServiceInstance;
    }
}
