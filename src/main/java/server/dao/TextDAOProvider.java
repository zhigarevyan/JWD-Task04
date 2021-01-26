package server.dao;

import server.dao.impl.TextDAOImpl;

public class TextDAOProvider {

    private static TextDAO textDAOInstance;

    public static TextDAO getTextDAO() {
        if(textDAOInstance ==null){
            textDAOInstance = new TextDAOImpl();
        }
        return textDAOInstance;
    }
}
